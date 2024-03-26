package com.jackie.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link Account}
 */
public class AccountDto implements Serializable {
	private final String accountId;
	private final String accountName;
	private final BigDecimal balance;
	private final String accountType;
	private final String currency;
	private final double interestRate;
	private final ZonedDateTime openingDate;
	private final String owner;
	private final List<TransactionDto> transactions;
	private final String accountStatus;
	private final BigDecimal overdraftLimit;
	private final List<List<String>> associatedGoals;

	public AccountDto(String accountId, String accountName, BigDecimal balance, String accountType, String currency,
	                  double interestRate, ZonedDateTime openingDate, String owner, List<TransactionDto> transactions,
	                  String accountStatus, BigDecimal overdraftLimit, List<List<String>> associatedGoals) {
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
		this.associatedGoals = associatedGoals;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getCurrency() {
		return currency;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public ZonedDateTime getOpeningDate() {
		return openingDate;
	}

	public String getOwner() {
		return owner;
	}

	public List<TransactionDto> getTransactions() {
		return transactions;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public BigDecimal getOverdraftLimit() {
		return overdraftLimit;
	}

	public List<List<String>> getAssociatedGoals() {
		return associatedGoals;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AccountDto entity = (AccountDto) o;
		return Objects.equals(this.accountId, entity.accountId) &&
				Objects.equals(this.accountName, entity.accountName) &&
				Objects.equals(this.balance, entity.balance) &&
				Objects.equals(this.accountType, entity.accountType) &&
				Objects.equals(this.currency, entity.currency) &&
				Objects.equals(this.interestRate, entity.interestRate) &&
				Objects.equals(this.openingDate, entity.openingDate) &&
				Objects.equals(this.owner, entity.owner) &&
				Objects.equals(this.transactions, entity.transactions) &&
				Objects.equals(this.accountStatus, entity.accountStatus) &&
				Objects.equals(this.overdraftLimit, entity.overdraftLimit) &&
				Objects.equals(this.associatedGoals, entity.associatedGoals);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, accountName, balance, accountType, currency, interestRate, openingDate, owner,
		                    transactions, accountStatus, overdraftLimit, associatedGoals);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"accountId = " + accountId + ", " +
				"accountName = " + accountName + ", " +
				"balance = " + balance + ", " +
				"accountType = " + accountType + ", " +
				"currency = " + currency + ", " +
				"interestRate = " + interestRate + ", " +
				"openingDate = " + openingDate + ", " +
				"owner = " + owner + ", " +
				"transactions = " + transactions + ", " +
				"accountStatus = " + accountStatus + ", " +
				"overdraftLimit = " + overdraftLimit + ", " +
				"associatedGoals = " + associatedGoals + ")";
	}
}