<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
  <% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Home</title>
</head>
<body>
<form action="./deleteBus" method = "post">
<h3 align="center">Delete Bus</h3>
	<table align="center" border="1">
			<tr>
				<td>Bus ID</td>
				<td> : </td>
				<td><input type="number" name="busId" required placeholder="Enter Bus ID to be deleted"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Delete">
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