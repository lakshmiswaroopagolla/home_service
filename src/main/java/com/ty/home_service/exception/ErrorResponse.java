package com.ty.home_service.exception;


	
	import org.springframework.http.HttpStatus;

import lombok.Data;

import java.util.List;
  @Data
	public class ErrorResponse {
//	    private HttpStatus status;
//	    private String message;
//	    private List<String> errors;
//
//	    public ErrorResponse(HttpStatus status, String message, List<String> errors) {
//	        super();
//	        this.status = status;
//	        this.message = message;
//	        this.errors = errors;
//	    }
//
//	    public HttpStatus getStatus() {
//	        return status;
//	    }
//
//	    public void setStatus(HttpStatus status) {
//	        this.status = status;
//	    }
//
//	    public String getMessage() {
//	        return message;
//	    }
//
//	    public void setMessage(String message) {
//	        this.message = message;
//	    }
//
//	    public List<String> getErrors() {
//	        return errors;
//	    }
//
//	    public void setErrors(List<String> errors) {
//	        this.errors = errors;
//	    }
		
		
		
		
		 private String field;
		  private String message;

		  public ErrorResponse(String field, String message) {
		    this.field = field;
		    this.message = message;
		  }
	}



