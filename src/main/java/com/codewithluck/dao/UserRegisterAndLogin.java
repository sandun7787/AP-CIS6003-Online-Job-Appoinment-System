package com.codewithluck.dao;

import java.sql.SQLException;

import com.codewithluck.model.User;

public interface UserRegisterAndLogin {
	public boolean registerUser(User user) throws SQLException, ClassNotFoundException;
	public User fetchSingleUser(String email) throws ClassNotFoundException, SQLException;

}
