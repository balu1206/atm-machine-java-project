package service;

import dao.AccountDAO;

public class AuthService {
	private AccountDAO accountDAO = new AccountDAO();
	
	public boolean login(String accountNumber, String pin) {
		return accountDAO.validateLogin(accountNumber, pin);
	}
	

}
