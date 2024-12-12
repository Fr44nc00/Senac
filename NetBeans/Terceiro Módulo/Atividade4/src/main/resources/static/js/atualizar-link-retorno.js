$(document).ready(function () {
    const filmeId = new URLSearchParams(window.location.search).get("id");
    
    if (filmeId) {
        $("#voltar-detalhes").attr("href", `detalhes-filme.html?id=${filmeId}`);
    }
});