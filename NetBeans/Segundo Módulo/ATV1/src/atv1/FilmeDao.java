/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1;

import Frame.CinaFlix;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilmeDao {
    
    
    Connection conn=null;
    PreparedStatement st;
    ResultSet rs;
    
    
    public boolean conectar(){
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atividade1","root","Raissa13022007");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
    
    
    public int salvar(Filme film){
        int status;
        
        
        
        
        try {
            st = conn.prepareStatement("INSERT INTO funcionarios VALUES(?,?,?,?)");
            st.setString(2,film.getNome());
            st.setDate(3, (Date) film.getData());
            st.setString(4,film.getCategoria());
          
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
     public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            
        }
    }
    
    
    
}
