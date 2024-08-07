package net.java.registration.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import net.java.registration.model.*;
public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		
		String query = "INSERT INTO EMPLOYEE(id, firstname,lastname, username,  password, address,  contact) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=Praveen@07")){
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, 1);
			stmt.setString(2, employee.getFirstname());
			stmt.setString(3, employee.getLastname());
			stmt.setString(4, employee.getUsername());
			stmt.setString(5, employee.getPassword());
			stmt.setString(6, employee.getAddress());
			stmt.setString(7, employee.getContact());
			
			System.out.print(stmt);
			
			result = stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		 
		return result;
	}

}
