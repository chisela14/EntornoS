<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.studentJacaranda.control.UserControl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comprobar login</title>
</head>
<body>
	<%String user = request.getParameter("name");
	String password = request.getParameter("password");
	if(UserControl.userIsValid(user, password)){
		HttpSession sesion = request.getSession();
		session.setAttribute("login", "True");
		session.setAttribute("user", user);%>
		<jsp:forward page="listCity.jsp"></jsp:forward>
	<%}else{%>
		<jsp:forward page="error.jsp?msg='El usuario o la clave no son correctos'"></jsp:forward>
	<%}%>

</body>
</html>