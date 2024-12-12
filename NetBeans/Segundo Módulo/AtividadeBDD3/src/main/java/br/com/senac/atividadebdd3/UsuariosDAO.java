package br.com.senac.atividadebdd3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {
    public static Usuarios validarUsuario(Usuarios usuarios) {
        //Criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuarios usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "cenaflix2", "root", "simone04");
            PreparedStatement statement = conexao.prepareStatement(sql);

            //Atribuindo os valores na consulta
            statement.setString(1, usuarios.getLogin());
            statement.setString(2, usuarios.getSenha());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Usuarios();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;
    }    
}