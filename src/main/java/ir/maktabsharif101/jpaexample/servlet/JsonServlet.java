package ir.maktabsharif101.jpaexample.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class JsonServlet extends HttpServlet {

    private final Faker faker = new Faker();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        User user = new User();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setUsername(faker.name().username());
        user.setMobileNumber(faker.number().digits(11));
        writer.write(
                objectMapper.writeValueAsString(user)
        );
    }


    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class User implements Serializable {
        private String firstName;
        private String lastName;
        private String username;
        private String mobileNumber;
    }
}
