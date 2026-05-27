package service;

import dao.AccountDAO;

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

}
