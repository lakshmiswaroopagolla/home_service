package com.ty.home_service.exception;

public class NoSuchElementFoundByCustomerLoginException extends RuntimeException {
	private String message = "email is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByCustomerLoginException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByCustomerLoginException() {
		super();

	}

}