package com.codewithluck.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithluck.model.Admin;
import com.codewithluck.service.AdminLoginService;

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message="";
       
   
    public AdminLoginController() {
        super();
        
    }
    
    private AdminLoginService  getAdminLoginService() {
		return AdminLoginService.getAdminLoginService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionType=request.getParameter("actionType");
		if(actionType.equals("adminlogin")) {
			adminLogin(request,response);
		}else if(actionType.equals("adminlogin")) {
			adminLogin(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
public void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			Admin admin=getAdminLoginService().fetchAdminLogin(email);
			if((email.equals(admin.getEmail())&&(password.equals(admin.getPassword())))) {
				message="Admin Login is Successfully Confirmed!";

				request.setAttribute("feedbackmessage",message);
				RequestDispatcher rd=request.getRequestDispatcher("AdminDashBoard.jsp");
				rd.forward(request, response);
				
				
			}else {
				message="Admin Login is  not Successfully Confirmed!";

				request.setAttribute("feedbackmessage",message);
				RequestDispatcher rd=request.getRequestDispatcher("AdmingLogin.jsp");
				rd.forward(request, response);
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}


}
