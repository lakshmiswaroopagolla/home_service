package com.ty.home_service.exception;

public class NoSuchElementFoundByVendorLoginException extends RuntimeException {
	private String message = "email is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByVendorLoginException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByVendorLoginException() {
		super();

	}

}