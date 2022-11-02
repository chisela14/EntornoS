<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.studentJacaranda.model.City" %>
<%@ page import ="com.studentJacaranda.control.CityControl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% HttpSession se = request.getSession();
	String isSession = (String) session.getAttribute("login");
	String userSession = (String) session.getAttribute("user");
	if(isSession != null && userSession !=null && isSession.equals("True")){
		%>
		<H1>BORRAR LA SIGUIENTE CIUDAD</H1>
		<form action=editCityExec.jsp  method="post">
		  <label>Identificador:</label><br>
		  <input type="text" id="id" name="id" required ><br>
		  <label>Ciudad:</label><br>
		  <input type="text" id="ciudad" name="ciudad" ><br><br>
		  <label>País:</label><br>
		  <input type="text" id="pais" name="pais" ><br><br>
		  <input type="submit" value="Submit">
		</form> 
		<a href="listCity.jsp">Volver al listado</a>
	<%}else{%>
		<jsp:forward page="error.jsp?msg='No te has autenticado'"></jsp:forward>
	<%}%>


</body>
</html>