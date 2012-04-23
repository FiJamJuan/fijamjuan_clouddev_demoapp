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
			
			<c:if test="${count eq 0}">
				<div class="login">To start please enter some user details
					here:</div>
				</br>
					${count}
					<form  method="post">
					
					<div class="login">Username:</div>
					<input name="username">
					
					<div class="login">Password:</div>
					<input name="pwd">
					
					<div class="login">Email:</div>
					<input name="email">
					
					<div class="login">Home Country:</div>
					<input name="home">
					
					<div class="login"></div>
					<input value="Login" type="submit">
				</form>
			</c:if>


			<c:forEach items="${user}" var="user" varStatus="row">
		        	${usermessage}
		        	
			 <c:if test="${user.addtrip}">
					</br>
					<c:if test="${existingtrip}">
				                Please check the data - the departure date and destination were the same as an existing trip.
				                </c:if>
					</br>
					<form method="post">
						<div class="trip">
							<div class="trip">Route Id:</div>
							<input name="route"><br/> 
							<u>Outbound Trip</u> </br>
							<div class="trip">Departure Country:</div>
							<input name="departure">
							<div class="trip">Date of Departure:</div>
							<input name="strdeptdate"><br/>
							 <u>Return Trip</u> </br>
							<div class="trip">Destination Country:</div>
							<input name="destination">
							<div class="trip">Date of Exit:</div>
							<input name="strexitdate"> <input value="Add Trip"
								type="submit">
					</form>
				
				
					<table border="1">
	                   <tr>
							<th>Route</th>
							<th>Origin</th>
							<th>Departure Date</th>
							<th>Destination</th>
							<th>Exit Date</th>
							<th>Days at Destination</th>

						</tr>
						<c:if test="${empty trips}">
						<br />No trips added.
						</c:if>
						
						<c:forEach items="${trips}" var="trips" varStatus="row">
	                   
							<tr>
								<td>${trips.route}</td>
								<td>${trips.departure}</td>
								<td>${trips.deptdate}</td>
								<td>${trips.destination}</td>
								<td>${trips.exitdate}</td>
								<td>${trips.days}</td>
			<td><form method="post"><input name="_method" type="hidden" value="delete"> <input
				name="tripId" type="hidden" value="${trips.id}"> <input
				type="submit" value="Delete"></form></td>
		<br />
							</tr>
						
						</c:forEach>
						</table>
			</c:if>
			</c:forEach>

		</div>
		<!--end Border-->
	</div>
	<!--end Body-->


</body>
</html>



