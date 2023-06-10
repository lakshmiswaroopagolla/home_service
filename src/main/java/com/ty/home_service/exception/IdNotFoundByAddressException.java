package com.ty.home_service.exception;

public class IdNotFoundByAddressException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByAddressException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByAddressException() {
		super();

	}

}