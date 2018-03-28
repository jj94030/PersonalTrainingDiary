<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal Training Diary</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="jspf/header.jspf" %>
	<h1>Personal Training Diary</h1>
	<a href="${pageContext.request.contextPath}/addClient" class="btn btn-primary btn-lg active" role="button" aria-disabled="true">Add Client</a>
	
	<a href="${pageContext.request.contextPath}/clientsList" class="btn btn-secondary btn-lg active" role="button" aria-disabled="true">Client list</a>
	
	<a href="${pageContext.request.contextPath}/edit" class="btn btn-success btn-lg active" role="button" aria-disabled="true">Edit your profile</a>
	
</body>
</html>