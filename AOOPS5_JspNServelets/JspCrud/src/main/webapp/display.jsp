
<%@ page import="java.sql.*"%>
<html>
<head>
<title>S21 DB</title>
</head>
<body>
	<h2>Employee S21 CRUD Program</h2>
	<table border="1">
		<tr>
			<th>EID</th>
			<th>EName</th>
			<th>ESal</th>
			<th>EAge</th>
			<th>ECity</th>
		</tr>
		<%
		ResultSet rs = (ResultSet) request.getAttribute("resultSet");

		if (rs != null) {
			while (rs.next()) {
				int id = rs.getInt("EID");
				String name = rs.getString("ENAME");
				double sal = rs.getDouble("ESAL");
				int age = rs.getInt("eage");
				String city = rs.getString("city");
		%>
		<tr>
			<td><%=id%></td>
			<td><%=name%></td>
			<td><%=sal%></td>
			<td><%=age%></td>
			<td><%=city%></td>
		</tr>
		<%
		}
		rs.close(); // Close ResultSet after using it
		} else {
		out.println("<tr><td colspan='3'>No data found</td></tr>");
		}
		%>
	</table>
</body>
</html>