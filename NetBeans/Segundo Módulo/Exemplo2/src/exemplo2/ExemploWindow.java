package exemplo2;

  import java.awt.event.WindowEvent;
  import java.awt.event.WindowListener;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  
  public class ExemploWindow implements WindowListener {
      
      // Criação da tela e seus componentes
      JFrame frame = new JFrame("Teste de eventos");
      JFrame frame2 = new JFrame("Tela de teste 2");
      JLabel texto = new JLabel("Tela 1");
      JLabel texto2 = new JLabel("Tela 2");
      
  
      // Método construtor para sempre que "ExemploWindow()" for chamado iniciarmos com essas configurações
      ExemploWindow() {
          
          // Configuração da tela e seus componentes
          texto.setBounds(5,5,150,20);    
          texto2.setBounds(5,5,150,20);   
          
          frame.add(texto);
          frame.setSize(300,300);
          frame.setLayout(null);
          frame.setVisible(true);  
          
          frame2.add(texto2);
          frame2.setSize(300,300);
          frame2.setLayout(null);
          frame2.setVisible(true);  
  
          // Adicionarmos o ouvinte aos componentes
          frame2.addWindowListener(this);
      }
      
      @Override
      public void windowOpened(WindowEvent e) {
          
      }
  
      @Override
      public void windowClosing(WindowEvent e) {
          if (e.getSource() == frame2) {
              texto.setText("Você fechou a tela 2");
          }        
      }
  
      @Override
      public void windowClosed(WindowEvent e) {
  
      }
  
      @Override
      public void windowIconified(WindowEvent e) {
          
      }
  
      @Override
      public void windowDeiconified(WindowEvent e) {
          
      }
  
      @Override
      public void windowActivated(WindowEvent e) {
          if (e.getSource() == frame2) {
              texto2.setText("Você entrou na tela 2");
          }
      }
  
      @Override
      public void windowDeactivated(WindowEvent e) {
          if (e.getSource() == frame2) {
              texto2.setText("Você saiu da tela 2");
          }       
      }
  
      
      // Executamos o projeto
      public static void main(String[] args) {
          new ExemploWindow();
      }       
  }             

//windowActivated(WindowEvent e): é invocado quando se define a janela como a janela ativa.
//windowClosed(WindowEvent e): é invocado quando uma janela foi fechada como resultado da chamada de descarte na janela.
//windowClosing(WindowEvent e): é invocado quando o usuário tenta fechar a janela no menu do sistema da janela.
//windowDeactivated(WindowEvent e): é invocado quando uma janela não é mais a janela ativa.
//windowDeiconified(WindowEvent e): é invocado quando uma janela é alterada de um estado minimizado para um estado normal.
//windowIconified(WindowEvent e): é invocado quando uma janela é alterada de um estado normal para um estado minimizado.
//windowOpened(WindowEvent e): é invocado na primeira vez que uma janela se torna visível.
     