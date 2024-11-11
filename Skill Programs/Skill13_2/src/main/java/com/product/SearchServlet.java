package com.product;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/skill13_2";
	private static final String JDBC_USER = "postgres";
	private static final String JDBC_PASS = "ADMINPK123";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");

		StringBuilder query = new StringBuilder("SELECT * FROM products WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (name != null && !name.isEmpty()) {
			query.append(" AND product_name LIKE ?");
			params.add("%" + name + "%");
		}
		if (category != null && !category.isEmpty()) {
			query.append(" AND category = ?");
			params.add(category);
		}
		if (minPriceStr != null && !minPriceStr.isEmpty()) {
			query.append(" AND price >= ?");
			params.add(Double.parseDouble(minPriceStr));
		}
		if (maxPriceStr != null && !maxPriceStr.isEmpty()) {
			query.append(" AND price <= ?");
			params.add(Double.parseDouble(maxPriceStr));
		}

		List<Product> products = new ArrayList<>();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
				PreparedStatement stmt = conn.prepareStatement(query.toString())) {
			for (int i = 0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getInt("product_id"), rs.getString("product_name"),
						rs.getString("description"), rs.getDouble("price"), rs.getString("category")));
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		request.setAttribute("products", products);
		request.getRequestDispatcher("search_results.jsp").forward(request, response);
	}
}
