<%@ page import="ie.cit.cloudapp.UserInfo"%>
<%@ page import="ie.cit.cloudapp.Trip"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<div class="Header">
	<h1>Travel Tracker</h1>
	<br />
</div>
<!--end Header-->
</head>
<body>

	<div class="Body">
			<div class="Border">
								<h2>Login</h2>
					</br>
					<div class="login">To start please enter some user details
						here:</div>
					</br>
					<form method="post">
						<div class="login">Username:</div>
						<input name="username">
						<div class="login">First Name:</div>
						<input name="fname">
						<div class="login">Last Name:</div>
						<input name="lname">
						<div class="login">Email:</div>
						<input name="email">
						<div class="login"></div>
						<input value="Login" type="submit">
					</form>
				
					<c:forEach items="${user}" var="user" varStatus="row">
		         		Hello ${user.username} !
		     
							
								<div class="trip">	Please add a new trip for ${user.username}</div>
								</br>
								<form method="post">
									<div class="trip">	
										<div class="trip">Date of Departure:</div>
										<input name="deptdate">
										<div class="trip">Departure Country:</div>
										<input name="departure">
										<div class="trip">Date of Arrival:</div>
										<input name="arrdate">
										<div class="trip">Destination Country:</div>
									<input name="destination">
									<div class="trip">Route:</div>
									<input name="route"> 
									<input value="Add Trip" type="submit">
								</form>
						       Trips added:
								DeptDate	${trips.deptdate} ,
								Departure	${trips.departure} ,
								Arrival	${trips.arrdate} ,
								Destn	${trips.destination} ,
								Rte	${trips.route} ,
								Name	${trips.username} ,
											
</c:forEach>
			</div>
			<!--end Border-->
	</div>
	<!--end Body-->
</body>
</html>



