<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
  <% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Login</title>
</head>
<body>
<form action="./login" method = "post">
<h3 align="center">Wellcome back Please Login</h3>
	<table align="center" border="solid">
			<tr>
				<td>User ID</td>
				<td> : </td>
				<td><input type="number" name="id" required placeholder="Enter Your ID"></td>
			</tr>
			<tr>
				<td>User Password</td>
				<td> : </td>
				<td><input type="password" name="password" required placeholder="Enter Your Password"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Login">
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