<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="jspf/header.jspf"%>
	<ul>
		<c:forEach items="${clients}" var="client">
			<li>${client.name} ${client.surname} | ${client.email} |
				${client.phoneNumber} | ${client.goal} | ${client.gym} | 
				
				<c:forEach items="${client.daysOfTraining}" var="dayOfWeek">
					${dayOfWeek}
				</c:forEach>
				
				<a href="${pageContext.request.contextPath}/editClient/${client.id}"
				role="button">Edit</a> <a
				href="${pageContext.request.contextPath}/deleteClient/${client.id}"
				role="button">Delete</a>

			</li>
		</c:forEach>
	</ul>

	<a href="${pageContext.request.contextPath}/addClient">Add new
		Client</a>
</body>
</html>