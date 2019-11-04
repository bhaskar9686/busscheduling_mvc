<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
  <% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<form action="./ticketCancel" method = "post">
<h3 align="center"><u> Ticket Cancelation- </u></h3>
	<table align="center" border="solid">
			<tr>
				<td>ID</td>
				<td> : </td>
				<td><input type="number" name="id" required placeholder="Enter Your ID"></td>
			</tr>
			<tr>
				<td>Booking ID</td>
				<td> : </td>
				<td><input type="number" name="bookingId" required placeholder="Enter Booking ID"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Cancel Ticket">
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