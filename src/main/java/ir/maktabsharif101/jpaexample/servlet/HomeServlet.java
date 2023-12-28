package ir.maktabsharif101.jpaexample.servlet;

import com.github.javafaker.Faker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HomeServlet extends HttpServlet {

    private final Faker faker = new Faker();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute(
                "myName", faker.name().fullName()
        );

        request.getRequestDispatcher("home.jsp")
                .forward(request, response);
    }
}
