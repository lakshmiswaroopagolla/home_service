package com.ty.home_service.exception;

public class NoSuchElementFoundByAddressException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByAddressException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByAddressException() {
		super();

	}

}