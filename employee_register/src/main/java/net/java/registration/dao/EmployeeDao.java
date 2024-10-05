package net.java.registration.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import net.java.registration.model.*;
public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		
		String query = "INSERT INTO EMPLOYEE(firstname,lastname, username,  password, address,  contact) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=Praveen@07")){
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			
			stmt.setString(1, employee.getFirstname());
			stmt.setString(2, employee.getLastname());
			stmt.setString(3, employee.getUsername());
			stmt.setString(4, employee.getPassword());
			stmt.setString(5, employee.getAddress());
			stmt.setString(6, employee.getContact());
			
			System.out.print(stmt);
			
			result = stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		 
		return result;
	}

}
