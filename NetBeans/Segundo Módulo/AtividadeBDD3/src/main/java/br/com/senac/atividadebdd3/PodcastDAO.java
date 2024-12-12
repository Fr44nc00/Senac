package br.com.senac.atividadebdd3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.sql.Connection;

public class PodcastDAO {
    Connection connection;

    //Função realizada para se conectar com o banco de dados
    public void cadastrar(Podcast p){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    //Função para transformar uma tabela do banco de dados numa lista
    public List<Podcast> listar1() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT p FROM Podcast p");
            List<Podcast> podcast = consulta.getResultList();

            return podcast;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    //Função para transformar uma tabela do banco de dados numa lista com base em um dado
    public List<Podcast> listar2(String produtor) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Podcast> podcast = null;
        try {
            String textoQuery = "SELECT p FROM Podcast p WHERE p.produtor LIKE :produtor";
            Query consulta = em.createQuery(textoQuery);
            consulta.setParameter("produtor", "%" + produtor + "%");
            podcast = consulta.getResultList();
            
        } finally {
            em.close();
        }
        return podcast;
    }
    
    //Função realizada para excluir os dados de um podcast no banco de dados
    public void excluir(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Podcast p = em.find(Podcast.class, id);
            if(p!= null){
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
}
