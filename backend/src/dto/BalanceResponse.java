package dto;

public class BalanceResponse {
	private boolean status;
	private double balance;
	
	public BalanceResponse(boolean status, double balance) {
		this.status= status;
		this.balance = balance;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public double getBalance() {
		return balance;
	}
}
