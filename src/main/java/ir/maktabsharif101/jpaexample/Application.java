package ir.maktabsharif101.jpaexample;

import com.github.javafaker.Faker;
import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.domain.Permission;
import ir.maktabsharif101.jpaexample.domain.Role;
import ir.maktabsharif101.jpaexample.repository.CustomerRepository;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.util.ApplicationContext;
import ir.maktabsharif101.jpaexample.util.TransactionProvider;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        CustomerRepository customerRepository = ApplicationContext.getCustomerRepository();


        Optional<Customer> optionalCustomer = customerRepository.findById(10L);
        optionalCustomer.ifPresent(
                customer -> {
                    System.out.println(customer);
                    System.out.println(customer.getRoles().size());
                    customer.getRoles().forEach(role -> System.out.println(role.getPermissions().size()));
                }
        );


    }

    private static void addRolesAndPermissionsToCustomers() {
        TransactionProvider.beginTransaction("init");

        Permission permission = ApplicationContext.getPermissionService().save(
                new Permission("customer")
        );
        Set<Permission> permissions = new HashSet<>();
        permissions.add(permission);
        Role customerRole = ApplicationContext.getRoleRepository().save(
                new Role(
                        "CUSTOMER",
                        permissions
                )
        );

        List<Customer> customers = ApplicationContext.getCustomerRepository()
                .findAll();

        Set<Role> roles = new HashSet<>();
        roles.add(customerRole);

        customers.forEach(customer -> {
            customer.setRoles(
                    roles
            );
            ApplicationContext.getCustomerRepository().save(customer);
        });

        TransactionProvider.commitTransaction("init");
    }

    private static void createFakeCustomers() {
        Faker faker = new Faker();
        CustomerService customerService = ApplicationContext.getCustomerProxyService();
        for (int i = 0; i < 500; i++) {
            customerService.registerNewCustomer(
                    new CustomerRegistrationDTO(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            "09".concat(
                                    RandomStringUtils.randomNumeric(9)
                            ),
                            RandomStringUtils.randomNumeric(9)
                    )
            );
        }
    }
}
