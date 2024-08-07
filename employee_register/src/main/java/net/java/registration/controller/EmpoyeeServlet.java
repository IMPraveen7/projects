package net.java.registration.controller;
import net.java.registration.dao.*;
import net.java.registration.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class EmpoyeeServlet
 */
@WebServlet("/register")
public class EmpoyeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao employeeDao = new EmployeeDao(); 
    /**
     * Default constructor. 
     */
    public EmpoyeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/EmployeeRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String  password = request.getParameter("password");
		String address = request.getParameter("address");
		String  contact = request.getParameter("contact");
	
		Employee employee = new Employee();
		
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		
		try {
			employeeDao.registerEmployee(employee);
		}
		catch(ClassNotFoundException cn) {
			cn.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/RegisterSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
