package com.ting.web.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;

	}

	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		// Step 1: Get a connection to the database
		try {
			myConn = dataSource.getConnection();

			// Step 2: Create a SQL statements
			String sql = "select * from student";
			myStmt = myConn.createStatement();

			// Step 3: Execute SQL query
			myRs = myStmt.executeQuery(sql);

			// step 4: Process the result set
			while (myRs.next()) {
				// int id = Integer.parseInt(myRs.getString("id"));
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				Student student = new Student(id, firstName, lastName, email);
				System.out.println("DAO" + student.toString());
				students.add(student);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// step 5: close JDBC objects
			close(myStmt, myRs, myConn);
		}
		return students;
	}

	private void close(Statement myStmt, ResultSet myRs, Connection myConn) {

		try {

			if (myStmt != null) {
				myStmt.close();
			}

			if (myRs != null) {
				myRs.close();
			}

			if (myConn != null) {
				myConn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSutdent(Student student) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		// Step 1: Get a connection to the database
		try {
			myConn = dataSource.getConnection();

			// Step 2: Create a SQL statements
			String sql = "insert into student(first_name, last_name, email ) value(?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmail());
			
			
			// Step 3: Execute SQL query
			myStmt.execute();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// step 5: close JDBC objects
			close(myStmt, myRs, myConn);
		}
		
	}

	public void updateStudent(Student student) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		// Step 1: Get a connection to the database
		try {
			myConn = dataSource.getConnection();

			// Step 2: Create a SQL statements
			String sql = "update student set first_name=?, last_name=?, email=? where id=?";
			
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmail());
			myStmt.setInt(4, student.getId());
			
			
			// Step 3: Execute SQL query
			myStmt.execute();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// step 5: close JDBC objects
			close(myStmt, myRs, myConn);
		}
		
	}

	public void deleteStudent(int id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		// Step 1: Get a connection to the database
		try {
			myConn = dataSource.getConnection();

			// Step 2: Create a SQL statements
			String sql = "delete from student where id=?";
			
			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, id);			
			
			// Step 3: Execute SQL query
			myStmt.execute();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// step 5: close JDBC objects
			close(myStmt, myRs, myConn);
		}
		
	}

}
