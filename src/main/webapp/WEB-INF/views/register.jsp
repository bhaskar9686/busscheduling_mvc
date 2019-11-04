<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@page session="false" %>
         <%  String msg = (String) request.getAttribute("msg") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<form action="./addUser" method="post">
<h3 align="center"> Please Register!!!...</h3>
		<table align="center" border="1">
			<tr>
				<td>ID</td>
				<td> : </td>
				<td><input type="number" name="id" required placeholder="Enter your ID"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td> : </td>
				<td><input type="text" name="name" required placeholder="Enter your Name"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td> : </td>
				<td><input type="email" name="email" required placeholder="Enter your Email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td> : </td>
				<td><input type="password" name="password" required placeholder="Enter your Password"></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td> : </td>
				<td><input type="number" name="contact" required placeholder="Enter your Phone Number"></td>
			</tr>
			<tr>
				<td>Type</td>
				<td> : </td>
				<td>
				<select name = "type" required>
					<option>Owner</option>
					<option>Customer</option>
				</select>
					<!-- <input type="dropdown" name="contact" required> -->
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Register">
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