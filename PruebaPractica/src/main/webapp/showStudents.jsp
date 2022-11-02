<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.studentJacaranda.model.City" %>
    <%@ page import ="com.studentJacaranda.control.CityControl" %> 
    <%@ page import ="com.studentJacaranda.model.Student" %>
   <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de estudiantes</title>
</head>
<body>
	<% HttpSession se = request.getSession();
		String isSession = (String) session.getAttribute("login");
		String userSession = (String) session.getAttribute("user");
		if(isSession != null && userSession !=null && isSession.equals("True")){
			City c = CityControl.getCity(Integer.parseInt(request.getParameter("id")));
			String city = c.getCity();
			ArrayList<Student> students;
			try{
				students = CityControl.getStudents(c.getId());
			}catch(Exception e){
				
			}
		%>
		<H1>LISTA DE ESTUDIANTES DE <%= city.toUpperCase() %></H1>
		<%//funcion para iterar la lista y mostrarla en el jsp %>
		
		<a href="listCity.jsp">Volver al listado</a>
	<%}else{%>
		<jsp:forward page="error.jsp?msg='No te has autenticado'"></jsp:forward>
	<%}%>

</body>
</html>