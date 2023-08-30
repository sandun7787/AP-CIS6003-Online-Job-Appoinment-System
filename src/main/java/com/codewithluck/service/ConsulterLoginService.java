package com.codewithluck.service;

import java.sql.SQLException;

import com.codewithluck.dao.ConsulterLogin;
import com.codewithluck.dao.ConsulterLoginImp;
import com.codewithluck.model.Consulter;

public class ConsulterLoginService {
	
	private static ConsulterLoginService ConsulterLoginServiceObj;
	
	
	private ConsulterLogin getConsulterLoginObj() {
		return new ConsulterLoginImp();
		
	}

	public ConsulterLoginService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized ConsulterLoginService getConsulterLoginService() {
		
		if(ConsulterLoginServiceObj==null) {
			  ConsulterLoginServiceObj=new ConsulterLoginService();
		}
    	return 	ConsulterLoginServiceObj;
	}
	
	
	public Consulter fetchConsulterLogin(String email) throws SQLException, ClassNotFoundException {
		
		return  getConsulterLoginObj().fetchSingleConsulter(email);
	}

}
