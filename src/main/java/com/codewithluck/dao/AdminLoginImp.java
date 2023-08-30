package com.codewithluck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codewithluck.dao.utils.dbDriverManager;
import com.codewithluck.dao.utils.dbDriverManagerFactory;
import com.codewithluck.model.Admin;

public class AdminLoginImp implements AdminLogin {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		dbDriverManagerFactory driverFactory=new dbDriverManagerFactory();
		dbDriverManager driverManager=driverFactory.getDbDriver("MYSQL");
		return driverManager.getConnection();
		
	}

	public AdminLoginImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Admin fetchSingleAdmin(String email) throws SQLException, ClassNotFoundException {
		Connection connection=getConnection();
		String query="SELECT * FROM  admin WHERE email=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1,email);
		
		ResultSet  rs=ps.executeQuery();
		Admin admin=new Admin();
		
		while(rs.next()) {
			admin.setEmail(rs.getString("email"));
			admin.setPassword(rs.getString("password"));
		}
		rs.close();
		connection.close();
		return admin;
	}

}
