package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import dto.TransactionRecord;

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

			if( rowsUpdated > 0) {
				saveTransaction(accountNumber, "WITHDRAW", amount);
				return true;
			}
			
			return false;
			
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

			if( rowsUpdated > 0) {
				saveTransaction(accountNumber, "DEPOSIT", amount);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public void saveTransaction( String accountNumber, String type, double amount) {
		try{
			Connection connection = DBConnection.getConnection();
			
			String query = "INSERT INTO transactions " + "(account_number, type, amount) " + "VALUES (? , ? ,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, accountNumber);
			preparedStatement.setString(2, type);
			preparedStatement.setDouble(3, amount);
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TransactionRecord> getTransactions(String accountNumber){
		
		List<TransactionRecord> transactions = new ArrayList<>();
		
		try {
			Connection connection = DBConnection.getConnection();
			
			String query = "SELECT * FROM transactions "+
							"WHERE account_number = ?"+
							"ORDER BY created_at DESC";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, accountNumber);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				TransactionRecord transaction = new TransactionRecord(resultSet.getString("type"), resultSet.getDouble("amount"), resultSet.getString("created_at"));
				
				transactions.add(transaction);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactions;
	}

}
