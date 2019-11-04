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
<form action="./giveFeedback" method="post">
<h3 align="center"> Please Give Feedback!!!...</h3>
		<table align="center" border="1">
			<tr>
				<td>ID</td>
				<td> : </td>
				<td><input type="number" name="id" required placeholder="Enter your ID"></td>
			</tr>
			
			<tr>
				<td>Feedback</td>
				<td> : </td>
				<td>
				<select name = "feedback" required>
					<option>Excellent</option>
					<option>Very Good</option>
					<option>Good</option>
					<option>Average</option>
					<option>Not Satisfied</option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Submit">
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