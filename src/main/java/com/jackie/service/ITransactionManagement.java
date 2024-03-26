package com.jackie.service;

import com.jackie.model.Transaction;
import com.jackie.model.payload.TransactionRequest;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ITransactionManagement {
	Uni<List<Transaction>> retrieveAllTransactions();

	Uni<Transaction> retrieveTransaction(String transactionId);

	Uni<Transaction> saveTransaction(TransactionRequest transactionRequest);

	Uni<Transaction> updateTransaction(TransactionRequest transaction);

	Uni<Void> deleteTransaction(String transactionId);
}
