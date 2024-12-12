package sorveteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutosDAO {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorveteria",
                    "root","simone04");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
    public int cadastrar(Produtos produtos){
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO Produto(nome,descricao,"
                    + "quantidade,preco) VALUES(?,?,?,?)");
            st.setString(1, produtos.getNome());
            st.setString(2, produtos.getDescricao());
            st.setString(3, produtos.getQuantidade());
            st.setDouble(4, produtos.getPreco());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar dados do produto: "
                    + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public void excluir (int id){
        String sql = "DELETE FROM Produto WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados do produto: "
                    + e.getMessage());
        }

    }
    
    public List<Produtos> getProdutos() { 
        conectar();
        String sql = "SELECT * FROM Produto";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();            

            List<Produtos> listaProdutos = new ArrayList<>();
            
            while (rs.next()) {
                Produtos pro = new Produtos();
                pro.setId(rs.getInt("id"));
                pro.setNome(rs.getString("nome"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setQuantidade(rs.getString("quantidade"));
                pro.setPreco(rs.getDouble("preco"));
                
                listaProdutos.add(pro);
            }
            
            rs.close();
            stmt.close();
            conn.close();
            return listaProdutos;

        } catch (Exception e) {
            return null;
        }

    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            //pode-se deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}
