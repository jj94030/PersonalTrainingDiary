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
	<div class="w3-sidebar w3-dark-gray w3-bar-block" style="width: 15%">
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

		<img src="resources/img/3.jpg" alt="fitness" style="width: 100%" class="w3-sepia-max"/>

		<div class="w3-container"></div>

		
	</div>
</body>
</html>