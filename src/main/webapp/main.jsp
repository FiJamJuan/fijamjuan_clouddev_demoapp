<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TO DO application</title>
</head>
<body>
	<h1>TODO Application</h1>
	<h2>List of current TODO items</h2>
	<jsp:useBean id="repo" class="ie.cit.cloudapp.ToDoRepository"
		scope="application"></jsp:useBean>
	<c:forEach items="${repo.todos}" var="todos">
${todo.text}
</c:forEach>
	</br>
	<form>
		Text: <input name="text"><input type="submit">
	</form>
</body>
</html>