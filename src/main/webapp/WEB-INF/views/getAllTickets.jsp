<%@page import="java.util.List"%>
<%@page import="com.capgemini.busscheduling.beans.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page session="false" %>
    <%List<Ticket> tickList = (List<Ticket>)request.getAttribute("ticketList"); %>
<!DOCTYPE html>
<html>
<head>
<style>
	table, tr, th,td{
		collapse="border-collapse";
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"><u> All Ticket Details -</u></h2>
	<br><br>
	<table border="solid" align="center">
		<thead>
			<tr>
				<th>Booking Id</th>
				<th>Bus Id</th>
				<th>User Id</th>
				<th>Journey Date</th>
				<th>Seats Booked</th>
				<th>Booking Date</th>
			</tr>
		</thead>
		<tbody>
		<%if(tickList!=null) {%>
			<%for (Ticket ticket : tickList) { %>
				<tr>
					<td><%=ticket.getBookingId()%></td>
					<td><%=ticket.getBusId()%></td>
					<td><%=ticket.getId()%></td>
					<td><%=ticket.getJourneyDate()%></td>
					<td><%=ticket.getNumOfSeats()%></td>
					<td><%=ticket.getBookingDateTime()%></td>
				</tr>
			<%}%>
			<%}%>
		</tbody>
	</table>
</body>
</html>