package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

public class AccountDAO {
	public boolean validateLogin(String accountNumber, String pin) {
		try {
			Connection connection = DBConnection.getConnection();

			String query = "SELECT * FROM accounts " + "WHERE account_number = ? " + "AND pin = ?";

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

	public double getBalance(String accountNumber) {
		try {
			Connection connection = DBConnection.getConnection();

			String query = "SELECT balance FROM accounts " + "Where account_number = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, accountNumber);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getDouble("balance");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean withdrawAmount(String accountNumber, double amount) {
		try {
			Connection connection = DBConnection.getConnection();
			double currentBalance = getBalance(accountNumber);

			if (currentBalance < amount) {
				return false;
			}
			double remainingBalance = currentBalance - amount;

			String query = "UPDATE accounts " + "SET balance = ? " + "WHERE account_number = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setDouble(1, remainingBalance);
			preparedStatement.setString(2, accountNumber);

			int rowsUpdated = preparedStatement.executeUpdate();

			return rowsUpdated > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean depositeAmount(String accountNumber, double amount) {
		try {
			Connection connection = DBConnection.getConnection();

			double currentBalance = getBalance(accountNumber);

			double updatedBalance = currentBalance + amount;

			String query = "UPDATE accounts " + "SET balance = ? " + "WHERE account_number = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setDouble(1, updatedBalance);
			preparedStatement.setString(2, accountNumber);

			int rowsUpdated = preparedStatement.executeUpdate();

			return rowsUpdated > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
