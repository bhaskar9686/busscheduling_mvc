<%@page import="com.capgemini.busscheduling.beans.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
      <% String msg = (String) request.getAttribute("msg"); %>
      <% HttpSession session = request.getSession(false); 
      Users user = (Users) session.getAttribute("owner");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Home</title>
</head>
<body>
	<%if(user!=null) { %>
	<h1 align="center">Hello <%= user.getName() %></h1>
	<%} %>
	<h3 align="center">Welcome to Owner Home Page</h3><br>
	<a href= "./addBus">Add Bus</a><br><br>
	<a href= "./deleteBus">Delete Bus</a><br><br>
	<a href= "./updateBus">Update Bus</a><br><br>
	<a href= "./getTickets">Show All Tickets</a><br><br>
	<a href= "./setAvailabilty">Set Bus Availability</a><br><br>
	<a href= "./searchBus">Show Bus</a><br><br>
	<a href= "./viewBus">View All Bus</a><br><br>
<!-- 	<a href= "./checkAvailability">Availability</a><br><br>  -->
<!-- 	<a href= "./deleteCustomer">Delete Customer</a><br><br> -->
	<br>
	<a href= "./logout">Logout</a><br><br>
	
	<% if(msg!=null && !msg.isEmpty()) { %>
	<%=msg %>
	<%} %>
</body>
</html>