<%@ page import="ie.cit.cloudapp.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Tracker</title>
</head>
<body>
	<c:forEach items="${currentusr}" var="usr" varStatus="row">
		<div class="username">Welcome ${usr}!</div>
	<h1>Main Menu</h1>
	<h2>Please select one option from the list below:</h2>
	<div class="Body">
		<div class="Border">

		   <a href="addtrip.html?username=${usr}">Add Trip</a>
		   
		</div> <!--end Border-->
		</div> <!--end Body-->
	</c:forEach>
</body>
</html>





