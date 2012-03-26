<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="ie.cit.cloudapp.Todo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="repo" class="ie.cit.cloudapp.ToDoRepository"
	scope="application"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TO DO application</title>
</head>
<body>
	<h1>TODO Application (output_list.jsp)</h1>
	<h2>List of current TODO items</h2>

	<c:if test="${ param._method.equals(\"delete\") }">
		<%
			String strTodoId = request.getParameter("todoId");
				Integer todoId = Integer.valueOf(strTodoId);
				repo.getTodos().remove(todoId-1);
		%>
	</c:if>
	<c:if test="${ param._method.equals(\"put\") }">
		<%
			String strTodoId = request.getParameter("todoId");
				Integer todoId = Integer.valueOf(strTodoId);
				repo.getTodos().remove(todoId - 1);
		%>
	</c:if>

	<c:if test="${ !empty param.Text }">
		<%
			Todo todo = new Todo();
				todo.setText(request.getParameter("Text"));
				repo.addTodo(todo);
		%>
	</c:if>
	<c:forEach items="${repo.todos}" var="todo">
${todo.text}
<form method="post">
			<input name="_method" type="hidden" value="delete"> <input
				name="todoId" type="hidden" value="${row.count}"> <input
				type="submit" value="Delete">
		</form>
		<br />
	</c:forEach>
	</br>
	<form method="post">
		Text: <input name="Text"><input type="submit">
	</form>
</body>
</html>