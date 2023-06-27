package com.ting.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
	
	private StudentDbUtil studentDbUtil;

	@Override
	public void init() throws ServletException {
		studentDbUtil = new StudentDbUtil(dataSource);
	}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<Student> students = null;

		students = studentDbUtil.getStudents();

		req.setAttribute("STUDENT_LIST", students);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list-students.jsp"); 
		dispatcher.forward(req, res);

	}
	

}
