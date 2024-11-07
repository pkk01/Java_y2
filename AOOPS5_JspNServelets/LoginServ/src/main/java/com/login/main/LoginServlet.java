package com.login.main;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("inside service...");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/eclipselogin", "postgres",
					"ADMINPK123");
			System.out.println("Connection created");
			String vsql = "select * from login where username=? and password=?";
			pstmt = con.prepareStatement(vsql);
			System.out.println("prepare statement created...");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			System.out.println(username);
			System.out.println(password);
			rs = pstmt.executeQuery();
			System.out.println("query executed.....");
			if (rs.next()) {
				out.println("Login success");
			} else {
				out.println("Invalid credentials");
			}
		} catch (Exception e) {
		}
	}
}
