$(document).ready(function () {
    const baseURL = "http://localhost:8080/filmes-catalogo";

    function carregarFilmes() {
        $.get(`${baseURL}/filmes`, function (filmes) {
            console.log(filmes);

            const rows = filmes.map(filme => `
                <tr>
                    <td>${filme.id}</td>
                    <td><a href="detalhes-filme.html?id=${filme.id}">${filme.titulo}</a></td>
                    <td>${filme.genero}</td>
                    <td>${filme.anoLancamento}</td>
                    <td>
                        <button class="btn-atualizar" data-id="${filme.id}">Atualizar</button>
                        <button class="btn-deletar" data-id="${filme.id}">Deletar</button>
                    </td>
                </tr>
            `);
            $("#filmes-lista tbody").html(rows.join(""));
        }).fail(function () {
            alert("Erro ao carregar filmes.");
        });
    }

    $(document).on("click", ".btn-deletar", function () {
        const id = $(this).data("id");
        $.ajax({
            url: `${baseURL}/filmes/${id}`,
            type: "DELETE",
            success: carregarFilmes,
            error: function () {
                alert("Erro ao deletar filme.");
            }
        });
    });

    $(document).on("click", ".btn-atualizar", function () {
        const id = $(this).data("id");
        window.location.href = `atualizar-filme.html?id=${id}`;
    });

    carregarFilmes();
});