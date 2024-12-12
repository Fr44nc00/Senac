package sorveteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuariosDAO {
    public static UsuarioLogin validarUsuario(UsuarioLogin ul) {
        String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";
        UsuarioLogin usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "sorveteria", "root", "simone04");
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, ul.getLogin());
            statement.setString(2, ul.getSenha());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new UsuarioLogin();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipoUsu(rs.getString("tipoUsu"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;
    }
    
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
    
    public int cadastrar(Usuarios usuarios){
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO Usuario(login,senha,cpf,"
                    + "telefone,tipoUsu,nomeCompleto) VALUES(?,?,?,?,?,?)");
            st.setString(1, usuarios.getLogin());
            st.setString(2, usuarios.getSenha());
            st.setString(3, usuarios.getCpf());
            st.setDouble(4, usuarios.getTelefone());
            st.setString(5, usuarios.getTipoUsu());
            st.setString(6, usuarios.getNomeCompleto());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar dados do usuário: "
                    + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public void excluir (int id){
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados do usuário: "
                    + e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            //pode-se deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
    
    public List<Usuarios> getUsuarios() { 
        conectar();
        String sql = "SELECT * FROM Usuario";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();            

            List<Usuarios> listaUsuarios = new ArrayList<>();
            
            while (rs.next()) {
                Usuarios usu = new Usuarios();
                usu.setId(rs.getInt("id"));
                usu.setLogin(rs.getString("login"));
                usu.setSenha(rs.getString("senha"));
                usu.setCpf(rs.getString("cpf"));
                usu.setTelefone(rs.getDouble("telefone"));
                usu.setTipoUsu(rs.getString("tipoUsu"));
                usu.setNomeCompleto(rs.getString("nomeCompleto"));
                
                listaUsuarios.add(usu);
            }
            
            rs.close();
            stmt.close();
            conn.close();
            return listaUsuarios;

        } catch (Exception e) {
            return null;
        }

    }
}
