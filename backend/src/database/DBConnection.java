package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/atm_machine";
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root123";
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			System.out.println("Database Connected Successfully");
			
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
