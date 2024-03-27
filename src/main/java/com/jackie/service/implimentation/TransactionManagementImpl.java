package com.jackie.service.implimentation;

import com.jackie.model.Account;
import com.jackie.model.Transaction;
import com.jackie.model.TransactionCategory;
import com.jackie.model.TransactionDto;
import com.jackie.repository.AccountRepository;
import com.jackie.repository.CategoryRepository;
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
	AccountRepository accountRepository;
	@Inject
	CategoryRepository categoryRepository;
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
										.failure(new RuntimeException("No transactions found")) : Uni.createFrom().item(
										list));

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
		                                                        .failure(new RuntimeException(
				                                                        "Error retrieving transaction")));
	}

	@Override
	@Transactional
	public Uni<Transaction> saveTransaction(TransactionDto transactionRequest) {
		// Save transaction
		Transaction transaction = transactionMapper.toEntity(transactionRequest);

		// Retrieve debit account from the database
		Uni<Account> debitAccountUni = accountRepository.findByAccountId(transactionRequest.getDebtor())
		                                                .onFailure().recoverWithItem(error -> {
					//log.error("Error retrieving debit account with ID {}", transactionRequest.getDebtor(), error);
					throw new RuntimeException("Error retrieving debit account");
				});

		// Retrieve credit account from the database
		Uni<Account> creditAccountUni = accountRepository.findByAccountId(transactionRequest.getCreditor())
		                                                 .onFailure().recoverWithItem(error -> {
					//log.error("Error retrieving credit account with ID {}", transactionRequest.getCreditor(), error);
					throw new RuntimeException("Error retrieving credit account");
				});

		// Retrieve category from the database
		return Uni.combine().all().unis(debitAccountUni, creditAccountUni,
		                                categoryRepository.findByCategoryId(transactionRequest.getCategory()))
		          .asTuple()
		          .onItem().ifNotNull().transformToUni(tuple -> {
					Account debtor = tuple.getItem1();
					Account creditor = tuple.getItem2();
					TransactionCategory category = tuple.getItem3();

					if (debtor == null || creditor == null) {
						throw new RuntimeException("Debit or credit account not found");
					}

					transaction.setDebtor(debtor);
					transaction.setCreditor(creditor);
					transaction.setCategory(category);

					return transactionRepository.persist(transaction)
					                            .onFailure().recoverWithUni(error ->
							                                                        Uni.createFrom().failure(
									                                                        new RuntimeException("Error saving transaction")));
				})
		          .onItem().ifNull().failWith(new RuntimeException("Category not found"));
	}



	@Override
	@Transactional
	public Uni<Transaction> updateTransaction(TransactionDto transaction) {
		Uni<Transaction> transactionUni = transactionRepository.findByTransactionId(transaction.getTransactionId());
		return transactionUni
				.onItem()
				.ifNull()
				.failWith(
						() -> new RuntimeException("No transaction found with id : " + transaction.getTransactionId()))
				.onFailure()
				.recoverWithUni(error -> Uni
						.createFrom()
						.failure(new RuntimeException("Error updating transaction")))
				.onItem()
				.transform(entity -> {
					entity.setTransactionId(transaction.getTransactionId());
					entity = transactionMapper.toEntity(transaction);
					return entity;
				});

	}


	@Override
	public Uni<Void> deleteTransaction(String transactionId) {
		return null;
	}
}
