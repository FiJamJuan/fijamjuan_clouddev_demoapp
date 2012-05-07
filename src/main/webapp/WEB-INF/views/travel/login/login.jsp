<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Tracker</title>
</head>
<link rel="stylesheet" href="../../style/style.css" />
</head><body onload='document.f.j_username.focus();'>
<div class="OuterFrame">
<div class="TopBanner">
<h1>Travel Tracker</h1>
</div> <!--end TopBanner-->
<div class="Register">
<div class="normal">
${error}<br/>
Login with Username and Password<form name='f' action='../../j_spring_security_check' method='POST'>
 <table>
 
    <tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
    <tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
    <tr><td colspan='2'><input name="submit" type="submit" value="login"/></td></tr>
  </table>
</form>			 
</div>   <!--end Normal-->
</div> <!--end Register-->
</div> <!--end OuterFrame-->
</body>
</html>