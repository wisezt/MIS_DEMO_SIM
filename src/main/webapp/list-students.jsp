<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ting.web.jdbc.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<%
	List<Student> students = (List<Student>) request.getAttribute("STUDENT_LIST");
	%>

	<div id="wrapper">
		<div id="header">
			<h2>Student List</h2>
		</div>
	</div>

	<br>
	
	<form action="add-student.jsp">
		<input type="Submit" value="Add Student">	
	</form>
	

	<div id="container">
		<div id="content">

			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
						
					</tr>
				<thead>
				<tbody>
					<%
					for (Student student : students) {
					%>
					<tr>
						<td><%=student.getId()%></td>
						<td><%=student.getFirstName()%></td>
						<td><%=student.getLastName()%></td>
						<td><%=student.getEmail()%></td>
						<td><a href="update-student.jsp?id=<%=student.getId()%>&firstName=<%=student.getFirstName()%>&lastName=<%=student.getLastName()%>&email=<%=student.getEmail()%>">Update</a>/<a href="DeleteStudent?id=<%=student.getId()%>">Delete</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

		</div>
	</div>


</body>
</html>