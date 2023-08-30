package com.codewithluck.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbDriverManagerImp implements dbDriverManager {

	public dbDriverManagerImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/job-online";
			String userName = "root";
			String password = "Sandun19680129";
			
			return DriverManager.getConnection(url, userName, password);
		
	}

}
