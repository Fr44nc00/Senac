package br.com.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoMySql {

    //Nessa classe, você fará uma conexão apontando diretamente a URL (uniform resource locator)
    //na qual está o banco de dados; passará usuário e senha para a conexão e criará o método
    //para realizar a conexão (não é uma boa prática passar usuário e senha sem criptografia
    //para conexão com o banco de dados).
    public Connection getConnection() {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/principal",
                    "root", "simone04");
            return conexao;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

}
