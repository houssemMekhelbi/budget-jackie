package com.jackie.resource;

import com.jackie.model.Transaction;
import com.jackie.model.payload.TransactionRequest;
import com.jackie.service.ITransactionManagement;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.eclipse.microprofile.openapi.annotations.enums.SchemaType.ARRAY;

@Path("transaction")
@Produces("application/json")
@Tag(name = "Transactions")
@WithTransaction
public class TransactionResource {
	@Inject
	ITransactionManagement transactionManagement;

	@GET
	@Operation(summary = "Returns all the transactions")
	@APIResponse(
			responseCode = "200",
			description = "Gets all the transactions, or error if none",
			content = @Content(
					mediaType = APPLICATION_JSON,
					schema = @Schema(implementation = Transaction.class, type = ARRAY)
			)
	)
	public Uni<List<Transaction>> getTransactions() {
		return transactionManagement.retrieveAllTransactions();
	}
	@GET
	@Path("{transactionId}")
	@Operation(summary = "Returns a transaction by ID")
	@APIResponse(
			responseCode = "200",
            description = "Gets a transaction, or error if none",
            content = @Content(
                    mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Transaction.class)
            )
	)
	public Uni<Transaction> getTransaction(String transactionId) {
        return transactionManagement.retrieveTransaction(transactionId);
    }

	@POST
	@Operation(summary = "Saves a transaction")
    @APIResponse(
            responseCode = "200",
            description = "Saves a transaction, or error if none",
            content = @Content(
					mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = TransactionRequest.class)
			)
	)
	public Uni<Transaction> saveTransaction(TransactionRequest transactionRequest){
        return transactionManagement.saveTransaction(transactionRequest);
    }
//		return transactionManagement
//				.retrieveAllTransactions();
}
