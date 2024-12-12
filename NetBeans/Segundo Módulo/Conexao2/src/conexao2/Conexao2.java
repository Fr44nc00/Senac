package conexao2;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Conexao2 {
    
    public static void main(String[] args) {
        try {
            
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            System.out.println( "Driver JDBC carregado" );
        } catch ( ClassNotFoundException cnfe ) {
            System.out.println( "Driver JDBC nao encontrado : " + cnfe.getMessage() );
        }

        Connection con = null;
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola","root","simone04");
            System.out.println( "Conexao com o banco de dados estabelecida." );
        } catch ( SQLException sqle ) {
            System.out.println( "Erro na conexao ao Bando de Dados : " + sqle.getMessage() );
        }
        
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            System.out.println( "Pronto para execucao de comandos sql." );
        } catch ( SQLException sqle ) {
            System.out.println( "Erro no acesso ao Bando de Dados : " + sqle.getMessage() );
        }
        
        try{
            String sql = null;

            sql = "insert into alunos (nome, idade, endereco) values ('Ana','23','Rua 7 de setembro 826')";
            stmt.executeUpdate(sql);
            System.out.println("Dados inseridos.");
        } catch (SQLException sqle ){
            System.out.println( "Erro inserindo : " + sqle.getMessage() );
        }
        
        try{
            String sql = null;
            sql = "delete from alunos where id =1";
            stmt.executeUpdate(sql);
            System.out.println("Dados removidos.");
        }catch (SQLException sqle ){
            System.out.println( "Erro remoção : " + sqle.getMessage() );
        }
        
        try{
            String sql = null;
            sql = "update alunos set idade = '58' where id =1";
            stmt.executeUpdate(sql);
            System.out.println("Dados atualizados.");
        }catch (SQLException sqle ){
            System.out.println( "Erro atualizacao : " +
            sqle.getMessage() );
        }
        
        //Para consultar os dados de uma tabela específica,
        //a lógica é a mesma já apresentada na inserção,
        //na atualização e na exclusão de dados.
        //Porém, agora será criado um objeto chamado rs do tipo ResultSet,
        //que é responsável pelos códigos de consulta no Java.
        //Além disso, agora se utiliza o comando executeQuery(sql)
        //para executar códigos de consulta no banco de dados por meio do Java.
        
        try {
            String sql = "select id,nome,idade,endereco from alunos" ;

            /* Executando o comando select */
            ResultSet rs = stmt.executeQuery(sql);

            /* Exibindo os resultados */
            while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int idade = rs.getInt("idade");
            String endereco = rs.getString("endereco");

            System.out.println("dados da tabela autor do banco de dados");
            System.out.println("--------------------------");
            System.out.println(id + " - " + nome + " - "+ idade+ " - "+ endereco);
        }
        } catch (SQLException sqle) {
            System.out.println( "Erro efetuando consulta : " + sqle.getMessage() );
        }
        
        //O diferencial maior do código de consulta está no looping
        //que é necessário fazer para percorrer todos os dados dentro de uma tabela.
        //Para isso, utiliza-se um comando while(rs.next()),
        //que percorre todos os campos de uma tabela do banco de dados.
        //Para mostrar os dados, é preciso salvar os resultados
        //dentro de variáveis, conforme o tipo de cada campo da tabela,
        //como no código a seguir: int id = rs.getInt("id"); 

        try {
            con.close();
            System.out.println( "Conexão com o banco de dados fechada" );
        } catch (SQLException sqle) {
            System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage() );
        }
        
        // Atualização de dados
        //
        //int idBusca,idadeNova;
        //Scanner IdFunc = new Scanner(System.in);
        //System.out.println("Informe o id que será atualizado");
        //idBusca = IdFunc.nextInt(); 
        //    
        //System.out.println("Informe a nova idade");
        //dadeNova = IdFunc.nextInt(); 
        //    
        //try{
        //    String sql = null;
        //    sql = "update alunos set idade = "+ idadeNova +" where id ="+ idBusca; 
        //    stmt.executeUpdate(sql);
        //    System.out.println("Dados atualizados.");
        //} catch (SQLException sqle ){
        //    System.out.println( "Erro atualizacao : " + sqle.getMessage() );
        //}
        
        //Exclusão de dados
        //
        //int idBusca;
        //Scanner IdFunc = new Scanner(System.in);
        //    
        //System.out.println("Informe o id da linha a ser excluída");
        //idBusca = IdFunc.nextInt(); 
        //
        //try{
        //    String sql = null;
        //    sql = "delete from alunos where id ="+idBusca;
        //    stmt.executeUpdate(sql);
        //    System.out.println("Dados removidos.");
        //} catch (SQLException sqle ){
        //    System.out.println( "Erro remocao : " + sqle.getMessage() );
        //}
        
        //Criando valores com Prepared Statement
        /* Objeto para executar comandos sql */
        PreparedStatement ps = null;
        String sql = "insert into alunos values (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,2);
            ps.setString(2, "Érico");
            ps.setInt(3,30);
            ps.setString(4, "Rua das araucárias 20");

            ps.executeUpdate();

            System.out.println( " Dados inseridos com sucesso." );
        } catch ( SQLException sqle ) {
            System.out.println( "Erro no acesso ao Bando de Dados : "+ sqle.getMessage());
        }

        /* Fechando a conexão */
        try {
            con.close();
            System.out.println( "Conexão com o banco de dados fechada" );
        } catch (SQLException sqle) {
            System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage());
        }
        
        //Atualizando valores com Prepared Statement
        PreparedStatement ps2 = null;
        String sql2 = "update alunos set nome = ? where id =1";

        try {
            ps2 = con.prepareStatement(sql2);
            ps2.setString(1,"Frederico");
            ps2.executeUpdate();

            System.out.println( "Dados atualizados com sucesso." );
        } catch ( SQLException sqle ) {
            System.out.println( "Erro no acesso ao Bando de Dados : "+ sqle.getMessage());
        }
        
        //Deletando valores com Prepared Statement
        PreparedStatement ps3 = null;
        String sql3 = "delete from alunos where id=?";

        try {
            ps3 = con.prepareStatement(sql3);
            ps3.setInt(1,2);
            ps3.executeUpdate();

            System.out.println( "Dados excluídos com sucesso." );
        } catch ( SQLException sqle ) {
            System.out.println( "Erro no acesso ao Bando de Dados : "+ sqle.getMessage());
        }
    }
    
}
