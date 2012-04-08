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
	<c:forEach items="${trips}" var="trip" varStatus="row">
		<c:choose>
			<c:when test="${trip.deptdate}">
				${trip.deptdate}
		   </c:when>
		<c:otherwise>
			 No trips to display.
		</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>