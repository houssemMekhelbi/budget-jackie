package com.jackie.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;
import java.util.UUID;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {
	private static final Logger logger = LoggerFactory.getLogger(NotFoundException.class);

	@Override
	public Response toResponse(Throwable e) {
		String errorId = UUID.randomUUID().toString();
		logger.error("errorId[{}]", errorId, e);
		System.out.println(e.getMessage());
		String defaultErrorMessage = e.getMessage();
		ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage(defaultErrorMessage);
		ErrorResponse errorResponse = new ErrorResponse(errorId, errorMessage);
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
	}

}