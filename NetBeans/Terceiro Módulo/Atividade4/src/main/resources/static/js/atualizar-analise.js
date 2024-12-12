$(document).ready(function () {
    const baseURL = "http://localhost:8080/filmes-catalogo";
    const analiseId = new URLSearchParams(window.location.search).get('id');
    const filmeId = new URLSearchParams(window.location.search).get('idFilme');
    
    if (filmeId) {
        $("#voltar-detalhes").attr("href", `detalhes-filme.html?id=${filmeId}`);
    }

    $.get(`${baseURL}/analises/${analiseId}`, function (analise) {
        $("#detalhes").val(analise.detalhes);
        $("#nota").val(analise.nota);
    }).fail(function () {
        alert("Erro ao carregar dados da análise.");
    });

    $("#form-analise").submit(function (e) {
        e.preventDefault();

        const analise = {
            detalhes: $("#detalhes").val(),
            nota: $("#nota").val(),
            filme: {
                id: filmeId 
            }
        };

        $.ajax({
            url: `${baseURL}/analises/${analiseId}`,
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(analise),
            success: function () {
                window.location.href = `detalhes-filme.html?id=${analise.filme.id}`;
            },
            error: function () {
                alert("Erro ao atualizar a análise.");
            }
        });
    });
});