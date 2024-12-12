package exemplo2;

  import java.awt.event.KeyEvent;
  import java.awt.event.KeyListener;

  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JTextField;

  public class ExemploKey implements KeyListener {
      
  // Criação da tela e seus componentes
      JFrame frame = new JFrame("Teste de eventos");
      JLabel texto = new JLabel();
      JTextField digitado = new JTextField();

      // Método construtor para sempre que "Exemplo()" for chamado iniciarmos com essas configurações
      ExemploKey() {
          
          // Configuração da tela e seus componentes
          frame.add(texto);
          frame.add(digitado);
          frame.setSize(300,300);
          frame.setLayout(null);
          frame.setVisible(true);  
          texto.setBounds(10,80, 300,50);    
          digitado.setBounds(70,10, 150,20);    
          
          // Adicionarmos o ouvinte aos componentes
          digitado.addKeyListener(this);
      }
      
      @Override
      public void keyReleased(KeyEvent e) {
          if(e.getSource() == digitado) {
              texto.setText("O texto digitado foi: " + digitado.getText());
          }         
      }    
      
      @Override
      public void keyPressed(KeyEvent e) {
        
      }
      
      @Override
      public void keyTyped(KeyEvent e) {

      }

      // Executamos o projeto
      public static void main(String[] args) {
          new ExemploKey();
      }   
  }
           

//keyPressed(KeyEvent e): é invocado quando uma tecla é pressionada.
//keyReleased(KeyEvent e): é invocado quando uma tecla é solta.
//keyTyped(KeyEvent e): é invocado quando uma tecla foi digitada.