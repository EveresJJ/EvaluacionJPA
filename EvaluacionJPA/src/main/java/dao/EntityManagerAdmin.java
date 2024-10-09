package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerAdmin {

    private static final String PERSISTENCE_UNIT_NAME = "testDB"; // This should match your persistence.xml
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager instance;

    private EntityManagerAdmin() {
    }

    public static EntityManager getInstance() {
        if (instance == null || !instance.isOpen()) {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            }
            instance = entityManagerFactory.createEntityManager();
        }
        return instance;
    }

    public static void close() {
        if (instance != null && instance.isOpen()) {
            instance.close();
        }
    }

    public static void closeFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
