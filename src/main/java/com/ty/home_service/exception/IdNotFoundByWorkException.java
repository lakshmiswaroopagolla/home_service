package com.ty.home_service.exception;

public class IdNotFoundByWorkException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByWorkException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByWorkException() {
		super();

	}

}