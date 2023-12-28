package ir.maktabsharif101.jpaexample.servlet;

import com.github.javafaker.Faker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeServlet extends HttpServlet {

    private final Faker faker = new Faker();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute(
                "myName", faker.name().fullName()
        );

        List<String> names = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            names.add(
                    faker.name().fullName()
            );
        }

        request.setAttribute(
                "names", names
        );

        request.getRequestDispatcher("home.jsp")
                .forward(request, response);
    }
}
