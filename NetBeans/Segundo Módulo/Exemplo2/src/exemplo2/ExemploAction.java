package exemplo2;

  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;

  public class ExemploAction implements ActionListener {
      
      // Criação da tela e seus componentes
      JFrame frame = new JFrame("Teste de eventos");
      JLabel texto = new JLabel();
      JButton botao = new JButton("Clique");

      // Método construtor para sempre que "Exemplo()" for chamado iniciarmos com essas configurações
      ExemploAction() {
          
          // Configuração da tela e seus componentes
          frame.add(texto);
          frame.add(botao);
          frame.setSize(300,300);
          frame.setLayout(null);
          frame.setVisible(true);  
          texto.setBounds(10,80, 300,50);    
          botao.setBounds(100,10, 100,30);    
          
          
          // Adicionarmos o ouvinte aos componentes
          botao.addActionListener(this);
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
          if(e.getSource() == botao) {
              System.out.println(e.getSource());
              texto.setText("O botão foi pressionado!");
          } 
      }
      
      // Executamos o projeto
      public static void main(String[] args) {
          new ExemploAction();
      }   
  }

//actionPerformed(ActionEvent e): é invocado quando ocorre uma ação.
//Perceba que o método actionPerformed() recebe como argumento “e” do tipo ActionEvent. Esse argumento será responsável por saber exatamente em qual componente ocorreu o evento e armazenará essa informação no método getSource(). Então, na prática, para saber se o botão foi clicado ou não, basta identificar o que está guardado em e.getSource(). Para visualizar isso, utilize o System.out.println(e.getSource()) para imprimir no console quais informações o getSource() identificou.
//Repare que as informações impressas no console tratam-se do código-fonte do componente mesmo:
//javax.swing.JButton[,100,10,100x30,alignmentX=0.0,alignmentY=0.5,border=javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@3a298dbe,flags=296,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,disabledSelectedIcon=,margin=javax.swing.plaf.InsetsUIResource[top=2,left=14,bottom=2,right=14],paintBorder=true,paintFocus=true,pressedIcon=,rolloverEnabled=true,rolloverIcon=,rolloverSelectedIcon=,selectedIcon=,text=Abrir,defaultCapable=true]
//Isso é muito útil quando se tem vários elementos na tela e é necessário identificar qual foi responsável por ativar o evento.
                