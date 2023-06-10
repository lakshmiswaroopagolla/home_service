package com.ty.home_service.exception;

public class NoSuchElementFoundByCustomerSignException extends RuntimeException {
	private String message = "email is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByCustomerSignException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByCustomerSignException() {
		super();

	}

}