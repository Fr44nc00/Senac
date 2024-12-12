
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;
import mercado.model.Usuario;
import mercado.dao.LoginDAO;

public class UsuarioDAO {
    
    
    public void Insert(Usuario u){
        
         EntityManager em = ConnectionFactory.getEntityManager();
         
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
    ConnectionFactory.closeEntityManager();
        }
    }
    
    public int RetornaId(String email, String senha){
    LoginDAO login = new LoginDAO();
    Usuario u = login.verificaLogin(email, senha);
    int id = u.getId();
    
     return id;
     
    
    }
}

