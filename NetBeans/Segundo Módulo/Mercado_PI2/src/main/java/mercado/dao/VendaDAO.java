
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import mercado.model.Venda;




public class VendaDAO {
    
    public void Insert(Venda v){
        
         EntityManager em = ConnectionFactory.getEntityManager();
         
        try{
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
    ConnectionFactory.closeEntityManager();
        }
    }
    
    
    
}
