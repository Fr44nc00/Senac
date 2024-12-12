document.addEventListener("DOMContentLoaded", () => {
    const botaoTrocaTema = document.getElementById("botao-troca-tema");
    const linkTema = document.getElementById("tema");

    const trocarTema = () => {
        const temaAtual = linkTema.getAttribute("href");
        const novoTema = temaAtual.includes("style-claro.css")
            ? "/css/style-escuro.css"
            : "/css/style-claro.css";

        linkTema.setAttribute("href", novoTema);

        document.cookie = `theme=${novoTema};path=/;max-age=31536000`;
    };

    const cookies = document.cookie.split("; ").reduce((acc, cookie) => {
        const [key, value] = cookie.split("=");
        acc[key] = value;
        return acc;
    }, {});

    if (cookies.theme) {
        linkTema.setAttribute("href", cookies.theme);
    }

    botaoTrocaTema.addEventListener("click", trocarTema);
});