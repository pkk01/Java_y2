package com.example.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StudentServlet1 extends HttpServlet {
	private static final String URL = "jdbc:postgresql://localhost:5432/student_crud";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "ADMINPK123";

	private Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver"); // Load Pgsql JDBC driver
		} catch (ClassNotFoundException e) {
			throw new SQLException("MySQL JDBC Driver not found.", e);
		}
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");

		try (Connection conn = getConnection()) {
			if ("add".equals(action)) {
				showForm(out, null);
			} else if ("edit".equals(action)) {
				int sno = Integer.parseInt(request.getParameter("sno"));
				Student student = getStudentById(conn, sno);
				showForm(out, student);
			} else if ("delete".equals(action)) {
				int sno = Integer.parseInt(request.getParameter("sno"));
				deleteStudent(conn, sno);
				response.sendRedirect("student");
			} else {
				listStudents(out, conn);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("sname");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String city = request.getParameter("city");
		double cgpa = Double.parseDouble(request.getParameter("cgpa"));

		try (Connection conn = getConnection()) {
			if ("insert".equals(request.getParameter("action"))) {
				insertStudent(conn, new Student(sno, sname, sage, city, cgpa));
			} else {
				updateStudent(conn, new Student(sno, sname, sage, city, cgpa));
			}
			response.sendRedirect("student");
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void listStudents(PrintWriter out, Connection conn) throws SQLException {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM student";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				students.add(new Student(rs.getInt("sno"), rs.getString("sname"), rs.getInt("sage"),
						rs.getString("city"), rs.getDouble("cgpa")));
			}
		}

		out.println("<html><body>");
		out.println("<h2>Student List</h2>");
		out.println("<a href='student?action=add'>Add New Student</a><br><br>");
		out.println(
				"<table border='1'><tr><th>Sno</th><th>Name</th><th>Age</th><th>City</th><th>CGPA</th><th>Actions</th></tr>");
		for (Student student : students) {
			out.println("<tr><td>" + student.getSno() + "</td><td>" + student.getSname() + "</td><td>"
					+ student.getSage() + "</td><td>" + student.getCity() + "</td><td>" + student.getCgpa() + "</td>");
			out.println("<td><a href='student?action=edit&sno=" + student.getSno()
					+ "'>Edit</a> | <a href='student?action=delete&sno=" + student.getSno()
					+ "' onclick=\"return confirm('Are you sure?')\">Delete</a></td></tr>");
		}
		out.println("</table></body></html>");
	}

	private void showForm(PrintWriter out, Student student) {
		out.println("<html><body>");
		out.println("<h2>" + (student == null ? "Add" : "Edit") + " Student</h2>");
		out.println("<form method='post' action='student'>");
		out.println("<input type='hidden' name='action' value='" + (student == null ? "insert" : "update") + "'>");
		out.println("<label>Sno:</label><input type='text' name='sno' value='"
				+ (student != null ? student.getSno() : "") + "'><br>");
		out.println("<label>Name:</label><input type='text' name='sname' value='"
				+ (student != null ? student.getSname() : "") + "'><br>");
		out.println("<label>Age:</label><input type='text' name='sage' value='"
				+ (student != null ? student.getSage() : "") + "'><br>");
		out.println("<label>City:</label><input type='text' name='city' value='"
				+ (student != null ? student.getCity() : "") + "'><br>");
		out.println("<label>CGPA:</label><input type='text' name='cgpa' value='"
				+ (student != null ? student.getCgpa() : "") + "'><br>");
		out.println("<input type='submit' value='Save'>");
		out.println("</form></body></html>");
	}

	private Student getStudentById(Connection conn, int sno) throws SQLException {
		String sql = "SELECT * FROM student WHERE sno = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, sno);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Student(rs.getInt("sno"), rs.getString("sname"), rs.getInt("sage"), rs.getString("city"),
							rs.getDouble("cgpa"));
				}
			}
		}
		return null;
	}

	private void insertStudent(Connection conn, Student student) throws SQLException {
		String sql = "INSERT INTO student (sno, sname, sage, city, cgpa) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSage());
			pstmt.setString(4, student.getCity());
			pstmt.setDouble(5, student.getCgpa());
			pstmt.executeUpdate();
		}
	}

	private void updateStudent(Connection conn, Student student) throws SQLException {
		String sql = "UPDATE student SET sname = ?, sage = ?, city = ?, cgpa = ? WHERE sno = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSage());
			pstmt.setString(3, student.getCity());
			pstmt.setDouble(4, student.getCgpa());
			pstmt.setInt(5, student.getSno());
			pstmt.executeUpdate();
		}
	}

	private void deleteStudent(Connection conn, int sno) throws SQLException {
		String sql = "DELETE FROM student WHERE sno = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, sno);
			pstmt.executeUpdate();
		}
	}

	static class Student {
		private int sno;
		private String sname;
		private int sage;
		private String city;
		private double cgpa;

		public Student(int sno, String sname, int sage, String city, double cgpa) {
			this.sno = sno;
			this.sname = sname;
			this.sage = sage;
			this.city = city;
			this.cgpa = cgpa;
		}

		public int getSno() {
			return sno;
		}

		public String getSname() {
			return sname;
		}

		public int getSage() {
			return sage;
		}

		public String getCity() {
			return city;
		}

		public double getCgpa() {
			return cgpa;
		}
	}
}