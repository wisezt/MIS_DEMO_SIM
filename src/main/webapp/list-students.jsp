
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>

<%@ page import="com.ting.web.jdbc.Student"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!List<Student> students = null;%>


	<%
	this.students = (List<Student>) request.getAttribute("STUDENT_LIST");

	for (Student s : students) {

		out.println(s.toString() + "<br>");

	}
	%>

</body>
</html>