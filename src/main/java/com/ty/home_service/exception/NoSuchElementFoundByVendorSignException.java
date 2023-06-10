package com.ty.home_service.exception;

public class NoSuchElementFoundByVendorSignException extends RuntimeException {
	private String message = "email is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByVendorSignException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByVendorSignException() {
		super();

	}

}