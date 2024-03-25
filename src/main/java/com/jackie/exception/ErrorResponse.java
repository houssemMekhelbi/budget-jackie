package com.jackie.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

public class ErrorResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorId;
	private List<ErrorMessage> errors;

	public ErrorResponse(String errorId, ErrorMessage errorMessage) {
		this.errorId = errorId;
		this.errors = List.of(errorMessage);
	}

	public ErrorResponse(ErrorMessage errorMessage) {
		this(null, errorMessage);
	}

	public ErrorResponse(List<ErrorMessage> errors) {
		this.errorId = null;
		this.errors = errors;
	}

	public ErrorResponse() {
	}

	public String getErrorId() {
		return errorId;
	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ErrorResponse that = (ErrorResponse) o;
		return Objects.equals(errorId, that.errorId) && Objects.equals(errors, that.errors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorId, errors);
	}

	public static class ErrorMessage {

		@JsonInclude(JsonInclude.Include.NON_NULL)
		private String path;
		private String message;

		public ErrorMessage(String path, String message) {
			this.path = path;
			this.message = message;
		}

		public ErrorMessage(String message) {
			this.path = null;
			this.message = message;
		}

		public ErrorMessage() {
		}

		public String getMessage() {
			return message;
		}

		public String getPath() {
			return path;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			ErrorMessage that = (ErrorMessage) o;
			return Objects.equals(path, that.path) && Objects.equals(message, that.message);
		}

		@Override
		public int hashCode() {
			return Objects.hash(path, message);
		}
	}
}
