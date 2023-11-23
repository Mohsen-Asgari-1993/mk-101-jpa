package ir.maktabsharif101.jpaexample.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {

    private static final EntityManager em =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();

    public static EntityManager getEm() {
        return em;
    }
}
