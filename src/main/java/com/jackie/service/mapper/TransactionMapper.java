package com.jackie.service.mapper;

import com.jackie.model.Transaction;
import com.jackie.model.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Houssem Mekhelbi
 * @Project budget-jackie
 */
@Mapper(componentModel = "jakarta")
public interface TransactionMapper {
    @Mapping(target = "id", ignore = true)
    Transaction transactionRequestToTransaction(TransactionDto transactionRequest);
}
