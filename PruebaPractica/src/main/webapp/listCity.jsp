<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="com.studentJacaranda.model.City" %>
<%@ page import ="com.studentJacaranda.control.CityControl" %>
<%@ page import ="com.studentJacaranda.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de ciudades</title>
</head>
<body>
	<% HttpSession se = request.getSession();
	String isSession = (String) session.getAttribute("login");
	String userSession = (String) session.getAttribute("user");
	if(isSession != null && userSession !=null && isSession.equals("True")){%>
	<a href="addCity.jsp">Añadir ciudad</a>
	<table border=1>
	  <tr>
	    <th>Identificador</th>
	    <th>Ciudad</th>
	    <th>País</th>
	    <th></th>
	    <th></th>
	    <th></th>
	  </tr>
  <%
 		out.print("<tr>");
		out.print("<th>" + c.getId() + "</th>");
		out.print("<th>" + c.getCity() + "</th>");
		out.print("<th>" + c.getCountry() + "</th>");
		out.print("<th><a href=editCity.jsp?id=" + c.getId() +">Editar"  + "</a></th>");
		out.print("<th><a href=deleteCity.jsp?id=" + c.getId() +">Borrar"  + "</a></th>");
		out.print("<th><a href=showStudents.jsp?id=" + c.getId() +">Ver estudiantes"  + "</a></th>");
		out.print("</tr>");

%>
	<%}else{%>
		<jsp:forward page="error.jsp?msg='No te has autenticado'"></jsp:forward>
	<%}%>

 
</table>
</body>
</html>