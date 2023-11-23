package ir.maktabsharif101.jpaexample;

import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.util.ApplicationContext;

public class Application {

    public static void main(String[] args) {
        CustomerService customerService = ApplicationContext.getCustomerService();
        customerService.registerNewCustomer(
                new CustomerRegistrationDTO(
                        "mohsen",
                        "asgari",
                        "09121212222",
                        "matmatmat"
                )
        );
    }
}
