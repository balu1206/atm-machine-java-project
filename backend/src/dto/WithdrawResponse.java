package dto;

public class WithdrawResponse {
	private boolean status;
	private String message;
	private double remainingBalance;
	
	public WithdrawResponse(boolean status, String message, double remainingBalance) {
		super();
		this.status = status;
		this.message = message;
		this.remainingBalance = remainingBalance;
	}

	public String getMessage() {
		return message;
	}
	public boolean isStatus() {
		return status;
	}
	public double getRemainingBalance() {
		return remainingBalance;
	}
}
