<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
      <% Integer seats = (Integer) request.getAttribute("seats"); %>
  <% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Home</title>
</head>
<body>
<form action="./checkAvailability" method = "post">
<h3 align="center">Set Bus Availability</h3>
	<table align="center" border="solid">
			<tr>
				<td>Bus ID</td>
				<td> : </td>
				<td><input type="number" name="busId" required placeholder="Enter Bus ID"></td>
			</tr>
			<tr>
				<td>Available Data</td>
				<td> : </td>
				<td><input type="date" name="availDate" required placeholder="Enter Date"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Check Availability">
				</td>
			</tr>
		</table>
		
	</form>	
	<br/>
	<%if(seats!=null) { %>
	Available Seats : <%=seats %>
	<%} %>
	<% if(msg != null && !msg.isEmpty()) {%>
	<%= msg %>
	<%} %>

</body>
</html>