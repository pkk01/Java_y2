package com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Model model = new Model();
        boolean registrationSuccess = model.registerUser(username, password);

        if (registrationSuccess) {
            response.sendRedirect("RegisterSuccess.jsp");
        } else {
            response.sendRedirect("RegisterFail.jsp");
        }
    }
}
