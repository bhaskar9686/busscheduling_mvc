<%@page import="com.capgemini.busscheduling.beans.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
  <% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
<form action="./getTicket" method = "post">
<h3 align="center">Ticket Info </h3>
	<table align="center" border="1">
			<tr>
				<td>Ticket ID</td>
				<td> : </td>
				<td><input type="number" name="bookingId" required placeholder="Enter Ticket ID to be printed"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Print">
				</td>
			</tr>
		</table>
		
	</form>	
	<br/>
	
	<% if(msg != null && !msg.isEmpty()) {%>
	<%= msg %>
	<%} %>

</body>
</html>