<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<div class="Header"><h1>Travel Tracker</h1><br/></div><!--end Header-->
</head>
<body>
<div class="Body">
	<c:forEach items="${loginrepo.logins}" var="login" varStatus="row">	
			  ${login.text}
	</c:forEach>
<form method="post">
<div class="LeftPage">
<div class="Border">
	<h2>Login</h2></br>
<div class="login">If you are an existing user please Login here:</div></br>
		<div class="login">Username:</div> <input name="username">
		<div class="login">Password:</div> <input name="password">
		</br><input value="Login" type="submit">
</div> <!--end Border-->
</div> <!--end LeftPage-->
<div class="RightPage">
<div class="Border">
	<h2>Register</h2></br>
<div class="login">If you are a new user please Register here:</div></br>
	<div class="login">Username:</div> <input name="username">
        <div class="login">Password:</div> <input name="password">
	</br><input value="Register" type="submit">
</div> <!--end Border-->
</div> <!--end RightPage-->
</form>
</div> <!--end Body-->
</body>
</html>