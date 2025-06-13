package com.dao.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	private static Connection con;

	public static Connection connect() {
		
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapplication","sabhi","Abhilash@9023");
		
	}
	catch(Exception e) {
		e.printStackTrace();                                          
	}
	return con;
	
	}


	
}
