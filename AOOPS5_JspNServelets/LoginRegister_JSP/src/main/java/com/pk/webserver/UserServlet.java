package com.pk.webserver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	protected final String url = "jdbc:postgresql://localhost/8080/login_project";
	protected final String dbUsername = "postgres";
	protected final String dbPassword = "ADMINPK123";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// creating instance of model class User.java to set the values

		User user = new User();

		user.setName(name);
		user.setAge(age);
		user.setUsername(username);
		user.setPassword(password);

		boolean isAdded = saveUserToDB(user);

		if (isAdded) {
			response.sendRedirect("display.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}

	}

	private boolean saveUserToDB(User user) {
		// TODO Auto-generated method stub
		String insertQuery = "insert into users values (?,?,?,?)";
		try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());

			int insertCount = preparedStatement.executeUpdate();

			return insertCount > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

////	taking values from register.jsp to the servlet in doPost method
//
//	String name = request.getParameter("name");
//	int age = Integer.parseInt(request.getParameter("age"));
//	String username = request.getParameter("username");
//	String password = request.getParameter("password");
//
//	try {
//		Class.forName("org.postgresql.Driver");
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//
//	try (Connection connection = DriverManager.getConnection(url, DbUsername, DbPassword)) {
//
//		String insertQuery = "insert into users values (?,?,?,?)";
//		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//
//		preparedStatement.setString(1, name);
//		preparedStatement.setInt(2, age);
//		preparedStatement.setString(3, username);
//		preparedStatement.setString(4, password);
//
//		int insertCount = preparedStatement.executeUpdate();
//
//		if (insertCount > 0) {
//			System.out.println("Added successfully");
//			response.sendRedirect("display.jsp");
//		} else {
//			System.out.println("Details adding failed");
//			response.sendRedirect("error.jsp");
//		}
//
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//		response.sendRedirect("error.jsp");
//	}

	// retrieving the data using doGet method

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {

			String retrieveQuery = "select * from users";

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(retrieveQuery);

			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			String username = resultSet.getString("username");

			response.sendRedirect("display.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
