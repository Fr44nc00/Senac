package br.com.senac.financasjpa.persistencia;

import br.com.senac.financasjpa.persistencia.Receita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class ReceitaDAO {

    public void cadastrar(Receita r){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Receita> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("SELECT r FROM Receita r");
            List<Receita> receitas = consulta.getResultList();
            return receitas;
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public Receita obter(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return em.find(Receita.class, id);
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
        
    public void atualizar(Receita r){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public void excluir(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Receita r = em.find(Receita.class, id);
            if(r != null){
                em.getTransaction().begin();
                em.remove(r);
                em.getTransaction().commit();
            }
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
        
        //No método, você primeiro busca o registro que deseja excluir (a partir de seu id)
        //e depois o remove no repositório. É importante lembrar que, nessa operação, você
        //deve usar transações: commit(), quando tudo estiver OK, ou rollback(), caso tenha
        //havido falha.
    }
}
