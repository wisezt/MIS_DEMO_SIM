package com.ting.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		// Step 1: Set  up the printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		try {
		// Step 2: Get a connection to the database
			myConn = dataSource.getConnection();
			
		// Step 3: Create a SQL statements
			String sql = "select * from student";
			myStmt = myConn.createStatement();
			
		// Step 4: Execute SQL query
			myRs = myStmt.executeQuery(sql);
		
		// Setp 5: Process the result set
			while (myRs.next()) {
				String email = myRs.getString("email");
				out.println(email);
			}
			
			myConn.close();
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
