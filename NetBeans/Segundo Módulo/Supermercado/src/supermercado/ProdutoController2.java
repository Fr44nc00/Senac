/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

/**
 *
 * @author venec
 */

public class ProdutoController {
    private ProdutoValidator validator = new ProdutoValidator();
    private ProdutoRepository repository = new ProdutoRepository();
    private MensagemService mensagemService = new MensagemService();

    public boolean salvarProduto(ProdutoEntity produto) {
        if (validator.validar(produto)) {
            repository.salvar(produto);
            mensagemService.enviarMensagem();
            return true;
        } else {
            return false;
        }
    }
}

