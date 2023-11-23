package ir.maktabsharif101.jpaexample;

import ir.maktabsharif101.jpaexample.util.ApplicationContext;

import javax.persistence.EntityManager;

public class Application {

    public static void main(String[] args) {
        EntityManager em = ApplicationContext.getEm();
    }
}
