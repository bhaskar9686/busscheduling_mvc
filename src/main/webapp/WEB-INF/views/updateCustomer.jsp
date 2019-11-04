<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@page session="false" %>
         <%  String msg = (String) request.getAttribute("msg") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
<form action="./updateProfile" method="post">
<h1 align="center"> Update Customer Details!!!...</h1>
		<table align="center" border="1">
		<tr>
				<td>ID</td>
				<td> : </td>
				<td><input type="number" name="id" required placeholder="Enter your ID"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td> : </td>
				<td><input type="text" name="name" required placeholder="Enter Name"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td> : </td>
				<td><input type="email" name="email" required placeholder="Enter Email"></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td> : </td>
				<td><input type="number" name="contact" required placeholder="Enter Contact"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Update Profile">
				</td>
			</tr>
		</table>
	</form>
	<br><br>
	<%if (msg != null && !msg.isEmpty()) { %>
		<%=msg%>
	<%} %>
</body>
</html>