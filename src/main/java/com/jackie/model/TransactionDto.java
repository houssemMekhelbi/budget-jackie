package com.jackie.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Transaction}
 */
public class TransactionDto implements Serializable {
	private final Long id;
	private final String transactionId;
	private final String description;
	private final double amount;
	private final String date;
	private final String category;
	private final String type;
	private final String source;
	private final String destination;

	public TransactionDto(Long id, String transactionId, String description, double amount, String date,
	                      String category,
	                      String type, String source, String destination) {
		this.id = id;
		this.transactionId = transactionId;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.category = category;
		this.type = type;
		this.source = source;
		this.destination = destination;
	}

	public Long getId() {
		return id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TransactionDto entity = (TransactionDto) o;
		return Objects.equals(this.id, entity.id) &&
				Objects.equals(this.transactionId, entity.transactionId) &&
				Objects.equals(this.description, entity.description) &&
				Objects.equals(this.amount, entity.amount) &&
				Objects.equals(this.date, entity.date) &&
				Objects.equals(this.category, entity.category) &&
				Objects.equals(this.type, entity.type) &&
				Objects.equals(this.source, entity.source) &&
				Objects.equals(this.destination, entity.destination);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, transactionId, description, amount, date, category, type, source, destination);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"transactionId = " + transactionId + ", " +
				"description = " + description + ", " +
				"amount = " + amount + ", " +
				"date = " + date + ", " +
				"category = " + category + ", " +
				"type = " + type + ", " +
				"source = " + source + ", " +
				"destination = " + destination + ")";
	}
}