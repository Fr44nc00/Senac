$(document).ready(function () {
    const baseURL = "http://localhost:8080/filmes-catalogo";
    const filmeId = new URLSearchParams(window.location.search).get("id");

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
            url: `${baseURL}/analises`,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(analise),
            success: function () {
                window.location.href = `detalhes-filme.html?id=${filmeId}`;
            },
            error: function () {
                alert("Erro ao salvar a análise.");
            }
        });
    });
});