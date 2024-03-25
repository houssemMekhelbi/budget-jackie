package com.jackie.repository;

import com.jackie.model.Transaction;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionRepository implements PanacheRepository<Transaction> {
	public Uni<Transaction> findByTransactionId(String id) {
		return find("transaction_id",id).firstResult();
	}
}
