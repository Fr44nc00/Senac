
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.xml.bind.DatatypeConverter;
import java.awt.HeadlessException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JOptionPane;
import mercado.model.Usuario;

public class LoginDAO {
    
//  public boolean verificarSenha(String senhaDigitada, String senhaBanco) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(senhaDigitada.getBytes());
//            byte[] digest = md.digest();
//            String senhaDigitadaHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
//            return senhaDigitadaHash.equals(senhaBanco);
//        } catch (NoSuchAlgorithmException e) {
//
//            e.printStackTrace();
//            return false;
//        }
//    }
    
    
    ///preciso achar uma forma de confirmar senhas criptadas.
    
    public Usuario verificaLogin(String email, String senha) {
        EntityManager em = ConnectionFactory.getEntityManager();
        
        try {
            
            String jpql = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            Usuario usuario = query.getSingleResult();
            return usuario;
            
//            if(verificarSenha(senha, usuario.getSenha())){
//            return usuario;
//            }

        } catch (PersistenceException ex) {

            JOptionPane.showMessageDialog(null, "Login incorreto, verifique os dados inseridos.");
            em.getTransaction().rollback();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados " + ex);
            em.getTransaction().rollback();
        } finally {
            ConnectionFactory.closeEntityManager();
        }
        return null;
    }
    

}
