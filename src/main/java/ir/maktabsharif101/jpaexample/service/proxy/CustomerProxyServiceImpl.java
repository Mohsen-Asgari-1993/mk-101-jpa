package ir.maktabsharif101.jpaexample.service.proxy;

import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.service.dto.CustomerSearch;
import ir.maktabsharif101.jpaexample.util.TransactionProvider;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomerProxyServiceImpl implements CustomerService {

    private final CustomerService customerOriginalService;

    private final String SERVICE_NAME = "customerService";

    @Override
    public Customer save(Customer customer) {
        try {
            TransactionProvider.beginTransaction(SERVICE_NAME);
            customer = customerOriginalService.save(customer);
            TransactionProvider.commitTransaction(SERVICE_NAME);
            return customer;
        } catch (Exception e) {
            TransactionProvider.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerOriginalService.findAll();
    }

    @Override
    public long count() {
        return customerOriginalService.count();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerOriginalService.findById(id);
    }

    @Override
    public void deleteAll() {
        try {
            TransactionProvider.beginTransaction(SERVICE_NAME);
            customerOriginalService.deleteAll();
            TransactionProvider.commitTransaction(SERVICE_NAME);
        } catch (Exception e) {
            TransactionProvider.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            TransactionProvider.beginTransaction(SERVICE_NAME);
            customerOriginalService.deleteById(id);
            TransactionProvider.commitTransaction(SERVICE_NAME);
        } catch (Exception e) {
            TransactionProvider.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return customerOriginalService.existsById(id);
    }

    @Override
    public Customer registerNewCustomer(CustomerRegistrationDTO dto) {
        try {
            TransactionProvider.beginTransaction(SERVICE_NAME);
            Customer customer = customerOriginalService.registerNewCustomer(dto);
            TransactionProvider.commitTransaction(SERVICE_NAME);
            return customer;
        } catch (Exception e) {
            TransactionProvider.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public List<Customer> search(CustomerSearch search) {
        return customerOriginalService.search(search);
    }

    @Override
    public boolean existsByUsername(String username) {
        return customerOriginalService.existsByUsername(username);
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return customerOriginalService.existsByMobileNumber(mobileNumber);
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        return customerOriginalService.findByUsername(username);
    }
}
