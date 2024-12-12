
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import mercado.model.Fornecedor;


public class FornecedorDAO {
    
    public void Insert(Fornecedor f){
       EntityManager em = ConnectionFactory.getEntityManager();
         
        try{
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
    ConnectionFactory.closeEntityManager();
        }
    }
    
      public void atualizar(Fornecedor f) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    } 
    
    public List<Fornecedor> ListarFornecedor(){
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
       try{
        Query consulta = em.createQuery("SELECT f FROM Fornecedor f");
        fornecedor = consulta.getResultList();
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           ConnectionFactory.closeEntityManager();
       }
       return fornecedor;
       }
    
    public Fornecedor buscaFornecedorNome(String nomeFornecedor){
        EntityManager em = ConnectionFactory.getEntityManager();
        Fornecedor f = null;
        try{
        Query consulta = em.createQuery("SELECT f FROM Fornecedor f WHERE f.nome = :pNome");
        consulta.setParameter("pNome", nomeFornecedor);
        f = (Fornecedor) consulta.getSingleResult();
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           ConnectionFactory.closeEntityManager();
       }
       return f;
       }
    
    public Fornecedor buscaFornecedorId(int id){
        EntityManager em = ConnectionFactory.getEntityManager();
        Fornecedor f = null;
        try{
        Query consulta = em.createQuery("SELECT f FROM Fornecedor f WHERE f.id = :pId");
        consulta.setParameter("pId", id);
        f = (Fornecedor) consulta.getSingleResult();
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           ConnectionFactory.closeEntityManager();
       }
       return f;
       }
    
    
    
    
}
