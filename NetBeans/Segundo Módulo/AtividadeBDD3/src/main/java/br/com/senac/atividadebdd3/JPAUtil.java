package br.com.senac.atividadebdd3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    //Constante para centralizar o nome da unidade de persistência
    private static final String PERSISTENCE_UNIT = "Cenaflix-PU";

    private static EntityManagerFactory fabrica;
    private static EntityManager em;

    //Cria a fábrica e o EntityManager se estiverem nulos e os retorna
    public static EntityManager getEntityManager() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if (em == null || !em.isOpen()) {
            em = fabrica.createEntityManager();
        }
        return em;
    }

    //Fecha o EntityManager e a fábrica
    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}
