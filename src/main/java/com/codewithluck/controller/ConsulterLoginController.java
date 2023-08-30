package com.codewithluck.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithluck.model.Consulter;
import com.codewithluck.service.ConsulterLoginService;

/**
 * Servlet implementation class ConsulterLoginController
 */
public class ConsulterLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message="";
    
       
   
    public ConsulterLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private ConsulterLoginService  getConsulterLoginService() {
		return ConsulterLoginService.getConsulterLoginService();
    }
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionType=request.getParameter("actionType");
		if(actionType.equals("login")) {
			ConsulterLogin(request,response);
		}else if(actionType.equals("Consulterlogin")) {
			ConsulterLogin(request,response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	 public void ConsulterLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			try {
				Consulter  Consulter=getConsulterLoginService().fetchConsulterLogin(email);
				if((email.equals(Consulter.getEmail())&&(password.equals(Consulter.getPassword())))) {
					message="Consulter Login is Successfully Confirmed!";

					request.setAttribute("feedbackmessage",message);
					RequestDispatcher rd=request.getRequestDispatcher("dashboard/ConsulterDashboard.jsp");
					rd.forward(request, response);
					
					
				}else {
					message="Consulter Login is  not Successfully Confirmed!";

					request.setAttribute("feedbackmessage",message);
					RequestDispatcher rd=request.getRequestDispatcher("AdminDashBoard.jsp");
					rd.forward(request, response);
					
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
	 }
}


