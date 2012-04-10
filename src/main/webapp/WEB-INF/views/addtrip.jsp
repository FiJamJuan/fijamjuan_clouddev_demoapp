<%@ page import="ie.cit.cloudapp.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Tracker</title>
</head>
<body>
	<c:forEach items="${usr}" var="currentusr" varStatus="row">
			<div class="Border">
				<h2>Add Trip</h2>
				</br>
				<div class="trip">Please add trip details here:</div>
				</br>
				<form method="post">
					<div class="trip">
						Please add a new trip for ${currentusr}
						<div class="trip">Departure Date:</div>
						<input name="deptdate">
						<div class="trip">Departure Country:</div>
						<input name="departure">
						<div class="trip">Destination Country:</div></div>
						<input name="destination">
						<div class="trip">Route:</div>
						<input name="route">
				        <input value="Add Trip"
							type="submit">
				</form>
			</div>
			<!--end Border-->

	</div>
	<!--end Body-->
</c:forEach>

</body>
</html>
