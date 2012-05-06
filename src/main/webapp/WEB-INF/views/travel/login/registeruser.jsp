<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
<!--
function validateForm()
{
var x=document.forms["Register"]["pwd"].value;
var y=document.forms["Register"]["cpwd"].value;
if (x!=y)
  {
  alert("Password does not match!");
  return false;
  }
}
//-->
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


Register User
				<div class="login">To start please enter some user details
					here:</div>
				</br>
					${count}
					
					<form name="Register" method="post" onsubmit="return validateForm();">
					<div class="login">Username:</div>
					<input name="username">
					
					<div class="login">Password:</div>
					<input name="pwd" type="password">
					
					<div class="login">Re-type Password:</div>
					<input name="cpwd" type="password">
					
					<div class="login">Email:</div>
					<input name="email">
					
					<div class="login">Home Country:</div>
					<input name="home">
					
					<div class="login"></div>
					<input value="Register" type="submit" value="registernewuser">
					
				</form>
			
</body>
</html>