<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Error</title>
</head>
<body>
    <div>
        <h1>Error</h1>
        <h2><%= request.getParameter("msg") %></h2>
        <a href="index.jsp">Volver al inicio</a>
    </div>
</body>
</html>