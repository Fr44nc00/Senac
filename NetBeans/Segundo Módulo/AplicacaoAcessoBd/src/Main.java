import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        try {
            Conexao conector = new Conexao();
            conector.conectar();
            
            Statement st = conector.conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM usuario"); //variavel da classe ResultSet para receber o valor da consulta
            rs.next();
            System.out.println(rs.getInt("COUNT(*)"));
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//Você faria isso dentro da classe main, o que não é recomendado:
//try {
    //Connection conn; //criando um objeto do tipo connection chamado conn
    //Statement st; //criando um objeto do tipo Statement chamado st para  execução de comando SQL
    //Class.forName("com.mysql.cj.jdbc.Driver");//driver dentro de Libraries, na jarra
    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo_senac","root","simone04");
    //O comando DriverManager.getConnection() recebe como padrão três parâmetros.
    //O primeiro parâmetro deve indicar o nome do banco de dados que será utilizado
    //para estabelecer a conexão junto à porta que é utilizada –
    //- no caso do MySQL, a porta padrão é a 3306.
    //Além de informar o número da porta, você também deve informar o local
    //em que o MySQL está sendo executado. Neste exemplo, será utilizado o localhost,
    //ou seja, a execução do MySQL ocorre em sua própria máquina; caso estivesse sendo
    //executado em um servidor que opera na rede, seria necessário informar o endereço
    //IP do equipamento.
    //O segundo parâmetro é o usuário. Como padrão, o MySQL instala o usuário “root”.
    //O terceiro parâmetro é a senha que foi configurada na instalação do MySQL para
    //o usuário “root”. Caso o usuário tenha sido criado sem senha, não é necessário
    //informar. Esses parâmetros devem estar entre aspas duplas e, caso não exista
    //senha, basta você apenas abrir e fechar aspas vazias.
    //st = conn.createStatement();
//} catch (ClassNotFoundException ex) {
    //System.out.println("O Driver não está disponível na biblioteca");
//} catch (SQLException ex) {
    //System.out.println("Sintaxe de comando invalida");
//}