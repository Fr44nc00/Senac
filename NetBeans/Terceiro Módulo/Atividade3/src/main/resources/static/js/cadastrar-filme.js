$(document).ready(function () {
    const baseURL = "http://localhost:8080/filmes-catalogo";

    $("#form-cadastro-filme").on("submit", function (e) {
        e.preventDefault();
        const filme = {
            titulo: $("#titulo").val(),
            sinopse: $("#sinopse").val(),
            genero: $("#genero").val(),
            anoLancamento: $("#anoLancamento").val()
        };

        $.ajax({
            url: baseURL,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(filme),
            success: function () {
                window.location.href = "listar-filmes.html";
            },
            error: function () {
                alert("Erro ao cadastrar filme");
            }
        });
    });
});