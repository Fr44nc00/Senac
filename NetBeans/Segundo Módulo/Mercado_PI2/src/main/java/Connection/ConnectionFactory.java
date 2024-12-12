
package Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class ConnectionFactory {
    
    private static final String PERSISTENCE_UNIT = "mercado";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    public static EntityManager getEntityManager(){
        
      try {
            if (fabrica == null || !fabrica.isOpen()) {
                System.out.println("Criando nova fábrica de EntityManager...");
                fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
                System.out.println("Fábrica de EntityManager criada com sucesso.");
            }
            if (em == null || !em.isOpen()) {
                System.out.println("Criando novo EntityManager...");
                em = fabrica.createEntityManager();
                System.out.println("Novo EntityManager criado com sucesso.");
            }
            return em;
        } catch (PersistenceException pe) {
            JOptionPane.showMessageDialog(null, "Erro de persistência: " + pe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw pe;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
      
    }
    
   public static void closeEntityManager(){
       if(em.isOpen() && em != null){
           em.close();
           fabrica.close();
       }
   } 
   
}