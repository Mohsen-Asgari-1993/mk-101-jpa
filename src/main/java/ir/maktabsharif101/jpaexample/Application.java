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
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Application {

    static Logger logger = Logger.getLogger(
            "MyLogName"
    );

    static {
        try {
            FileHandler fileHandler = new FileHandler("my-app.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        logger.log(
                Level.INFO, "app started!!"
        );

//        impl business logic

        logger.log(
                Level.INFO, "app shutdown!!"
        );


    }

    private static void addData(Workbook workbook, Sheet sheet, List<Customer> customers) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        int rowNumber = 1;

        for (Customer customer : customers) {
            Row row = sheet.createRow(rowNumber++);
            Cell cell = row.createCell(0);
            cell.setCellValue(customer.getFirstName());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(1);
            cell.setCellValue(customer.getLastName());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(2);
            cell.setCellValue(customer.getMobileNumber());
            cell.setCellStyle(cellStyle);
        }

    }

    private static void addHeader(Workbook workbook, Sheet sheet) {
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(
                HSSFColor.HSSFColorPredefined.RED.getColor().getIndex()
        );
        font.setFontName("B Nazanin");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        cellStyle.setFillBackgroundColor(
//                HSSFColor.HSSFColorPredefined.AQUA.getColor().getIndex()
//        );

        Row headerRow = sheet.createRow(0);
        Cell cell = headerRow.createCell(0);
        cell.setCellValue("نام");
        cell.setCellStyle(cellStyle);

        cell = headerRow.createCell(1);
        cell.setCellValue("نام خانوادگی");
        cell.setCellStyle(cellStyle);

        cell = headerRow.createCell(2);
        cell.setCellValue("شماره موبایل");
        cell.setCellStyle(cellStyle);

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
