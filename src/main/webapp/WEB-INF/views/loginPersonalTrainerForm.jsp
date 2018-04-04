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



		<div class="w3-containe">


			<div>
				<h2>Login:</h2>
			</div>
			<form method="post" class="w3-container">
				<p>
					<input type="text" name="username" placeholder="E-mail" />
				</p>
				<p>
					<input type="password" name="password" placeholder="Password" />
				</p>
				<p>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="submit" value="Login" />
				</p>

			</form>

		</div>

	</div>
</body>
</html>






