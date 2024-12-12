$(document).ready(function () {
    const baseURL = "http://localhost:8080/filmes-catalogo";
    const id = new URLSearchParams(window.location.search).get('id');

    $.get(`${baseURL}/filmes/${id}`, function (data) {
        $('#titulo').val(data.titulo);
        $('#sinopse').val(data.sinopse);
        $('#genero').val(data.genero);
        $('#anoLancamento').val(data.anoLancamento);
    }).fail(function () {
        alert("Erro ao carregar dados do filme.");
    });

    $("#form-atualizar-filme").on("submit", function (e) {
        e.preventDefault();
        const filme = {
            titulo: $("#titulo").val(),
            sinopse: $("#sinopse").val(),
            genero: $("#genero").val(),
            anoLancamento: $("#anoLancamento").val()
        };

        $.ajax({
            url: `${baseURL}/filmes/${id}`,
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(filme),
            success: function () {
                alert("Filme atualizado com sucesso!");
                window.location.href = "listar-filmes.html";
            },
            error: function () {
                alert("Erro ao atualizar filme.");
            }
        });
    });
});