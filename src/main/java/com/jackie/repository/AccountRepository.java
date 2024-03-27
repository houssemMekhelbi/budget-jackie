package com.jackie.repository;

import com.jackie.model.Account;
import com.jackie.model.TransactionCategory;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<Account> {
	public Uni<Account> findByAccountId(String id) {
		return find("getAccountId",id).firstResult();
	}
}
