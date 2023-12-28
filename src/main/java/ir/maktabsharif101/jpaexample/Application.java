package ir.maktabsharif101.jpaexample;

import com.github.javafaker.Faker;
import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.domain.Permission;
import ir.maktabsharif101.jpaexample.domain.Role;
import ir.maktabsharif101.jpaexample.service.CustomerService;
import ir.maktabsharif101.jpaexample.service.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.jpaexample.util.ApplicationContext;
import ir.maktabsharif101.jpaexample.util.TransactionProvider;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) throws IOException {
        writeWithFileWriter();

        readWithFileReader();

        writeWithFileOutputStream();

        readWithFileInputStream();

    }

    private static void writeWithFileOutputStream() throws IOException {
        File file = new File("second-file.txt");

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(
                    new byte[]{
                            0, 1, 2, 3
                    }
            );
        }
    }

    private static void readWithFileInputStream() throws IOException {
        File file = new File("second-file.txt");

        try (FileInputStream inputStream = new FileInputStream(file)) {
            int data = inputStream.read();
            while (data != -1) {
                System.out.print(data);
                data = inputStream.read();
            }
        }
    }

    private static void readWithFileReader() throws IOException {
        File file = new File("first-file.txt");
        try (FileReader fileReader = new FileReader(file)) {
            int firstChar = fileReader.read();
            while (firstChar != -1) {
                System.out.print((char) firstChar);
                firstChar = fileReader.read();
            }
        }
    }

    private static void writeWithFileWriter() throws IOException {
        File file = new File("first-file.txt");
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write("this is second line");
        fileWriter.close();
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
