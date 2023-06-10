package com.ty.home_service.exception;

public class IdNotFoundByVendorException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByVendorException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByVendorException() {
		super();

	}

}