package br.com.foodservice.api.exception;

public class FoodServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FoodServiceException(String message) {
		super(message);
	}

}
