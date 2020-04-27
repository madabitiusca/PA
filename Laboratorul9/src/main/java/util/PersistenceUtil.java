package util;

import javax.persistence.EntityManagerFactory;

public class PersistenceUtil {
    private EntityManagerFactory entityManagerFactory;

    public PersistenceUtil(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


}
