<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal Training Diary</title>
</head>
<body>
You are logged as: ${loggedInPersonalTrainer.name} ${loggedInPersonalTrainer.surname}
<a href="${pageContext.request.contextPath}/logout">Logout</a>
	<h1>Personal Training Diary</h1>

	<a href="${pageContext.request.contextPath}/addClient">Add Client</a>
	
</body>
</html>