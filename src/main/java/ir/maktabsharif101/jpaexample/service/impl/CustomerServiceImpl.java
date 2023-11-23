package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.repository.CustomerRepository;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.base.BaseUserServiceImpl;

public class CustomerServiceImpl extends BaseUserServiceImpl<Customer, CustomerRepository>
        implements CustomerService {

    public CustomerServiceImpl(CustomerRepository baseRepository) {
        super(baseRepository);
    }
}
