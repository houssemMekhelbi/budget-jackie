package com.jackie.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * DTO for {@link Transaction}
 */
public class TransactionDto {
	private final Long id;
	private final String transactionId;
	private final String description;
	private final double amount;
	private final ZonedDateTime date;
	private final TypeTransaction type;

	private final String category;

	private final String source;
	private final String destination;


	public TransactionDto(Long id, String transactionId, String description, double amount, ZonedDateTime date,
	                      TypeTransaction type, String category, String source, String destination) {
		this.id = id;
		this.transactionId = transactionId;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.type = type;
		this.category = category;
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

	public ZonedDateTime getDate() {
		return date;
	}

	public TypeTransaction getType() {
		return type;
	}

	public String getCategory() {
		return category;
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
				Objects.equals(this.type, entity.type) &&
				Objects.equals(this.category, entity.category) &&
				Objects.equals(this.source, entity.source) &&
				Objects.equals(this.destination, entity.destination);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, transactionId, description, amount, date, type, category, source, destination);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"transactionId = " + transactionId + ", " +
				"description = " + description + ", " +
				"amount = " + amount + ", " +
				"date = " + date + ", " +
				"type = " + type + ", " +
				"category = " + category + ", " +
				"source = " + source + ", " +
				"destination = " + destination +
				")";
	}
}