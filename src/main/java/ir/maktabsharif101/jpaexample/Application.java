package ir.maktabsharif101.jpaexample;

import com.github.javafaker.Faker;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.service.dto.CustomerSearch;
import ir.maktabsharif101.jpaexample.util.ApplicationContext;
import org.apache.commons.lang3.RandomStringUtils;

public class Application {

    public static void main(String[] args) {
//        createFakeCustomers();
        CustomerService customerService = ApplicationContext.getCustomerService();

        System.out.println(
                "1: " + customerService.search(new CustomerSearch()).size()
        );

        System.out.println(
                "2: " + customerService.search(
                        CustomerSearch.builder()
                                .firstName("am")
                                .build()
                ).size()
        );

        System.out.println(
                "3: " + customerService.search(
                        CustomerSearch.builder()
                                .firstName("am")
                                .lastName("s")
                                .build()
                ).size()
        );

        System.out.println(
                "4: " + customerService.search(
                        CustomerSearch.builder()
                                .mobileNumber("99")
                                .build()
                ).size()
        );


    }

    private static void createFakeCustomers() {
        Faker faker = new Faker();
        CustomerService customerService = ApplicationContext.getCustomerService();
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
