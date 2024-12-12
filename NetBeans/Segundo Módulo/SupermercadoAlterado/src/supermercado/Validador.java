package supermercado;

public class Validador {
    public boolean validar(ProdutoEntity produto) {
        return produto != null && !produto.getNome().isEmpty();
    }
}
