
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import mercado.model.Cargo;
import mercado.model.Funcionario;
import mercado.model.Usuario;


public class FuncionarioDAO {
    
    public void Insert(Funcionario f){
        
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
    //
    
    public Funcionario retornaFuncionarioUsuario(Usuario u) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Funcionario funcionario;

        try {
            String jpql = "SELECT f FROM Funcionario f WHERE f.usuario.id = :pUsuario_id";
            TypedQuery<Funcionario> typedQuery = em.createQuery(jpql,Funcionario.class).setParameter("pUsuario_id",u.getId());
            funcionario = typedQuery.getSingleResult();
            
            if(funcionario != null){
                return funcionario;
            }else{
                return null;
            }
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally{
        ConnectionFactory.closeEntityManager();
        }
    }
    
    public int retornaCargoFuncionario(Funcionario funcionario){
        EntityManager em = ConnectionFactory.getEntityManager();
       
       
        try{
            Query consulta = em.createQuery("SELECT f.cargo.id FROM Funcionario f WHERE f = :funcionario");
            consulta.setParameter("funcionario", funcionario);
            int cargo = (int) consulta.getSingleResult();
            return cargo;
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
        ConnectionFactory.closeEntityManager();
        }

    }
    
}
