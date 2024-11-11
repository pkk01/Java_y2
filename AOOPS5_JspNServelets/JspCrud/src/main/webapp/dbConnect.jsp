
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, jakarta.servlet.RequestDispatcher, jakarta.servlet.ServletException" %>
<%
    // Database connection parameters
    String url = "jdbc:postgresql://localhost:5432/s21_emp";
    String username = "postgres";
    String password = "ADMINPK123";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String errorMessage = null;

    try {
        // Load MySQL JDBC Driver
        Class.forName("org.postgresql.Driver");

        // Establish the connection
        conn = DriverManager.getConnection(url, username, password);

        // Query the database
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM employee");

        // Set the ResultSet as a request attribute
        request.setAttribute("resultSet", rs);

        // Forward to display.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
        dispatcher.forward(request, response);

    } catch (Exception e) {
        errorMessage = e.getMessage();
        out.println("<p>Error: " + errorMessage + "</p>");
    } finally {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>