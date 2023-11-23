package ir.maktabsharif101.jpaexample;

import com.github.javafaker.Faker;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.RandomStringService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.service.impl.RandomStringProxyServiceImpl;
import ir.maktabsharif101.jpaexample.util.ApplicationContext;
import ir.maktabsharif101.jpaexample.util.CacheManager;
import org.apache.commons.lang3.RandomStringUtils;

public class Application {

    public static void main(String[] args) {

        RandomStringService randomStringService = new RandomStringProxyServiceImpl();

        CacheManager cacheManager = CacheManager.getInstance();

        for (int i = 0; i < 17; i++) {
            if (i % 4 == 0) {
                cacheManager.clearCache(
                        RandomStringProxyServiceImpl.CACHE_NAME
                );
            }
            System.out.println(
                    (i + 1) + ": " + randomStringService.generateRandomStringList()
            );
        }

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
