package janelajava;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class JanelaJava {

    public static void main(String[] args) {
    JFrame janela = new JFrame();
    janela.setSize(300, 200);
    janela.setTitle("Minha 1ª Janela!");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setLayout(new FlowLayout());
    
    //criando label
    JLabel rotulo = new JLabel();
    rotulo.setText("Digite seu nome");
    janela.add(rotulo);
    
    //criando campo de entrada
    JTextField campo = new JTextField(10);
    janela.add(campo);
    
    //criando botão
    JButton botao = new JButton();
    botao.setText("Clique aqui");
    janela.add(botao);
    
    botao.addActionListener(new AcaoBotao(campo));
    
    janela.setVisible(true);
  }
}

//JFrame janela = new JFrame(); – Cria em memória a janela, ou seja, o objeto de janela é criado.
//janela.setSize(300, 200); – Ajusta o tamanho da janela para largura de 300 pixels e altura de 200 pixels.
//janela.setVisible(true); – Torna a janela visível. Note que, se não houver esta linha de código, a janela não aparecerá na tela.
//O método setTitle() de jFrame (objeto “janela”) permite que se configure um título para aparecer na barra superior da tela.
//O método setDefaultCloseOperation() define o que o programa deve fazer quando se clicar no botão X. Por padrão, apenas esconderá a janela, mas o código está sendo configurado para que feche a aplicação (EXIT_ON_CLOSE).
//Como se pode então incluir elementos nesta janela? Tente embutindo um botão e uma etiqueta textual. Para o botão, utiliza-se a classe JButton da biblioteca Swing e, para rótulos, JLabel. Note a seguir as linhas destacadas no código da inclusão da etiqueta.
//Rode a aplicação e note que não haverá nenhuma diferença na tela. Isso acontece porque, apesar de se estar criando a etiqueta, ela não está sendo associada à janela à qual ela deve pertencer. Para isso, será preciso usar o método add() da classe JFrame.
//Um dos layouts mais básicos é o FlowLayout, que organiza os componentes visuais em linha e, caso não haja espaço na largura da janela, posiciona o componente uma linha abaixo.
//Para expandir esta pequena aplicação, inclua um componente de caixa de texto para capturar informação do usuário. Utilize para isso a classe JTextField. Note no código que se trocou o texto da etiqueta e criou-se um objeto JTextField chamado “campo”, com dez colunas (uma medida de Java para definir a largura do campo).
//No código de main(), então, aplica-se o método addActionListener()
//Pode-se substituir a classe "AcaoBotao" pela linha de código:
//
//botao.addActionListener(new ActionListener(){
//      @Override
//      public void actionPerformed(ActionEvent e) {
//          JOptionPane.showMessageDialog(janela, "Boas vindas " + campo.getText() + "!");
//      }
//});
