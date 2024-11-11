package com.userservlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try (Connection conn = getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("created_at", rs.getString("created_at"));

				request.getRequestDispatcher("profile.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid username or password.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Database connection error.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Redirect to login page for GET requests
		response.sendRedirect("login.jsp"); // Adjust "login.jsp" to the correct path if needed
	}

	private Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");

		String url = "jdbc:postgresql://localhost:5432/user_management";
		String user = "postgres";
		String pass = "ADMINPK123";
		return DriverManager.getConnection(url, user, pass);
	}
}
