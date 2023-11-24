package ir.maktabsharif101.jpaexample;

import com.github.javafaker.Faker;
import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.util.ApplicationContext;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class Application {

    public static void main(String[] args) {

//        createFakeCustomers();

        List<Wallet> all = ApplicationContext.getWalletRepository()
                .findAll();
        all.forEach(wallet ->
                System.out.println(
                        "walletId: " + wallet.getId() +
                                " - customerId: " + wallet.getCustomer().getId() +
                                " - customer firstName: " + wallet.getCustomer().getFirstName()
                )
        );

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
