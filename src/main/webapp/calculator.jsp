<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.jacaranda.Calculator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculadora</title>
</head>
<body>
	<%Integer x = Integer.parseInt(request.getParameter("x"));
	Integer y = Integer.parseInt(request.getParameter("y"));
	Calculator c = new Calculator(x,y);
	%>

</body>
</html>