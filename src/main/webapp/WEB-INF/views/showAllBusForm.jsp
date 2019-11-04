<%@page import="com.capgemini.busscheduling.beans.Bus"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page session="false" %>
    <%List<Bus> bus = (List<Bus>)request.getAttribute("buses"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Home</title>
</head>
<body>
<h1 align="center">Show All Buses</h1>
<table border="solid" align="center">
		<thead>
			<tr>
				<th>Bus Id</th>
				<th>Bus Name</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Bus Type</th>
				<th>Total Seats</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
		<%if(bus!=null) {%>
			<%for (Bus buses : bus) { %>
				<tr>
					<td><%=buses.getBusId()%></td>
					<td><%=buses.getBusName()%></td>
					<td><%=buses.getSource()%></td>
					<td><%=buses.getDestination()%></td>
					<td><%=buses.getBusType()%></td>
					<td><%=buses.getPrice()%></td>
				</tr>
			<%}%>
			<%}%>
		</tbody>
	</table>
</body>
</html>