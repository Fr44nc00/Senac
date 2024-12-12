package exemplo2;

  import java.awt.event.ItemEvent;
  import java.awt.event.ItemListener;
  import javax.swing.JCheckBox;
  import javax.swing.JFrame;
  import javax.swing.JLabel;

  public class ExemploItem implements ItemListener {
      
  // Criação da tela e seus componentes
      JFrame frame = new JFrame("Teste de eventos");
      JLabel texto = new JLabel();
      JCheckBox checkBox1 = new JCheckBox("CheckBox 1");
      JCheckBox checkBox2 = new JCheckBox("CheckBox 2");

      // Método construtor para sempre que "Exemplo()" for chamado iniciarmos com essas configurações
      ExemploItem() {
          
          // Configuração da tela e seus componentes
          frame.add(texto);
          frame.add(checkBox1);
          frame.add(checkBox2);
          frame.setSize(300,300);
          frame.setLayout(null);
          frame.setVisible(true);  
          texto.setBounds(10,80, 300,50);    
          checkBox1.setBounds(100,10, 150,50);    
          checkBox2.setBounds(100,50, 150,50);
          
          // Adicionarmos o ouvinte aos componentes
          checkBox1.addItemListener(this);
          checkBox2.addItemListener(this);
      }
      
      @Override
      public void itemStateChanged(ItemEvent e) {
          if(e.getSource() == checkBox1) {
              texto.setText("Status da CheckBox 1 mudou para " + e.getStateChange());
          }
          
          if(e.getSource() == checkBox2) {
              texto.setText("Status da CheckBox 2 mudou para " + e.getStateChange());
          }    
      }
      
      // Executamos o projeto
      public static void main(String[] args) {
          new ExemploItem();
      }   
  }

//itemStateChanged(ItemEvent e): é invocado quando um item foi selecionado ou desmarcado pelo usuário.
                        