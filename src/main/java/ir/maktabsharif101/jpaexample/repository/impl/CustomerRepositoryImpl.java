package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.repository.CustomerRepository;
import ir.maktabsharif101.jpaexample.repository.base.BaseUserRepositoryImpl;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
