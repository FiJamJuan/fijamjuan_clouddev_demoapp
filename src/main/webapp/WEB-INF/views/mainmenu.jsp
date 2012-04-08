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
	<c:forEach items="${logins}" var="login" varStatus="row">
		<div class="username">Welcome ${login.username}!</div>
	</c:forEach>
	<h1>Main Menu</h1>
	<h2>Please select one option from the list below:</h2>
	<div class="Body">
		<div class="Border">
		    <form method="post">
		    <div class="MainMenu"><a href="viewall.jsp"><input type="submit" name="viewtrips" value="View Trips" /></a></div>
		    </form>
			  <form method="post">
		    <div class="MainMenu"><a href="addtrip.html"><input type="submit" name="addtrips" value="Add Trip" /></a></div>
		    </form>
			<form method="post">
				<div class="MainMenu"><input type="submit" name="calculatedays" value="Calculate Days" ></div>
			</form>
		</div> <!--end Border-->
		</div> <!--end Body-->
</body>
</html>





