package com.codewithluck.dao.utils;

public class dbDriverManagerFactory {

	
	public dbDriverManager getDbDriver(String databaseType) {	
		
		if(databaseType.equals("MYSQL")) {
			return new dbDriverManagerImp();
		}
		
	    return null;
	
	}

}
