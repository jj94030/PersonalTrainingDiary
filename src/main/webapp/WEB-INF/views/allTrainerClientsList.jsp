<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PersonalTrainingDiary</title>
<script defer src="https://use.fontawesome.com/releases/v5.0.9/js/all.js" integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="jspf/head_config.jspf"%>

	<!-- Sidebar -->
	<div class="w3-sidebar w3-dark-grey w3-bar-block" style="width: 15%">
		<h2 class="w3-bar-item">Menu</h2>
		<a href="${pageContext.request.contextPath}"
			class="w3-bar-item w3-button">MAIN</a> <a
			href="${pageContext.request.contextPath}/addClient"
			class="w3-bar-item w3-button">Add Client</a> <a
			href="${pageContext.request.contextPath}/clientsList"
			class="w3-bar-item w3-button">List of Clients</a> <a
			href="${pageContext.request.contextPath}/logout"
			class="w3-bar-item w3-button">Logout</a>
		<p class='error'>${msg}</p>
	</div>

	<!-- Page Content -->
	<div style="margin-left: 15%">


		<div class="w3-container w3-teal">
			<h1>Personal Training Diary</h1>
		</div>
<div class="w3-container">
	<ul>

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Surname</th>
					<th scope="col">e-mail</th>
					<th scope="col">Phone number</th>
					<th scope="col">Goal</th>
					<th scope="col">Gym</th>
					<th scope="col">Training days</th>
					<th scope="col">Hour</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>




				<c:forEach items="${clients}" var="client">
					<tr>
						
						<td>${client.name}</td>
						<td>${client.surname}</td>
						<td>${client.email}</td>
						<td>${client.phoneNumber}</td>
						<td>${client.goal}</td>
						<td>${client.gym}</td>
						<td><c:forEach items="${client.daysOfTraining}"
								var="dayOfWeek">${dayOfWeek} </c:forEach></td>
						<td>${client.startTraining}- ${client.endTraining}</td>
						<td><a
							href="${pageContext.request.contextPath}/editClient/${client.id}"
							role="button">Edit</a></td>
						<td>
						<a href="${pageContext.request.contextPath}/deleteClient/${client.id}"
							role="button">Delete</a></td> 
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<a href="${pageContext.request.contextPath}/addClient">Add new
			Client</a>
			</div>
			<br><br><br>
		<%@ include file="jspf/footer.jspf"%>
	</div>
</body>
</html>