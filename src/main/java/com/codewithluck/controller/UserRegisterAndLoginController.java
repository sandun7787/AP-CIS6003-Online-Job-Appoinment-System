package com.codewithluck.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithluck.model.User;
import com.codewithluck.service.UserRegisterAndLoginService;

/**
 * Servlet implementation class UserRegisterAndLoginController
 */
public class UserRegisterAndLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserRegisterAndLoginService getUserRegisterAndLoginService() {
		return UserRegisterAndLoginService.getUserRegisterAndLoginServiceObj();
	}
	
	 String message="";   
		
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterAndLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionType=request.getParameter("actionType");
		if(actionType.equals("login")) {
			  fetchUser(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionType=request.getParameter("actionType");
		
		if(actionType.equals("add")) {
			registerUser(request,response);
		}
	}
	
	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User User=new User();
		String firstName=request.getParameter("firstname");
	    String lastName=request.getParameter("lastname");
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    String confirmPassword=request.getParameter("confirmpassword");
	    if(password.equals(confirmPassword)) {
		User.setFirstName(firstName);
		User.setLastName(lastName);
		User.setEmail(email);
	    User.setPassword(password);
		User.setConfirmPassword(confirmPassword);
	    
	    try {
			if(getUserRegisterAndLoginService().addUser(User)) {
				message="JOb Seeker has been registered successfully";
			}else {
				message="Job Seeker hasn't been registered successfully";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			   message=e.getMessage();
		}
	    request.setAttribute("feedbackmessage",message);
	    RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
	    rd.forward(request, response);
		
		
		
	}else {
		message="your password and confirm password is not matching";
		request.setAttribute("feedbackmessage",message);
		RequestDispatcher rd=request.getRequestDispatcher("UserRegister.jsp");
		rd.forward(request, response);
	}

	}
	
	    private void fetchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			try {
				User user=getUserRegisterAndLoginService().fetchSingleUser(email);
				if(email.equals(user.getEmail())&&(password.equals(user.getPassword()))){
					message="Login is successfully confirmed";
					request.setAttribute("feedbackmessage",message);
					RequestDispatcher rd=request.getRequestDispatcher("UserDashBoard.jsp");
					rd.forward(request, response);
					
				}else {
					message="Login is not successfully confirmed";
					message="Login is not successfully confirmed";
					request.setAttribute("feedbackmessage",message);
					RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				   message=e.getMessage();
			}
			
			
		

	}
	
	
	
}
