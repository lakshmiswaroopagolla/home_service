package com.ty.home_service.exception;

public class NoSuchElementFoundByCustomerException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByCustomerException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByCustomerException() {
		super();

	}

}