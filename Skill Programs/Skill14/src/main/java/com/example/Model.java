package com.example;

import java.sql.*;

public class Model {
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/skill13_2";
	private static final String JDBC_USER = "postgres";
	private static final String JDBC_PASS = "ADMINPK123";

	public boolean registerUser(String username, String password) {

		try {
			Class.forName("org.postgresql.Driver");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
			String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateUser(String username, String password) {
		try {
			Class.forName("org.postgresql.Driver");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
