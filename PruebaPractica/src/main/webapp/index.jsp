<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
 	<% session.invalidate(); %>
 	
	<form action="checkLogin.jsp"  method="post">
	  <label for="fname">Usuario:</label><br>
	  <input type="text" id="name" name="name" ><br>
	  <label for="lname">Password:</label><br>
	  <input type="password" id="password" name="password" ><br><br>
	  <input type="submit" value="Submit">
	</form> 
	
</body>
</html>