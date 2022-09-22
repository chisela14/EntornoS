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
	<% double x = Double.parseDouble(request.getParameter("x"));
	double y = Double.parseDouble(request.getParameter("y"));
	Calculator c = new Calculator(x,y);
	char operator = request.getParameter("operator").charAt(0);
	double result = 0;
	switch(operator){
		case'+':
			result = c.add();
			break;
		case'-':
			result = c.subtract();
			break;
		case'*':
			result = c.multiply();
			break;
		case'/':
			try{
				result = c.divide();
			}catch (Exception e){ %>
				<%= e.getMessage() %>
			<% }
			break;
	}
	%>
	<% out.println(x + operator + y + '=' + result); %>

</body>
</html>