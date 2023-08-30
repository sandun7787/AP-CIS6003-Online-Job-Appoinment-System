package com.codewithluck.service;

import java.sql.SQLException;

import com.codewithluck.dao.UserRegisterAndLogin;
import com.codewithluck.dao.UserRegisterAndLoginImp;
import com.codewithluck.model.User;



public class UserRegisterAndLoginService {
	
private static UserRegisterAndLoginService UserRegisterAndLoginServiceObj;

private UserRegisterAndLogin getUserRegisterAndLoginDao() {
	return new UserRegisterAndLoginImp();
	
}

private UserRegisterAndLoginService () {
	
	// TODO Auto-generated constructor stub
}

public static synchronized UserRegisterAndLoginService getUserRegisterAndLoginServiceObj() {
	if(UserRegisterAndLoginServiceObj==null) {
		UserRegisterAndLoginServiceObj=new UserRegisterAndLoginService();
	}
	return UserRegisterAndLoginServiceObj;
	
}
	
	public boolean addUser(User user) throws SQLException, ClassNotFoundException {
		return getUserRegisterAndLoginDao().registerUser(user);
		
	}
	public User fetchSingleUser(String email) throws ClassNotFoundException, SQLException {
		return getUserRegisterAndLoginDao().fetchSingleUser(email);
	}
	
}
