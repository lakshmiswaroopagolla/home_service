package com.ty.home_service.exception;

public class NoSuchListFoundForDistrictByVendorException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchListFoundForDistrictByVendorException(String message) {
		super();
		this.message = message;
	}

	public NoSuchListFoundForDistrictByVendorException() {
		super();

	}

}