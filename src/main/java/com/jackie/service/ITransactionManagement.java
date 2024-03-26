package com.jackie.service;

import com.jackie.model.Transaction;
import com.jackie.model.TransactionDto;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ITransactionManagement {
	Uni<List<Transaction>> retrieveAllTransactions();

	Uni<Transaction> retrieveTransaction(String transactionId);

	Uni<Transaction> saveTransaction(TransactionDto transactionRequest);

	Uni<Transaction> updateTransaction(TransactionDto transaction);

	Uni<Void> deleteTransaction(String transactionId);
}
