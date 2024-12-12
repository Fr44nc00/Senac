package supermercado;
        
public class ProdutoController {
    private Repositório repositorio = new Repositório();
    private ServiçoMensagem servicomensagem = new ServiçoMensagem();
    private Validador validador = new Validador();

    public boolean salvarproduto(ProdutoEntity produto) {
        if (validador.validar(produto)) {
            repositorio.salvar(produto);
            servicomensagem.enviarmensagem();
            return true;
        } else {
            return false;
        }
    }
}