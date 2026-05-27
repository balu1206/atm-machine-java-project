package service;

import java.util.List;

import dao.AccountDAO;
import dto.TransactionRecord;

public class AuthService {
	private AccountDAO accountDAO = new AccountDAO();
	
	public boolean login(String accountNumber, String pin) {
		return accountDAO.validateLogin(accountNumber, pin);
	}
	
	public double getBalance(String accountNumber) {
		return accountDAO.getBalance(accountNumber);
	}
	
	public boolean withdraw(String accountNumber, double amount) {
		return accountDAO.withdrawAmount(accountNumber, amount);
	}
	
	public boolean deposite(String accountNumber, double amount) {
		return accountDAO.depositeAmount(accountNumber, amount);
	}
	
	public List<TransactionRecord> getTransactions(String accountNumber){
		return accountDAO.getTransactions(accountNumber);
	}

}
