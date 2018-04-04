<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@ include file="jspf/head_config.jspf"%>

</head>
<body>

	<!-- Sidebar -->
	<div class="w3-sidebar w3-dark-grey w3-bar-block" style="width: 15%">
		<h2 class="w3-bar-item">Menu</h2>
		<a href="${pageContext.request.contextPath}"
			class="w3-bar-item w3-button">MAIN</a> <a href="register"
			class="w3-bar-item w3-button">Register</a> <a href="login"
			class="w3-bar-item w3-button">Login</a>
		<p class='error'>${msg}</p>
	</div>

	<!-- Page Content -->
	<div style="margin-left: 15%">

		<div class="w3-container w3-teal">
			<h1>Personal Training Diary</h1>
		</div>

		<div class="w3-container">

			<div>
				<h2>Register:</h2>
			</div>


			<form:form modelAttribute="trainerDTO" method="post" enctype="utf8">
				<div>
					<form:input path="name" placeholder="Name" />
					<form:errors path="name"></form:errors>
				</div>
				<br>
					<div>
						<form:input path="surname" placeholder="Surname" />
						<form:errors path="surname"></form:errors>
					</div> <br>
						<div>
							<form:input path="phoneNumber" placeholder="PhoneNumber" />
							<form:errors path="phoneNumber"></form:errors>
						</div> <br>
							<div>
								<form:input type="email" path="email" placeholder="E-mail" />
								<form:errors path="email"></form:errors>
							</div> <br>
								<div>
									<form:password path="password" placeholder="PASSWORD" />
									<form:errors path="password"></form:errors>
								</div> <br>
									<div>
										<form:password path="matchingPassword"
											placeholder="MATCHING PASSWORD" />
									</div> <input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
									<div>
										<form:errors path="*" />
									</div> <br>
										<button type="submit">Register</button>
			</form:form>

		</div>

	</div>
</body>
</html>