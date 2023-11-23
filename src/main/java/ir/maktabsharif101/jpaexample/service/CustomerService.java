package ir.maktabsharif101.jpaexample.service;

import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.service.base.BaseUserService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;

public interface CustomerService extends BaseUserService<Customer> {

    Customer registerNewCustomer(CustomerRegistrationDTO dto);

}
