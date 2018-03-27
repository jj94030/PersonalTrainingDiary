<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form:form method="POST" modelAttribute="client">
		<div>
			<form:input path="name" placeholder="Name" />
			<form:errors path="name"></form:errors>
		</div>
		<br>
		<div>
			<form:input path="surname" placeholder="Surname" />
			<form:errors path="surname"></form:errors>
		</div>
		<br>
		<div>
			<form:input path="phoneNumber" placeholder="PhoneNumber" />
			<form:errors path="phoneNumber"></form:errors>
		</div>
		<br>
		<div>
			<form:input type="email" path="email" placeholder="E-mail" />
			<form:errors path="email"></form:errors>
		</div>
		<br>
		<div>
			<form:select path="gym">
				<option value="">---Select gym---</option>
				<option>Fitness Platinium Bratyslawska</option>
				<option>Fitness Platinium Mogilska</option>
				<option>Fitness Platinium Plaza</option>
				<option>Fitness Platinium Salwator</option>
				<option>Pure Jatomi Fitness Kazimierz</option>
				<option>Pure Jatomi Fitness Angel City</option>
				<option>other</option>
			</form:select>
		</div>
		<br>
		<div>
			<form:select path="goal">
				<option value="">---Select goal---</option>
				<option>masa</option>
				<option>rzezba</option>
				<option>redukcja</option>
				<option>other</option>
			</form:select>
		</div>
		<br>
		<div>
			<input type="submit" />
		</div>
	</form:form>

</body>
</html>