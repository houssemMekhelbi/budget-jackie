package com.jackie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "b_accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String accountId;
	private String accountName;
	private BigDecimal balance;
	private String accountType;
	private String currency;
	private double interestRate;
	private ZonedDateTime openingDate;
	private String owner;
	@OneToMany
	private List<Transaction> transactions;
	private String accountStatus;
	private BigDecimal overdraftLimit;

	public Account() {
	}

	public Account(Long id, String accountId, String accountName, BigDecimal balance, String accountType,
	               String currency,
	               double interestRate, ZonedDateTime openingDate, String owner, List<Transaction> transactions,
	               String accountStatus, BigDecimal overdraftLimit) {
		this.id = id;
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.accountType = accountType;
		this.currency = currency;
		this.interestRate = interestRate;
		this.openingDate = openingDate;
		this.owner = owner;
		this.transactions = transactions;
		this.accountStatus = accountStatus;
		this.overdraftLimit = overdraftLimit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public ZonedDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(ZonedDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public BigDecimal getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(BigDecimal overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return Objects.equals(id, account.id) && Objects.equals(accountId, account.accountId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, accountId);
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", accountId='" + accountId + '\'' +
				", accountName='" + accountName + '\'' +
				", balance=" + balance +
				", accountType='" + accountType + '\'' +
				", currency='" + currency + '\'' +
				", interestRate=" + interestRate +
				", openingDate=" + openingDate +
				", owner='" + owner + '\'' +
				", transactions=" + transactions +
				", accountStatus='" + accountStatus + '\'' +
				", overdraftLimit=" + overdraftLimit +
				'}';
	}
}
