package ir.maktabsharif101.jpaexample.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.stream.Collectors;

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("application/json".equalsIgnoreCase(request.getContentType())) {
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            User user;
            try {
                user = objectMapper.readValue(
                        body, User.class
                );
            } catch (Exception e) {
                response.sendError(
                        400, "bad json"
                );
                return;
            }
            System.out.println(user);

        } else {
            response.sendError(
                    415, "only json supported"
            );
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class User implements Serializable {
        private String firstName;
        private String lastName;
        private String username;
        private String mobileNumber;
    }
}
