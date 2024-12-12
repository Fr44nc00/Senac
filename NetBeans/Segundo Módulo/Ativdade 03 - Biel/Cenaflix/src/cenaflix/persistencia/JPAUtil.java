package cenaflix.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static final String PERSISTENCE_UNIT = "CenaflixPU";
    private static EntityManagerFactory factory;
    
    public static EntityManager getEntityManager() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return factory.createEntityManager();
    }
    
    public static void closeEntityManager() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
