package com.ty.home_service.exception;

public class IdNotFoundByCustomerException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByCustomerException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByCustomerException() {
		super();

	}

}