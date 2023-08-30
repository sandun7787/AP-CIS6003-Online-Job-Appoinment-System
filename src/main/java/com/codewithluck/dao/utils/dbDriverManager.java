package com.codewithluck.dao.utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface dbDriverManager {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException;

}
