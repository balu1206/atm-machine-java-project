package dto;

public class TransactionRequest {
	private String accountNumber;

	public TransactionRequest(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	
}
