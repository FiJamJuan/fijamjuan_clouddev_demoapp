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
					 <c:if test="${count eq 0}">
					<div class="login">To start please enter some user details
						here:</div>
					</br>
					${count}
					<form name="userdetails" method="post">
					<errors path="*" cssClass="error" />
						<div class="login">Username:</div>
						<input name="username">
						<errors path="*" cssClass="error" />
						<div class="login">Password:</div>
						<input name="pwd">
						<errors path="*" cssClass="error" />
						<div class="login">Email:</div>
						<input name="email">
						<errors path="*" cssClass="error" />
						<div class="login">Home Country:</div>
						<input name="home">
						<errors path="*" cssClass="error" />
						<div class="login"></div>
						<input value="Login" type="submit">
					</form>
					</c:if>
				  
				   
		        	<c:forEach items="${user}" var="user" varStatus="row">
		        	${usermessage}
		        	${user.addtrip}
				    <c:if test="${user.addtrip}">
				    </br>
				                <c:if test="${existingtrip}">
				                Please check the data - the departure date and destination were the same as an existing trip.
				                </c:if>
								</br>
								<form method="post" >
									<div class="trip">	
									<div class="trip">Route Id:</div>
									<input name="route"> 
									<u>Outbound Trip</u> </br>
										<div class="trip">Departure Country:</div>
										<input name="departure">
										<div class="trip">Date of Departure:</div>
										<input name="strdeptdate">
									<u>Return Trip</u> </br>
									<div class="trip">Destination Country:</div>
											<input name="destination">
									<div class="trip">Date of Exit:</div>
										<input name="strexitdate">
									
							
									
									<input value="Add Trip" type="submit">
								</form>
						       <br/>
						       Trips Added:
						       <br/>
						       <table id="myTable1" border="1">
						       <tr>
						       <td>Route</td>
  
    <td>Departure</td>
    <td>Departure Date</td>
     <td>Destination</td>
    <td>Exit Date</td>
     <td>Days at Destination</td>

  </tr>
						       <c:forEach items="${trips}" var="trips" varStatus="row">
								<table id="myTable" border="1">
  
  <tr>
 <td>${trips.route}</td> 
    <td>${trips.departure} </td>
    <td>${trips.deptdate}</td>
     <td>${trips.destination} </td>
    <td>${trips.exitdate}</td>
     <td>${trips.days}</td>
  </tr>
</table>
								
							</c:forEach>
						</c:if>					
</c:forEach>

			</div>
			<!--end Border-->
	</div>
	<!--end Body-->
	// data validation


</body>
</html>



