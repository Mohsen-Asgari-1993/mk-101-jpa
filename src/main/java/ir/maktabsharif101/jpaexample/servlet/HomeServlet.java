package ir.maktabsharif101.jpaexample.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(
                """
                        <html lang="en">
                        <body>
                        <h1>This is home page</h1>
                        <p>this is p tag</p>
                        </body>
                        </html>
                            """
        );
    }
}
