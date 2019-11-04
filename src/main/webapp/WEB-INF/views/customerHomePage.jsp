<%@page import="com.capgemini.busscheduling.beans.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
       <% String msg = (String) request.getAttribute("msg"); %>
      <% HttpSession session = request.getSession(false); 
      Users user = (Users) session.getAttribute("customer");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
	<%if(user!=null) { %>
	<h1 align="center">Hello <%= user.getName() %></h1>
	<%} %>
	<h3 align="center">Welcome to Customer Home Page</h3><br>
	<a href= "./updateCustomer">Update Customer</a><br><br>
	<a href= "./deleteCustomer">Delete Customer</a><br><br>
	<a href= "./bookTicket">Book Ticket</a><br><br>
	<a href= "./cancelTicket">Cancel Ticket</a><br><br>
	<a href= "./getTicket">Get Ticket</a><br><br>
	<a href= "./giveFeedback">Give Feedback</a><br><br>
	<br>
	<a href= "./logout">Logout</a><br><br>
	
	<% if(msg!=null && !msg.isEmpty()) { %>
	<%=msg %>
	<%} %>
</body>
</html>