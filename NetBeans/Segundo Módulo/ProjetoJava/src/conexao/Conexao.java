package conexao;
            
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/exemplojavabd ", // linha de conexao
                "root", // usuario do mysql
                "simone04"// senha do mysql
            );
            return conn;

        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }

    }

}
