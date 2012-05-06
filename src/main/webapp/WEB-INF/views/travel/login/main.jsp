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
<body>
<div class="Body">
<div class="LeftPage">
<div class="Border">
	<h2>Login</h2></br>
<div class="login">If you are an existing user please Login here:</div></br>
<form method="post">
		<input name="userlogin" value="Proceed to Login" type="submit">
		</form>
</div> <!--end Border-->
</div> <!--end LeftPage-->
<div class="RightPage">
<div class="Border">
	<h2>Register</h2></br>
<div class="login">If you are a new user please Register here:</div></br>
  <form method="post" >
    	<input name="select" value="register" type="hidden">
	<input name="registeruser" value="Proceed to Register" type="submit">
	</form>
</div> <!--end Border-->
</div> <!--end RightPage-->

</div> <!--end Body-->
</body>
</html>



