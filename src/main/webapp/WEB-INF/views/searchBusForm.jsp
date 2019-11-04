<%@page import="com.capgemini.busscheduling.beans.Bus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
  <% String msg = (String) request.getAttribute("msg"); %>
  <% Bus bus = (Bus) request.getAttribute("bus");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Home</title>
</head>
<body>
<form action="./searchBus" method = "post">
<h3 align="center">Search Bus</h3>
	<table align="center" border="1">
			<tr>
				<td>Bus Name</td>
				<td> : </td>
				<td><input type="number" name="busId" required placeholder="Enter Bus Id"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Search Bus">
				</td>
			</tr>
		</table>
		
	</form>	
	<br/>
	<%if(bus != null) { %>
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
				<tr>
					<td><%=bus.getBusId()%></td>
					<td><%=bus.getBusName()%></td>
					<td><%=bus.getSource()%></td>
					<td><%=bus.getDestination()%></td>
					<td><%=bus.getBusType()%></td>
					<td><%=bus.getPrice()%></td>
				</tr>
		</tbody>
	</table>
	<%} %>	
	
	<% if(msg != null && !msg.isEmpty()) {%>
	<%= msg %>
	<%} %>

</body>
</html>