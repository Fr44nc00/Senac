package atividadejanelas1;

import javax.swing.JOptionPane;

public class AtividadeJanelas1 {

    public static void main(String[] args) {
        
        Double preco, desconto;
        
        JOptionPane.showMessageDialog(null, "Seja bem vindo.\nVamos calcular o MVP.");
        preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do produto:"));
        
        if(preco > 500.0){
            desconto = Double.parseDouble(JOptionPane.showInputDialog("Esse produto pode receber um desconto. Defina o valor do desconto:"));
            
            preco = preco - (preco * (desconto/100));
        }
        
        JOptionPane.showMessageDialog(null, "O valor do produto será R$" + preco + ".");
    }
    
}
