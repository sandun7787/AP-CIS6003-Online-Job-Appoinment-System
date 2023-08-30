package com.codewithluck.dao;

import java.sql.SQLException;

import com.codewithluck.model.Consulter;

public interface ConsulterLogin {
	
	public Consulter fetchSingleConsulter(String email)throws SQLException, ClassNotFoundException;

}
