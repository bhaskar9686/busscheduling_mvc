<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@page session="false" %>
         <%  String msg = (String) request.getAttribute("msg") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Home</title>
</head>
<body>
<form action="./updateBus" method="post">
<h1 align="center"> Update Bus Details!!!...</h1>
		<table align="center" border="1">
			<tr>
				<td>Bus ID</td>
				<td> : </td>
				<td><input type="number" name="busId" required placeholder="Enter Bus ID"></td>
			</tr>
			<tr>
				<td>Bus Name</td>
				<td> : </td>
				<td><input type="text" name="busName" required placeholder="Enter Bus Name"></td>
			</tr>
			<tr>
				<td>Source</td>
				<td> : </td>
				<td><input type="text" name="source" required placeholder="Enter Source"></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td> : </td>
				<td><input type="text" name="destination" required placeholder="Enter Destination"></td>
			</tr>
			<tr>
				<td>Bus Type</td>
				<td> : </td>
				<td><input type="text" name="busType" required placeholder="Enter Bus Type "></td>
			</tr>
			<tr>
				<td>Price</td>
				<td> : </td>
				<td><input type="number" name="price" required placeholder="Enter Price"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Update Bus">
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