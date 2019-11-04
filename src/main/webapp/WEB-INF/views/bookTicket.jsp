<%@page import="com.capgemini.busscheduling.beans.Ticket"%>
<%@page import="java.util.List"%>
<%@page import="com.capgemini.busscheduling.beans.Availabilty"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<%
	Ticket ticket = (Ticket) request.getAttribute("ticket");
%>
<%
	List<Availabilty> availabilty = (List<Availabilty>) request.getAttribute("availList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
	<form action="./checkAvailability" method="post">
		<h3 align="center">
			<u>Check Availability-</u>
		</h3>
		<table align="center" border="6">
			<tr>
				<td>Source</td>
				<td>:</td>
				<td><input type="text" name="source" required
					placeholder="Enter Source"></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td>:</td>
				<td><input type="text" name="destination" required
					placeholder="Enter Destination"></td>
			</tr>
			<tr>
				<td>Journey Data</td>
				<td>:</td>
				<td><input type="date" name="journeyDate" required
					placeholder="Enter Date"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><br /> <input type="submit"
					value="Search"></td>
			</tr>
		</table>
	</form>
	<%
		if (availabilty != null) {
	%>
	<h3 align="center">Availability</h3>
	<table border="6" align="center">
		<thead>
			<tr>
				<th>Bus Id</th>
				<th>Available Date</th>
				<th>Available Seats</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (availabilty != null) {
			%>
			<%
				for (Availabilty availList : availabilty) {
			%>
			<tr>
				<td><%=availList.getBusId()%></td>
				<td><%=availList.getAvailDate()%></td>
				<td><%=availList.getAvailSeat()%></td>
			</tr>
			<%
				}
			%>
			<%
				}
			%>
		</tbody>
	</table>
	<%
		}
	%>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
		}
	%>
	<%
		if (availabilty != null) {
	%>
	<form action="./bookTicket" method="post">
		<h3 align="center">
			<u> Booking.....</u>
		</h3>
		<table align="center" border="6">
			<tr>
				<td>ID</td>
				<td>:</td>
				<td><input type="text" name="id" required
					placeholder="Enter your Id"></td>
			</tr>
			<tr>
				<td>Bus ID</td>
				<td>:</td>
				<td><input type="text" name="busId" required
					placeholder="Enter Bus Id"></td>
			</tr>
			<tr>
				<td>Seats</td>
				<td>:</td>
				<td><input type="text" name="numOfSeats" required
					placeholder="Enter Seats"></td>
			</tr>
			<tr>
				<td>Journey Data</td>
				<td>:</td>
				<td><input type="date" name="journeyDate" required
					placeholder="Enter Date"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><br /> <input type="submit"
					value="Book"></td>
			</tr>
		</table>
	</form>
	<%
		}
	%>
	<br>
	<br>
	<%
		if (ticket != null) {
	%>
	<h3 align="center">
		<u>Booked Ticket-</u>
	</h3>
	<table border="6" align="center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Booking ID</th>
				<th>Bus ID</th>
				<th>JourneyDate</th>
				<th>Seats</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (ticket != null) {
			%>
			<tr>
				<td><%=ticket.getId()%></td>
				<td><%=ticket.getBookingId()%></td>
				<td><%=ticket.getBusId()%></td>
				<td><%=ticket.getJourneyDate()%></td>
				<td><%=ticket.getNumOfSeats()%></td>
				<td><%=ticket.getBookingDateTime()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<%
		}
	%>
</body>
</html>