package ir.maktabsharif101.jpaexample.service.impl;

import com.google.common.hash.Hashing;
import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.domain.enumeration.UserType;
import ir.maktabsharif101.jpaexample.repository.CustomerRepository;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.WalletService;
import ir.maktabsharif101.jpaexample.service.base.BaseUserServiceImpl;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.util.SemaphoreUtil;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;

public class CustomerServiceImpl extends BaseUserServiceImpl<Customer, CustomerRepository>
        implements CustomerService {

    private final WalletService walletService;

    public CustomerServiceImpl(CustomerRepository baseRepository, WalletService walletService) {
        super(baseRepository);
        this.walletService = walletService;
    }

    @Override
    public Customer registerNewCustomer(CustomerRegistrationDTO dto) {
        validateRegistrationDTO(dto);
        SemaphoreUtil.acquireNewCustomerSemaphore();
        try {
            if (baseRepository.existsByMobileNumber(dto.getMobileNumber())) {
                throw new RuntimeException("duplicate mobileNumber");
            }
            baseRepository.beginTransaction();
            Customer customer = new Customer();
            customer.setFirstName(dto.getFirstName());
            customer.setLastName(dto.getLastName());
            customer.setMobileNumber(dto.getMobileNumber());
            customer.setUsername(dto.getMobileNumber());
            customer.setPassword(
                    Hashing.sha256()
                            .hashString(dto.getPassword(), StandardCharsets.UTF_8)
                            .toString()
            );
            customer.setUserType(UserType.CUSTOMER.name());
            customer.setCode(
                    String.valueOf(
                            ZonedDateTime.now().toInstant().toEpochMilli()
                    )
            );
//            TODO add customer role
            customer = baseRepository.save(customer);
            walletService.save(
                    new Wallet(
                            customer.getId()
                    )
            );
            baseRepository.commitTransaction();
            return customer;
        } catch (Exception e) {
            baseRepository.rollbackTransaction();
            throw e;
        } finally {
            SemaphoreUtil.releaseNewCustomerSemaphore();
        }

    }

    private void validateRegistrationDTO(CustomerRegistrationDTO dto) {
        if (StringUtils.isBlank(dto.getMobileNumber())) {
            throw new RuntimeException("empty mobileNumber");
        }
        if (StringUtils.isBlank(dto.getPassword())) {
            throw new RuntimeException("empty password");
        }
        if (dto.getMobileNumber().length() != 11 || !dto.getMobileNumber().startsWith("09")) {
            throw new RuntimeException("invalid mobileNumber");
        }
        if (dto.getPassword().length() < 8 || dto.getPassword().length() > 16) {
            throw new RuntimeException("password length in invalid");
        }
    }
}
