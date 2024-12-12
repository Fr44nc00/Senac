/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

/**
 *
 * @author Christopher
 */

public class ProdutoValidator {
    public boolean validar(ProdutoEntity produto) {
        return produto != null && !produto.getNome().isEmpty();
    }
}
