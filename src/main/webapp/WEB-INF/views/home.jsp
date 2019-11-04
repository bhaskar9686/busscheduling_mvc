<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%
	String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bus Booking System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
header {
	background-color: rgba(148,118,8,1);
	padding: 5px;
	text-align: center;
	font-size: 35px;
	color: lime;
}

nav {
	float: left;
	width: 31%;
	height: 300px;
	background: activeborder;
	padding: 20px;
	text-align: center;
}

nav ul {
	list-style-type: none;
}

article {
	float: right;
	padding: 20px;
	width: 63%;
	background-color: silver;
	height: 300px;
}

footer {
	background-color: rgba(0,62,219,1);
	padding: 20px;
	text-align: center;
	color: white;
	font-size: 20px;
}
}
</style>
</head>
<body>

	<header>
		<h1>Bus Booking System</h1>
		<h5><%
			if (msg != null && !msg.isEmpty()) {
		%>
		<%=msg%>
		<%
			}
		%></h5>
	</header>

	<section>
		<nav>
			<ul>
				<li><h2>
						<a href="loginPage">Login</a>
					</h2></li>
			</ul>
		</nav>
		<article>
			 <img
				src="https://cdn.pixabay.com/photo/2014/04/02/16/18/bus-306858__340.png"> 
		</article>
	</section>

	<footer>
		<p>@About Us</p>
		<address>Contact: bhaskarva@gmail.com</address>
	</footer>
</body>
</html>


