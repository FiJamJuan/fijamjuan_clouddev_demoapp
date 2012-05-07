<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
<!--
function validateForm()
{
var a=document.forms["Register"]["email"].value;
var b=document.forms["Register"]["home"].value;
var c=document.forms["Register"]["username"].value;
var atpos=a.indexOf("@");
var dotpos=a.lastIndexOf(".");
var x=document.forms["Register"]["pwd"].value;
var y=document.forms["Register"]["cpwd"].value;
if ((c==null || c=="") & (a==null || a=="") & (b==null || b=="") & (x==null || x=="") & (y==null || y==""))
	{
	
alert("This form does not contain any data. Please complete the required information in order to register.")
return false;
	}
	
if (c==null || c=="")
{
alert("Please enter a username.");
return false;
}  
if (x==null || x=="")
{
alert("Please enter a password.");
return false;
}

if (y==null || y=="")
{
alert("Please confirm your password.");
return false;
}
if (x!=y)
{
alert("Password does not match!");
return false;
}
if (a==null || a=="")
{ 
alert("Please enter an email address.");
return false;
}  
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=a.length)
{
alert("Not a valid e-mail address");
return false;
}
if (b==null || b=="")
{
alert("Please enter your Home Country.");
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
					<input name="username">*
					
					<div class="login">Password:</div>
					<input name="pwd" type="password">*
					
					<div class="login">Re-type Password:</div>
					<input name="cpwd" type="password">*
					
					<div class="login">Email:</div>
					<input name="email">*
					
					<div class="login">Home Country:</div>
					<input name="home">*
					
					<div class="login"></div>
					<input value="Register" type="submit" value="registernewuser">
					
				</form>
			    Note * indicates a required field.
</body>
</html>