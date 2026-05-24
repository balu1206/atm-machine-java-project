package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

public class AccountDAO {
	public boolean validateLogin(
			String accountNumber,
			String pin
			) {
		try {
			Connection connection = DBConnection.getConnection();
			
			String query = "SELECT * FROM accounts " + "WHERE account_number = ? "+"AND pin = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, accountNumber);
			
			preparedStatement.setString(2, pin);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			return resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
