package com.ty.home_service.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.home_service.util.ResponseStructure;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> error = ex.getAllErrors();
		Map<String, String> map = new HashMap<String, String>();
		ResponseStructure<Object> structure = new ResponseStructure();

		for (ObjectError objectError : error) {
			String filedName = ((FieldError) objectError).getField();
			String message = ((FieldError) objectError).getDefaultMessage();
			map.put(filedName, message);

			

		}
		structure.setMessage("provide valid details");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(map);
		
		
		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);
	}

	
	

	  @ExceptionHandler(ConstraintViolationException.class)
	  public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		ResponseStructure<Object> structure = new ResponseStructure();
		Map<String, String> map = new HashMap<String, String>();

	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	      String field = violation.getPropertyPath().toString();
	      String message = violation.getMessage();
	      map.put(field, message);
	      
	     
	    }
	    
	      structure.setMessage("provide proper details");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(map);
	    
		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);

	    
	  }
	
	

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlintegrityconstraintViolation(
			SQLIntegrityConstraintViolationException ex) {

		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("you cant perform this opertation");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// customer
	@ExceptionHandler(IdNotFoundByCustomerException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByMenuException(
			IdNotFoundByCustomerException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(" Customer id is not found to display");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// costumer
	@ExceptionHandler(NoSuchElementFoundByCustomerException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByCustomerException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No such element is found for customer ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// costumer
	@ExceptionHandler(NoSuchElementFoundByCustomerSignException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByCustomerSignException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("cannot signup properly pls provide new email ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// costumer
	@ExceptionHandler(NoSuchElementFoundByCustomerLoginException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByCustomerLoginException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("your entered password is incorrect .pls enter the correct password to login ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// vendor
	@ExceptionHandler(IdNotFoundByVendorException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByMenuException(IdNotFoundByVendorException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(" Vendor id is not found to display");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// vendor
	@ExceptionHandler(NoSuchElementFoundByVendorException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByVendorException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No such element is found for customer ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// vendor
	@ExceptionHandler(NoSuchElementFoundByVendorSignException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByVendorSignException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("cannot signup properly pls provide new email ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// vendor
	@ExceptionHandler(NoSuchElementFoundByVendorLoginException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByVendorLoginException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("your entered password is incorrect .pls enter the correct password to login ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// vendor
	@ExceptionHandler(NoSuchListFoundForAvailabilityByVendorException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchListFoundForAvailabilityByVendorException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("the role is not avaiable pls check other role");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// address
	@ExceptionHandler(NoSuchElementFoundByAddressException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByAddressException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("address is not found for this elemecnt");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// address
	@ExceptionHandler(IdNotFoundByAddressException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(IdNotFoundByAddressException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("address is not found for ID");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// work
	@ExceptionHandler(IdNotFoundByWorkException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(IdNotFoundByWorkException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("work is not found for ID");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
