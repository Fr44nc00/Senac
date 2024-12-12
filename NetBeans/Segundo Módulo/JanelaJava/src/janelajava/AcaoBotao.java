package janelajava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

  class AcaoBotao implements ActionListener {

      private JTextField campoNome;

      public AcaoBotao(JTextField campoNome) {
          this.campoNome = campoNome;
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(null, "Boas vindas " + campoNome.getText() + "!");
      }
  }

//Como essa é uma classe separada e precisa-se do valor digitado, inclui-se uma referência ao campo (JTextField) no qual o nome será digitado e essa referência será preenchida no construtor da classe. No método actionPerformed(), que executará quando a ação (o clique) do botão ocorrer, obtém-se o valor digitado por meio do método getText() de JTextField.
//No código de main(), então, aplica-se o método addActionListener()
