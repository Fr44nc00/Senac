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

    public boolean salvarProduto(ProdutoEntity produto) {
        
        if (this.validacao(produto)){
            //... salvar no banco de dados ..//
            this.enviarMensagem();
            return true;
        } else {
            return false;
        }
    }
    
    public void enviarMensagem(){
        //enviar mensagem 
    }
    
    public boolean validacao(ProdutoEntity produto){
        
        if (produto.getNome().equals("")){
            return false;
        } else {   
            return true;
        }
        
    }
        
}
