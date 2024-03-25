package com.jackie.service.mapper;

import com.jackie.model.Transaction;
import com.jackie.model.payload.TransactionRequest;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Houssem Mekhelbi
 * @Project budget-jackie
 */
@Mapper(componentModel = "jakarta")
public interface TransactionMapper {
    @Mapping(target = "id", ignore = true)
    Transaction transactionRequestToTransaction(TransactionRequest transactionRequest);

    TransactionRequest transactionToTransactionRequest(Transaction transaction);

}
