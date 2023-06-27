<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Add Student</h2>
		</div>
	</div>

	<br>

	<form action="AddStudent">
		First Name: <input type="text" name="firstName"/><br>
		
		Last Name: <input type="text" name="lastName"/><br>
		
		Email: <input type="text" name="email"/><br>
	
		<input type="Submit" value="Save">
	</form>


<br>
<br>
	<form action="StudentControllerServlet">
		<input type="Submit" value="Back to list">
	</form>
	
</body>
</html>