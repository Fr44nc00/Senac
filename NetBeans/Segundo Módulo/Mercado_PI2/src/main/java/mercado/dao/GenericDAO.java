
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;



public class GenericDAO {

    public void Insert(Object o){
         EntityManager em = ConnectionFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
    ConnectionFactory.closeEntityManager();
        }
    }
        
    
    public void Delete(Object o){
        
        
    }

    public void Update(Object o){
      
        
    }
    
}
