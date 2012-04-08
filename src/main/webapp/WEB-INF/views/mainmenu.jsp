<%@ page import="ie.cit.cloudapp.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="loginrepo" class="ie.cit.cloudapp.LoginRepository"
	scope="session"></jsp:useBean>
<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Tracker</title>
</head>
<body>
	<c:forEach items="${logins}" var="login" varStatus="row">
	<c:choose>
			<c:when test="${! empty ${login}">
				<h2>Hello ${login.fname} !</h2>
			</c:when>
	</c:choose>
	</c:forEach>
	<h2>!</h2>
</body>
</html>



