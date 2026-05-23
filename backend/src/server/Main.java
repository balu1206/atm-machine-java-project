package server;

import java.sql.Connection;

import database.DBConnection;

public class Main {

	public static void main(String[] args) {

		Connection connection = DBConnection.getConnection();

		if (connection != null) {
			System.out.println("ATM Machine Started");
		} else {
			System.out.println("DataBase Connection Failed");
		}
	}

}
