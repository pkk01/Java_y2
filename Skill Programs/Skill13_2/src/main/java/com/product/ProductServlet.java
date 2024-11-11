package com.product;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/skill13_2";
	private static final String JDBC_USER = "postgres";
	private static final String JDBC_PASS = "ADMINPK123";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String productName = request.getParameter("product_name");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");

		try {
			// Register the PostgreSQL driver
			Class.forName("org.postgresql.Driver");

			try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
				if ("add".equals(action)) {
					String query = "INSERT INTO products (product_name, description, price, category) VALUES (?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(query)) {
						stmt.setString(1, productName);
						stmt.setString(2, description);
						stmt.setDouble(3, price);
						stmt.setString(4, category);
						stmt.executeUpdate();
					}
				} else if ("update".equals(action)) {
					int productId = Integer.parseInt(request.getParameter("product_id"));
					String query = "UPDATE products SET product_name = ?, description = ?, price = ?, category = ? WHERE product_id = ?";
					try (PreparedStatement stmt = conn.prepareStatement(query)) {
						stmt.setString(1, productName);
						stmt.setString(2, description);
						stmt.setDouble(3, price);
						stmt.setString(4, category);
						stmt.setInt(5, productId);
						stmt.executeUpdate();
					}
				} else if ("delete".equals(action)) {
					int productId = Integer.parseInt(request.getParameter("product_id"));
					String query = "DELETE FROM products WHERE product_id = ?";
					try (PreparedStatement stmt = conn.prepareStatement(query)) {
						stmt.setInt(1, productId);
						stmt.executeUpdate();
					}
				}
				response.sendRedirect("product.jsp");
			}
		} catch (ClassNotFoundException e) {
			throw new ServletException("PostgreSQL JDBC Driver not found.", e);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
