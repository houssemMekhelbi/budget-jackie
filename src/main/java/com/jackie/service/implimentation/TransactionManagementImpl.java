package com.jackie.service.implimentation;

import com.jackie.model.Transaction;
import com.jackie.model.payload.TransactionRequest;
import com.jackie.repository.TransactionRepository;
import com.jackie.service.ITransactionManagement;
import com.jackie.service.mapper.TransactionMapper;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TransactionManagementImpl implements ITransactionManagement {
	@Inject
	TransactionRepository transactionRepository;
	@Inject
	TransactionMapper transactionMapper;
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
				.transformToUni(
						list ->
								list.isEmpty() ? Uni
										.createFrom()
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
		                                                        .failure(new RuntimeException("Error retrieving transaction")));
	}

	@Override
	@Transactional
	public Uni<Transaction> saveTransaction(TransactionRequest transactionRequest) {
		Transaction transaction = transactionMapper.transactionRequestToTransaction(transactionRequest);
		return transactionRepository
				.persist(transaction)
				.onFailure()
				.recoverWithUni(error -> Uni
						.createFrom()
						.failure(new RuntimeException("Error saving transaction")));
	}

	@Override
	@Transactional
	public Uni<Transaction> updateTransaction(TransactionRequest transaction) {
		Uni<Transaction> transactionUni = transactionRepository.findByTransactionId(transaction.getTransactionId());
		return transactionUni
				.onItem()
				.ifNull()
				.failWith(() -> new RuntimeException("No transaction found with id : " + transaction.getTransactionId()))
				.onFailure()
				.recoverWithUni(error -> Uni
						.createFrom()
						.failure(new RuntimeException("Error updating transaction")))
				.onItem()
				.transform(entity -> {
					entity.setTransactionId(transaction.getTransactionId());
					entity.setDescription(transaction.getDescription());
					entity.setAmount(transaction.getAmount());
					entity.setDate(transaction.getDate());
					entity.setCategory(transaction.getCategory());
					entity.setType(transaction.getType());
					entity.setSource(transaction.getSource());
					entity.setDestination(transaction.getDestination());
					return entity;
				});

	}

	@Override
	public Uni<Void> deleteTransaction(String transactionId) {
		return null;
	}
}
