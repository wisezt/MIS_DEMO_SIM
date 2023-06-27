<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>JSP University</h2>
		</div>
	</div>

	<div id="container">

		<h3>Add Student</h3>


		<form action="AddStudent">
			<table>
				<tbody>
					<tr>
						<td><lable>First Name:</lable></td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td><lable>Last Name:</lable></td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td><lable>Email:</lable></td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td><lable></lable></td>
						<td><input type="Submit" value="Save" class="save"></td>
					</tr>
				</tbody>
			</table>
	
		</form>
	</div>

	<br>




	<br>
	<form action="StudentControllerServlet">
		<input type="Submit" value="Back to list">
	</form>

</body>
</html>