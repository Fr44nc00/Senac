
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import mercado.model.Cargo;


public class CargoDAO {
    
    public List<Cargo> ListarCargo(){
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Cargo> cargos = new ArrayList<Cargo>();
       try{
        Query consulta = em.createQuery("SELECT c FROM Cargo c");
        cargos = consulta.getResultList();
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           ConnectionFactory.closeEntityManager();
       }
       return cargos;
       }
       
    
}
