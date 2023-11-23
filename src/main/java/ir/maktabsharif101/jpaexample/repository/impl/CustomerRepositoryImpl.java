package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.repository.CustomerRepository;
import ir.maktabsharif101.jpaexample.repository.base.BaseUserRepositoryImpl;
import ir.maktabsharif101.jpaexample.service.dto.CustomerSearch;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public List<Customer> search(CustomerSearch search) {
//        TODO develop this
        return null;
    }
}
