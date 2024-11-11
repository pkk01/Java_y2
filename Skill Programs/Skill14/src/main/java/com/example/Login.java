package com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Model model = new Model();
        boolean loginSuccess = model.validateUser(username, password);

        if (loginSuccess) {
            response.sendRedirect("LogInSuccess.jsp");
        } else {
            response.sendRedirect("LogInFailed.jsp");
        }
    }
}
