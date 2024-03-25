package com.jackie.model.payload;

public class TransactionRequest {
	private String transactionId;
	private String description;
	private double amount;
	private String date;
	private String category;
	private String type;
	private String source;
	private String destination;

	public TransactionRequest() {
	}

	public TransactionRequest(String transactionId, String description, double amount, String date, String category,
			String type, String source, String destination) {
		this.transactionId = transactionId;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.category = category;
		this.type = type;
		this.source = source;
		this.destination = destination;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}
}
