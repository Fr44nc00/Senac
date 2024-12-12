$(document).ready(function () {
    const baseURL = "http://localhost:8080/filmes-catalogo";
    const filmeId = new URLSearchParams(window.location.search).get("id");

    function carregarDetalhes() {
        $.get(`${baseURL}/filmes/${filmeId}`, function (filme) {
            $("#titulo-filme").text(filme.titulo);
            $("#sinopse-filme").text(filme.sinopse);
            $("#genero-filme").text(filme.genero);
            $("#anoLancamento-filme").text(filme.anoLancamento);
        }).fail(function () {
            alert("Erro ao carregar os detalhes do filme.");
        });
        
        $.get(`${baseURL}/filmes/${filmeId}/analises`, function (analises){
            if (analises && analises.length > 0) {
                const rows = analises.map(analise => `
                    <li>
                        <p>${analise.detalhes}</p>
                        <p>Nota: ${analise.nota}</p>
                        <button class="btn-atualizar-analise" data-id="${analise.id}">Atualizar</button>
                        <button class="btn-deletar-analise" data-id="${analise.id}">Deletar</button>
                    </li>
                `);
                $("#lista-analises").html(rows.join(""));
            } else {
                $("#lista-analises").html("<li>Não há análises disponíveis.</li>");
            }
        });
    }
    
    $(document).on("click", ".btn-atualizar-analise", function () {
        const id = $(this).data("id");
        const idFilme = filmeId;
        window.location.href = `atualizar-analise.html?id=${id}&idFilme=${filmeId}`;
    });

    $(document).on("click", ".btn-deletar-analise", function () {
        const analiseId = $(this).data("id");
        $.ajax({
            url: `${baseURL}/analises/${analiseId}`,
            type: "DELETE",
            success: carregarDetalhes,
            error: function () {
                alert("Erro ao deletar a análise.");
            }
        });
    });

    $("#btn-adicionar-analise").click(function () {
        window.location.href = `informar-analise.html?id=${filmeId}`;
    });

    carregarDetalhes();
});