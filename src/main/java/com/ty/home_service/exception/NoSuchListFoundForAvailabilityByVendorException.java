package com.ty.home_service.exception;

public class NoSuchListFoundForAvailabilityByVendorException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchListFoundForAvailabilityByVendorException(String message) {
		super();
		this.message = message;
	}

	public NoSuchListFoundForAvailabilityByVendorException() {
		super();

	}

}