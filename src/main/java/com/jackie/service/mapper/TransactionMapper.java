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
    @Mapping(target = "category",  ignore = true)
    @Mapping(target = "debtor",  ignore = true)
    @Mapping(target = "creditor",  ignore = true)
    Transaction toEntity(TransactionDto transactionRequest);
    @Mapping(target = "category",  ignore = true)
    @Mapping(target = "debtor",  ignore = true)
    @Mapping(target = "creditor",  ignore = true)
    TransactionDto toDto(Transaction transaction);

}
