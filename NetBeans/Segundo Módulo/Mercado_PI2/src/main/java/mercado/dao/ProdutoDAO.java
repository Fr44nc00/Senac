
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import mercado.model.Produto;


public class ProdutoDAO {
    
    
    public void Insert(Produto p){
       EntityManager em = ConnectionFactory.getEntityManager();
         
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
    ConnectionFactory.closeEntityManager();
        }
    }  
        
    
    public void Delete(int id) {
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            Produto p = em.find(Produto.class, id);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
    
    public void atualizar(Produto p) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }

    public String BuscarDescricaoId(int id){
        EntityManager em = ConnectionFactory.getEntityManager();
        String descricao = null;
        try{
        Query consulta = em.createQuery("SELECT p.descricao FROM Produto p WHERE p.id = :pId");
        consulta.setParameter("pId", id);
        descricao = (String) consulta.getSingleResult();
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           ConnectionFactory.closeEntityManager();
       }
       return descricao;
    }
    
    public Produto BuscarProdutoId(int id){
        EntityManager em = ConnectionFactory.getEntityManager();
        Produto p = null;
        try{
        Query consulta = em.createQuery("SELECT p FROM Produto p WHERE p.id = :pId");
        consulta.setParameter("pId", id);
        p = (Produto) consulta.getSingleResult();
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           ConnectionFactory.closeEntityManager();
       }
       return p;
    }

    public List<Produto> ListarProdutos() {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT p FROM Produto p", Produto.class);
            List<Produto> episodios = consulta.getResultList();
            return episodios;

        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
    
     
       
}
     
    

