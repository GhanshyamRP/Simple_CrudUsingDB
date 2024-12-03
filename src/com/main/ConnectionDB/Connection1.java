package com.main.ConnectionDB;

import java.sql.*;


public class Connection1 {
	
	private Connection conn;
	
	public Connection getConnection()  {
		
		try {
			// load class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//register to db
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo","root","krunal966230");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(conn!=null) {
			System.out.println("Connected to db");
		}
		return conn;
	}

	
	public void destroyConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
