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


	<form:form method="POST" modelAttribute="personalTrainerDTO">
		
		<div>
			<form:input type="email" path="email" placeholder="E-mail" />
			<form:errors path="email"></form:errors>
		</div>
		<br>
		<div>
			<form:password path="password" placeholder="PASSWORD" />
			<form:errors path="password"></form:errors>
		</div>
		<br>
		<div>
			<input type="submit" />
		</div>



	</form:form>


</body>
</html>