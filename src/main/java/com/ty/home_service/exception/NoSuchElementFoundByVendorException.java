package com.ty.home_service.exception;

public class NoSuchElementFoundByVendorException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByVendorException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByVendorException() {
		super();

	}

}