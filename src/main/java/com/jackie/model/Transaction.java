package com.jackie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
@Entity
@Table(name = "b_transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "transaction_id")
	private String transactionId;
	private String description;
	private double amount;
	private String date;
	private String category;
	private String type;
	private String source;
	private String destination;
	public Transaction() {}

	public Transaction(Long id,
	                   String transactionId,
	                   String description,
	                   double amount,
	                   String date,
	                   String category,
	                   String type,
	                   String source,
	                   String destination) {
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
	public void setId(Long id) {
		this.id = id;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return Objects.equals(id, that.id) && Objects.equals(transactionId, that.transactionId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, transactionId);
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"id=" + id +
				", transactionId='" + transactionId + '\'' +
				", description='" + description + '\'' +
				", amount=" + amount +
				", date='" + date + '\'' +
				", category='" + category + '\'' +
				", type='" + type + '\'' +
				", source='" + source + '\'' +
				", destination='" + destination + '\'' +
				'}';
	}
}
