<%@ page import="ie.cit.cloudapp.Trip"%>
<%@ page import="ie.cit.cloudapp.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
<!--
function validateForm()
{
	var a=document.forms["Addtrip"]["route"].value;
	var b=document.forms["Addtrip"]["departure"].value;
	var c=document.forms["Addtrip"]["strdeptdate"].value;
	var d=document.forms["Addtrip"]["destination"].value;
	var e=document.forms["Addtrip"]["strexitdate"].value;
	if ((a==null || a=="") & (b==null || b=="") & (c==null || c=="") & (d==null || d=="") & (e==null || e==""))
	{
	
alert("This new trip does not contain any data!")
return false;
	}
	if (a==null || a=="")
	{
	alert("Please enter a Route Id (e.g. FLight Number).");
	return false;
	}  
	if (b==null || b=="")
	{
	alert("Please enter a Departure Country.");
	return false;
	}
	if (c==null || c=="")
	{
	alert("Please enter a Departure Date, dd/mm/yyyy.");
	return false;
	}
	if (d==null || d=="")
	{
	alert("Please enter a Destination Coutry.");
	return false;
	}

	if (e==null || e=="")
	{
	alert("Please enter an Exit Date, dd/mm/yyyy.");
	return false;
	}
}
//-->
</script>
<head>
<link rel="stylesheet" href="/style/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<div class="Header">
	<h1>Travel Tracker</h1>
	<br />
</div>
<!--end Header-->
</head>
<body>
    <a href="../../j_spring_security_logout">Logout <security:authentication property="principal.username"/>
    </a>
   
	<div class="Body">
		<div class="Border">
		
			<c:forEach items="${user}" var="user" varStatus="row">
		    Hello ${user.username}, please enter a new trip:
					<c:if test="${existingtrip}">
				                Please check the data - the departure date and destination were the same as an existing trip.
				                </c:if>
					</br>
					<form name="Addtrip" method="post" onsubmit="return validateForm();">
						<div class="trip">
							<div class="trip">Route Id:</div>
							<input name="route"><br/> 
							<u>Outbound Trip</u> </br>
							<div class="trip">Departure Country:</div>
							<input name="departure">
							<div class="trip">Date of Departure:</div>
							<input name="strdeptdate"> dd/mm/yyyy<br/>
							 <u>Return Trip</u> </br>
							<div class="trip">Destination Country:</div>
							<input name="destination">
							<div class="trip">Date of Exit:</div>
							<input name="strexitdate"> dd/mm/yyyy
							<input value="Add Trip"
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
	
			</c:forEach>

		</div>
		<!--end Border-->
	</div>
	<!--end Body-->


</body>
</html>



