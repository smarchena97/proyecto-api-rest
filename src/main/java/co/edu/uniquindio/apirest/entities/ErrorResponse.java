package co.edu.uniquindio.apirest.entities;

import java.util.List;

import org.springframework.validation.FieldError;

public class ErrorResponse {
	private List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public ErrorResponse(List<Error> errors) {
		this.errors = errors;
	}

	public ErrorResponse(int value, String string, List<FieldError> errors2) {
		// TODO Auto-generated constructor stub
	}
}
