package ir.maktabsharif101.jpaexample.repository;

import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.repository.base.BaseUserRepository;
import ir.maktabsharif101.jpaexample.service.dto.CustomerSearch;

import java.util.List;

public interface CustomerRepository extends BaseUserRepository<Customer> {

    List<Customer> search(CustomerSearch search);

}
