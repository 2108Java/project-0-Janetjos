package com.revaturee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String URL = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conn;
			
		
		
	}

}
