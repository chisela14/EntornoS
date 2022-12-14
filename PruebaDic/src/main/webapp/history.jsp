<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="pruebaDic.model.User" %>
    <%@ page import ="pruebaDic.model.Train" %>
     <%@ page import ="pruebaDic.model.Travels" %>
    <%@ page import ="pruebaDic.DAO.DaoTravel" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historial de compras</title>
</head>
<body>
	<%HttpSession se = request.getSession(); 
	User userSession = (User) se.getAttribute("user");
	if(userSession !=null){%>
		<h1>Historial de compras</h1>
		<table class="table">
				<thead>
					<tr>
						<th>TREN</th>
					</tr>
				</thead>
				<tbody>
				  	<tr>
				  	 <%	DaoTravel dt = new DaoTravel(); 
				  	 List<Travels> travels = dt.getUserTravels(userSession);
						for(Travels t: travels){ %>
				  		<td><%=t.getTrain()%></td>
				  	<%}%>
				  	</tr>
				  	<tr>
					  	<td>
					  		<a href="indexForUser.jsp">
								<button id="backbutton" name="back" class="btn btn-primary" 
								style="float: left;">Volver</button>
							</a>
					  	</td>
				  	</tr>
				 
					
				</tbody>

			</table>
		
	<%}else{%>
		<jsp:forward
		page="error.jsp?msg='No te has autenticado'"></jsp:forward>
	<% } %>

</body>
</html>