package dto;

public class TransactionRecord {
	
	private String type;
	private double amount;
	private String createdAt;
	public TransactionRecord(String type, double amount, String createdAt) {
		super();
		this.type = type;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	public String getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	
	
}
