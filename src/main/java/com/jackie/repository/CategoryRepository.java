package com.jackie.repository;

import com.jackie.model.TransactionCategory;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<TransactionCategory> {
	public Uni<TransactionCategory> findByCategoryId(String id) {
		return find("categoryId",id).firstResult();
	}
}
