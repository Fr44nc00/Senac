package cenaflix.persistencia;

import cenaflix.model.Podcast;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PodcastDAO {
    
    public void cadastrar(Podcast podcast) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(podcast);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Podcast> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Podcast p");
            return query.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
