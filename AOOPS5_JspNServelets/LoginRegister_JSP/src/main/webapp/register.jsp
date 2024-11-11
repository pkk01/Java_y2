<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>please fill your details</h3>
	<form action="UserServlet" method="post">

		<lable>Name: </lable>
		<input type="text" name="name" required> <br> <br>
		<lable>Age: </lable>
		<input type="text" name="age" required> <br> <br>
		<lable>Username: </lable>
		<input type="text" name="username" required> <br> <br>

		<lable>Password: </lable>
		<input type="password" name="password" required> <br> <br>
		<button>register</button>
	</form>
</body>
</html>