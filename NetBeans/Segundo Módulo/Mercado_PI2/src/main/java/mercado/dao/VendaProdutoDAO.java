
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mercado.model.Produto;
import mercado.model.VendaProduto;

public class VendaProdutoDAO {
    
    public void Insert(VendaProduto vp){
        
         EntityManager em = ConnectionFactory.getEntityManager();
         
        try{
            em.getTransaction().begin();
            em.persist(vp);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
    ConnectionFactory.closeEntityManager();
        }
    }
 
    public List<Produto> ProdutosPorId(List<Integer> produtosIds) {
     EntityManager em = ConnectionFactory.getEntityManager();
        TypedQuery<Produto> query = em.createQuery(
                "SELECT p FROM Produto p WHERE p.id IN :ids", Produto.class);
        query.setParameter("ids", produtosIds);
        return query.getResultList();
    }  
    
}
