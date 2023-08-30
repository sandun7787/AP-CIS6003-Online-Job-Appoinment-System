package com.codewithluck.service;

import java.sql.SQLException;

import com.codewithluck.dao.AdminLogin;
import com.codewithluck.dao.AdminLoginImp;
import com.codewithluck.model.Admin;

public class AdminLoginService {
	
	private static AdminLoginService adminLoginServiceObj;
	
	private AdminLogin getAdminLoginObj() {
		return new AdminLoginImp();
	}
	

	public AdminLoginService() {
		// TODO Auto-generated constructor stub
	}
	
public static synchronized AdminLoginService getAdminLoginService() {
		
		if(adminLoginServiceObj==null) {
			  adminLoginServiceObj=new AdminLoginService();
		}
    	return 	adminLoginServiceObj;
	}
	
	
	public Admin fetchAdminLogin(String email) throws SQLException, ClassNotFoundException {
		
		return  getAdminLoginObj().fetchSingleAdmin(email);
	}
	
	
	

}
