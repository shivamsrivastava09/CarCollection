package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionClass {
	public static Connection getCarConnection() {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/cars";
			String username="root";
			String password="Root09**";
			Connection connection=DriverManager.getConnection(url,username,password);
			return connection;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
