package exemplo2;

  import java.awt.event.MouseEvent;
  import java.awt.event.MouseListener;
  import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  
  public class ExemploMouse implements MouseListener {
      
      // Criação da tela e seus componentes
      JFrame frame = new JFrame("Teste de eventos");
      JLabel texto = new JLabel();
      JButton botao = new JButton("Clique");
  
      // Método construtor para sempre que "Exemplo()" for chamado iniciarmos com essas configurações
      ExemploMouse() {
          
          // Configuração da tela e seus componentes
          frame.add(texto);
          frame.add(botao);
          frame.setSize(300,300);
          frame.setLayout(null);
          frame.setVisible(true);  
          texto.setBounds(10,80, 300,50);    
          botao.setBounds(100,10, 100,30);    
          
          
          // Adicionarmos o ouvinte aos componentes
          botao.addMouseListener(this);
      }
      
      @Override
      public void mouseClicked(MouseEvent e) {
          if(e.getSource() == botao) {
              texto.setText("Você clicou com o mouse.");
          }
      }
      
      @Override
      public void mousePressed(MouseEvent e) {
          if(e.getSource() == botao) {
              texto.setText("Você pressionou com o mouse.");
          }
      }
  
      @Override
      public void mouseEntered(MouseEvent e) {
          if(e.getSource() == botao) {
              texto.setText("Você está sobre o botão com o mouse.");
          }
      }
  
      
      @Override
      public void mouseExited(MouseEvent e) {
          
      }
      
      @Override
      public void mouseReleased(MouseEvent e) {
          
      }    
      
      // Executamos o projeto
      public static void main(String[] args) {
          new ExemploMouse();
      }       
  }                          
         
//mouseClicked(MouseEvent e): é invocado quando o botão do mouse é clicado (pressionado e liberado) em um componente.
//mouseEntered(MouseEvent e): é invocado quando o mouse entra em um componente.
//mouseExited(MouseEvent e): é invocado quando o mouse sai de um componente.
//mousePressed(MouseEvent e): é invocado quando um botão do mouse é pressionado em um componente.
//mouseReleased(MouseEvent e): é invocado quando um botão do mouse é liberado em um componente.
