<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="pruebaDic.model.User" %>
    <%@ page import ="pruebaDic.model.Train" %>
    <%@ page import ="pruebaDic.DAO.DaoTrain" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Comprar billete</title>
</head>
<body>
<%HttpSession se = request.getSession(); 
	User userSession = (User) se.getAttribute("user");
	if(userSession !=null){
		int code = Integer.parseInt(request.getParameter("train"));
	%>
		<h1>Tren seleccionado</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>SALIDA</th>
					<th>DESTINO</th>
					<th>PRECIO</th>
					<th>FECHA</th>
					<th>NUM. ASIENTOS LIBRES</th>
				</tr>
			</thead>
			<tbody>
			  <%			
	  		  	DaoTrain daoTrain = new DaoTrain();
	  		  	Train train = daoTrain.get(code);
				se.setAttribute("train", train);
			  %>
			  	<tr>
			  		<td><%=train.getId()%></td>
			  		<td><%=train.getOrigin()%></td>
			  		<td><%=train.getFinalStation()%></td>
			  		<td><%=train.getPrice()%></td>
			  		<td><%=train.getDate()%></td>
			  		<td><%=train.getNumbertickets()%></td>
			  	</tr>
			  	<tr>
			  		<td>
						<form action="BuyServlet" method="post">
							<button id="buybutton" name="buy" class="btn btn-primary" 
							style="float: right;">Comprar</button>
						</form>
			  		</td>
			  		<td>
						<a href="indexForUser.jsp">
							<button id="backbutton" name="back" class="btn btn-primary" 
							style="float: left;">Cancelar</button>
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