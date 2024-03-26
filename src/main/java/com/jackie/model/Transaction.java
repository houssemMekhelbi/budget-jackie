package com.jackie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private ZonedDateTime date;
	@OneToOne
	private TransactionCategory category;
	private TypeTransaction type;
	@ManyToOne
	@JoinColumn(name = "source_id")
	private Account source;
	@ManyToOne
	@JoinColumn(name = "destination_id")
	private Account destination;
	public Transaction() {}

	public Transaction(Long id, String transactionId, String description, double amount, ZonedDateTime date,
	                   TransactionCategory category, TypeTransaction type, Account source, Account destination) {
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

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public TransactionCategory getCategory() {
		return category;
	}

	public void setCategory(TransactionCategory category) {
		this.category = category;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

	public Account getSource() {
		return source;
	}

	public void setSource(Account source) {
		this.source = source;
	}

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"id=" + id +
				", transactionId='" + transactionId + '\'' +
				", description='" + description + '\'' +
				", amount=" + amount +
				", date=" + date +
				", category=" + category +
				", type=" + type +
				", source=" + source +
				", destination=" + destination +
				'}';
	}
}
