package com.ting.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
	
	private StudentDbUtil studentDbUtil;

	@Override
	public void init() throws ServletException {
		studentDbUtil = new StudentDbUtil(dataSource);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String firstName = request.getParameter("firstName");

		String lastName = request.getParameter("lastName");

		String email = request.getParameter("email");
		
		Student student = new Student(0, firstName, lastName, email);
		
		System.out.println(student.toString());
		
		studentDbUtil.addSutdent(student);
		
		response.sendRedirect("StudentControllerServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
