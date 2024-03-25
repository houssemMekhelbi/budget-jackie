package com.jackie.service.implimentation;

import com.jackie.model.Transaction;
import com.jackie.model.payload.TransactionRequest;
import com.jackie.repository.TransactionRepository;
import com.jackie.service.ITransactionManagement;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class TransactionManagementImpl implements ITransactionManagement {
	@Inject
	TransactionRepository transactionRepository;
	@Override
	public Uni<List<Transaction>> retrieveAllTransactions() {
		return transactionRepository
				.listAll()
				.onItem()
				.ifNull()
				.failWith(() -> new RuntimeException("No transactions found"))
				.onFailure()
				.recoverWithUni(e -> Uni.createFrom().failure(new RuntimeException("Could not retrieve transactions")))
				.onItem()
				.transformToUni(list -> list.isEmpty() ? Uni.createFrom()
				                                            .failure(new RuntimeException("No transactions found")) : Uni.createFrom().item(list));

	}

	@Override
	public Uni<Transaction> retrieveTransaction(String transactionId) {
		return transactionRepository.findByTransactionId(transactionId)
		                            .onItem()
		                            .ifNull()
		                            .failWith(() -> new RuntimeException("No transaction found with id : "
				                                                                 + transactionId))
		                            .onFailure()
		                            .recoverWithUni(error -> Uni.createFrom()
		                                                        .failure(new RuntimeException("Error retrieving Blog")));
	}

	@Override
	public Uni<Transaction> saveTransaction(TransactionRequest transactionRequest) {


		return null;
	}

	@Override
	public Uni<Transaction> updateTransaction(Transaction transaction) {
		return null;
	}

	@Override
	public Uni<Void> deleteTransaction(String transactionId) {
		return null;
	}
}
