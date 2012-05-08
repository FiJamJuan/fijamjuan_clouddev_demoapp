<%@ page import="ie.cit.cloudapp.Trip"%>
<%@ page import="ie.cit.cloudapp.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
<!--
	function validateForm() {
		var a = document.forms["Addtrip"]["route"].value;
		var b = document.forms["Addtrip"]["departure"].value;
		var c = document.forms["Addtrip"]["strdeptdate"].value;
		var d = document.forms["Addtrip"]["destination"].value;
		var e = document.forms["Addtrip"]["strexitdate"].value;
		if ((a == null || a == "") & (b == null || b == "")
				& (c == null || c == "") & (d == null || d == "")
				& (e == null || e == "")) {

			alert("This new trip does not contain any data!")
			return false;
		}
		if (a == null || a == "") {
			alert("Please enter a Route Id (e.g. FLight Number).");
			return false;
		}
		if (b == null || b == "") {
			alert("Please enter a Departure Country.");
			return false;
		}
		if (c == null || c == "") {
			alert("Please enter a Departure Date, dd/mm/yyyy.");
			return false;
		}
		if (d == null || d == "") {
			alert("Please enter a Destination Coutry.");
			return false;
		}

		if (e == null || e == "") {
			alert("Please enter an Exit Date, dd/mm/yyyy.");
			return false;
		}
		
		var dayslash=e.indexOf("/");
		var monthslash=e.lastIndexOf("/");
		
		if (isNaN(c.substr(0,2)) || isNaN(c.substr(3,2)) || isNaN(c.substr(6,4)))
	      {
		  alert("Not a valid departure date, should be in numeric dd/mm/yyyy format");
		  return false;
		  }
		
		if (dayslash!=2 || monthslash!=5 || e.length!=10 )
		  {
		  alert("Not a valid departure date, should be in dd/mm/yyyy format");
		  return false;
		  }
		
		var depdayslash=c.indexOf("/");
		var depmonthslash=c.lastIndexOf("/");

		if (isNaN(c.substr(0,2)) || isNaN(c.substr(3,2)) || isNaN(c.substr(6,4)))
	      {
		  alert("Not a valid exit date, should be in numeric dd/mm/yyyy format");
		  return false;
		  }
		
		if (depdayslash!=2 || depmonthslash!=5 || c.length!=10 )
		  {
		  alert("Not a valid exit date, should be in dd/mm/yyyy format");
		  return false;
		  }
	}
//-->
</script>
<head>
<link rel="stylesheet" href="../../style/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Tracker</title>
</head>
<div class="TopBanner">
	<h1>Travel Tracker</h1>
</div>
<!--end TopBanner-->
<body>
	<div class="InnerFrame">

		<br />
		<div class="normal">
			<a href="../../j_spring_security_logout">Logout </a>
		</div>
		<br />
		
		<c:forEach items="${user}" var="user" varStatus="row">
			<div class="normal">Hello ${user.username}! <br/>Please enter a new
				Trip:</div>

			<c:if test="${existingtrip}">
				              <div class="warning">  Please check the data - the departure date and destination were the same as an existing trip.
				               <br/> No new data added. </div>
				                </c:if>
				                <c:if test="${dateformaterror}">
				              <div class="warning">  Date format error, please enter date in format "DD/MM/YYYY"</div>
				                </c:if>
			</br>
			<div class="normal">
				<form name="Addtrip" method="post" onsubmit="return validateForm();">
					<div class="Route">
						<div class="trip">Route Id:</div>
						<input name="route"><br />
					</div>
					<!--end  Route -->
					<div class="Out">
						<u>Outbound</u> </br>
						<div class="trip">Departure Country (From):</div>
						<input name="departure">
						<div class="trip">Date of Departure:</div>
						<input name="strdeptdate"> <br />dd/mm/yyyy
					</div>
					<!--end  Out -->
					<div class="Return">
						<u>Return</u> </br>
						<div class="trip">Destination Country (To):</div>
						<input name="destination">
						<div class="trip">Date of Exit:</div>
						<input name="strexitdate"> <br />dd/mm/yyyy
						<br/>
						<input value="Add Trip" type="submit">
					</div>  <!--end  Return -->
						
		
				</form>
			</div>
			<!--end  Normal -->
         <br/>
			<div class="Table">
				<table border="1">
					<tr>
						<th>Route</th>
						<th>Origin</th>
						<th>Departure Date</th>
						<th>Destination</th>
						<th>Exit Date</th>
						<th>Days at Destination</th>

					</tr>
					

					<c:forEach items="${trips}" var="trips" varStatus="row">

						<tr>
							<td>${trips.route}</td>
							<td>${trips.departure}</td>
							<td>${trips.deptdate}</td>
							<td>${trips.destination}</td>
							<td>${trips.exitdate}</td>
							<td>${trips.days}</td>
							<td><form method="post">
									<input name="_method" type="hidden" value="delete"> <input
										name="tripId" type="hidden" value="${trips.id}"> <input
										type="submit" value="Delete">
								</form></td>
							<br />
						</tr>

					</c:forEach>
				</table>
				<c:if test="${empty trips}">
						<br />No trips added.
						</c:if>
			</div>
			<!--  end Table -->
		</c:forEach>


	</div>
	<!--end InnerFrame-->

</body>
</html>



