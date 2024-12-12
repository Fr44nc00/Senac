//pacote
package OutrasClasses; 

//importando as bibliotecas necessárias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FilmesDAO {
    //declarando variáveis
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    int id = 1;
    
    //função realizada para se conectar com o banco de dados
    public boolean conectar(){
        try {
            //driver que torna a conexão possível
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se conectando com o banco
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflix",
                    "root","");
            //essa linha deve ser alterada dependendo do banco usado
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            //mensagem de erro caso o programa não consiga se conectar com o banco de dados
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
    //função realizada para cadastrar um novo filme no banco de dados
    public int cadastrar(Filmes filmes){
        //declarando a variável
        int status;
        try {
            //preparando a string sql com o código de inserção para o banco de dados
            st = conn.prepareStatement("INSERT INTO filmes(nome, datalancamento, categoria)"
                    + "VALUES(?,?,?)");
            //setando os parâmetros
            st.setString(1, filmes.getNome());
            st.setDate(2, filmes.getData());
            st.setString(3, filmes.getCategoria());
            //executando a query
            status = st.executeUpdate();
            //retornando o valor da query
            return status;
        } catch (SQLException ex) {
            //mensagem de erro caso o programa não consiga se conectar com o banco de dados
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar dados do filme: "
                    + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    //função realizada para atualizar os dados de um filme já cadastrado no banco
    public void atualizar (Filmes filmes){
        //string sql com o código de update para o banco de dados
        String sql = "UPDATE filmes SET nome=?, datalancamento=?, categoria=? WHERE id=?";
        try {
            //preparando o código que será escrito no MySQL
            PreparedStatement stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            //setando os parâmetros
            stmt.setString(1, filmes.getNome());
            stmt.setDate(2, filmes.getData());
            stmt.setString(3, filmes.getCategoria());
            stmt.setInt(4, filmes.getId());
            //executando a query
            stmt.executeUpdate();
        } catch (Exception e) {
            //mensagem de erro caso o programa não consiga se conectar com o banco de dados
            JOptionPane.showMessageDialog(null,"Erro ao atualizar dados do filme: "
                    + e.getMessage());
        }
    }

    //função realizada para excluir os dados de um filme no banco de dados
    public void excluir (int id){
        //string sql com o código de exclusão para o banco de dados
        String sql = "DELETE FROM filmes WHERE id = ?";
        try {
            //preparando o código que será escrito no MySQL
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //setando o parâmetro
            stmt.setInt(1, id);

            //executando a query
            stmt.executeUpdate();
        } catch (Exception e) {
            //mensagem de erro caso o programa não consiga se conectar com o banco de dados
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados do filme: "
                    + e.getMessage());
        }

    }
    
    //função realizada para encontrar um filme usando seu ID
    public Filmes getFilme (int id){
        //string sql com o código de busca de dados
        String sql = "SELECT * FROM filmes WHERE id = ?";
        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //Como temos um parâmetro, devemos defini-lo
            stmt.setInt(1, id);
            
            //Método para poder executar o SELECT.
            //Os resultados obtivos pela consulta serão armazenados na variavel ResultSet
            ResultSet rs = stmt.executeQuery();

            //declarando a classe como uma variável
            Filmes filmes = new Filmes();
            
            rs.next();
            //salvar dentro do objeto filmes as informações
            filmes.setId(id);
            filmes.setNome(rs.getString("nome"));
            filmes.setData(rs.getDate("datalancamento"));
            filmes.setCategoria(rs.getString("categoria"));

            return filmes;

            //tratando o erro, caso ele ocorra
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    
    //função realizada para encontrar um filme usando seu nome
    public List<Filmes> getFilmeNome(String nome) { 
        conectar();
        //string sql com o código de busca de dados
        String sql = "SELECT * FROM filmes WHERE nome LIKE ?"; //LIKE nos permite 
        //pesquisar por partes de um nome, ao invés de pesquisarmos por todo nome

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //Como temos um parâmetro, devemos defini-lo
            stmt.setString(1,"%" + nome + "%"); //Conforme for a palavra ou letra
            //digitada para pesquisa, será buscada antes, no meio e no fim
            
            //Método para poder executar o SELECT.
            //Os resultados obtivos pela consulta serão armazenados na variavel ResultSet
            ResultSet rs = stmt.executeQuery();            

            //Vamos criar um objeto do tipo List
            //Faça a importação do ArrayList
            List<Filmes> listaFilmes = new ArrayList<>();
            //percorrer o resultSet e salvar as informações dentro de uma variável "Filmes"
            //depois salva esse objeto dentro da lista

            //Estrutura de repetição While
            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição
                //dentro do array
                Filmes filmes = new Filmes();
                //salvar dentro do objeto filmes as informações            
                filmes.setId(rs.getInt("id"));
                filmes.setNome(rs.getString("nome"));
                filmes.setData(rs.getDate("datalancamento"));
                filmes.setCategoria(rs.getString("categoria"));
                //adicionando os elementos na lista criada
                listaFilmes.add(filmes);

            }
            //após finalizar o while, o retorno será a listaFilmes, onde cada posição é um
            //registro do banco de dados
            return listaFilmes;

            //Se o método entrar no "Catch" quer dizer que não encontrou nenhum filme,
            //então damos um "return null"
        } catch (Exception e) {
            return null;
        }

    }
    
    //função realizada para encontrar um filme usando sua categoria
    public List<Filmes> getFilmeCategoria(String categoria) {
        conectar();
        //string sql com o código de busca de dados
        String sql = "SELECT * FROM filmes WHERE categoria LIKE ?"; //LIKE nos permite 
        //pesquisar por partes de uma categoria, ao invés de pesquisarmos por todo categoria

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //Como temos um parâmetro, devemos defini-lo
            stmt.setString(1,"%" + categoria + "%"); //Conforme for a palavra ou letra
            //digitada para pesquisa, será buscada antes, no meio e no fim
            
            //Método para poder executar o SELECT.
            //Os resultados obtivos pela consulta serão armazenados na variavel ResultSet
            ResultSet rs = stmt.executeQuery();            

            //Vamos criar um objeto do tipo List
            //Faça a importação do ArrayList
            List<Filmes> listaFilmes = new ArrayList<>();
            //percorrer o resultSet e salvar as informações dentro de uma variável "Filmes"
            //Depois salva esse objeto dentro da lista

            //Estrutura de repetição While
            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição
                //dentro do array
                Filmes filmes = new Filmes();
                //Salvar dentro do objeto empresa as informações            
                filmes.setId(rs.getInt("id"));
                filmes.setNome(rs.getString("nome"));
                filmes.setData(rs.getDate("datalancamento"));
                filmes.setCategoria(rs.getString("categoria"));
                //Adicionando os elementos na lista criada
                listaFilmes.add(filmes);

            }
            //Após finalizar o while, o retorno será a listaEmpresas, onde cada posição é um
            //registro do banco de dados
            return listaFilmes;

            //Se o método entrar no "Catch" quer dizer que não encontrou nenhum filme,
            //então damos um "return null"
        } catch (Exception e) {
            return null;
        }

    }
    
    //função realizada para desconectar o banco de dados
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            //pode-se deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}
