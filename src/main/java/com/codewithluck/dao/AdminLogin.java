package com.codewithluck.dao;

import java.sql.SQLException;

import com.codewithluck.model.Admin;

public interface AdminLogin {
	
	public Admin fetchSingleAdmin(String email)throws SQLException, ClassNotFoundException;

}
