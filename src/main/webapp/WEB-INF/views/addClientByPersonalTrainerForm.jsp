<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PersonalTrainingDiary</title>

<%@ include file="jspf/head_config.jspf"%>

</head>
<body>
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
	</div>

	<!-- Page Content -->
	<div style="margin-left: 15%">

		<div class="w3-container w3-teal">
			<h1>Personal Training Diary</h1>
		</div>
<br>
		<div class="w3-container">

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
						<option>mass</option>
						<option>sculpting the body</option>
						<option>weight reduction</option>
						<option>other</option>
					</form:select>
				</div>
				<br>
				<div>
					<form:select path="startTraining">
						<option value="">---Select start hour---</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
						<option>17</option>
						<option>18</option>
						<option>19</option>
						<option>20</option>
					</form:select>
					<form:select path="endTraining">
						<option value="">---Select end training---</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
						<option>17</option>
						<option>18</option>
						<option>19</option>
						<option>20</option>
					</form:select>
				</div>
				<br>
				<div>
					<form:select path="daysOfTraining" items="${daysOfWeek}"
						multiple="true" />
				</div>
				<br>
				<div>
					<input type="submit" />
				</div>
			</form:form>
		</div>
		<br><br><br>
		<%@ include file="jspf/footer.jspf"%>
	</div>
</body>
</html>