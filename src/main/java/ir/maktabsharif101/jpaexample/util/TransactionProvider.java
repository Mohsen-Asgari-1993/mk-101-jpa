package ir.maktabsharif101.jpaexample.util;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityTransaction;

public class TransactionProvider {

    private TransactionProvider() {

    }

    private static String transactionStarterName;

    public static void beginTransaction(String starterName) {
        if (StringUtils.isBlank(starterName)) {
            throw new RuntimeException();
        }
        EntityTransaction transaction =
                ApplicationContext.getEntityManager().getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
            transactionStarterName = starterName;
        }
    }

    public static void commitTransaction(String starterName) {
        if (StringUtils.isBlank(transactionStarterName) || StringUtils.isBlank(starterName)) {
            throw new UnsupportedOperationException();
        }
        EntityTransaction transaction =
                ApplicationContext.getEntityManager().getTransaction();
        if (transaction.isActive() && transactionStarterName.equals(starterName)) {
            transaction.commit();
        }
    }

    public static void rollbackTransaction() {
        EntityTransaction transaction =
                ApplicationContext.getEntityManager().getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

}
