package com.ty.home_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.home_service.dao.CustomerDao;
import com.ty.home_service.dto.CustomerDto;
import com.ty.home_service.dto.DtoConfig;
import com.ty.home_service.entity.Customer;
import com.ty.home_service.entity.Work;
import com.ty.home_service.exception.IdNotFoundByCustomerException;
import com.ty.home_service.exception.NoSuchElementFoundByCustomerException;
import com.ty.home_service.exception.NoSuchElementFoundByCustomerLoginException;
import com.ty.home_service.exception.NoSuchElementFoundByCustomerSignException;
import com.ty.home_service.util.ResponseStructure;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	@Autowired
	private DtoConfig config;

	public ResponseEntity<ResponseStructure<CustomerDto>> signUpCustomer(Customer customer) {
		ResponseStructure<CustomerDto> structure = new ResponseStructure();
		


			structure.setData(config.dtoattributes(dao.saveCustomer(customer)));

			structure.setMessage("customer signup successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure, HttpStatus.CREATED);

		
		

	}

	public ResponseEntity<ResponseStructure<CustomerDto>> updatecustomer(String id, Customer customer) {
		Customer customerdb = dao.getCustomerByID(id);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure();
		if (customerdb != null) {
         
			responseStructure.setMessage("Sucessfully customer is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.dtoattributes(dao.updatecustomer(customer, id)));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByCustomerException("Customer is not found  to update");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(String id) {
		Customer db = dao.getCustomerByID(id);
		System.out.println(db);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure();
		if (db != null) {
			dao.deleteCustomer(id);
			responseStructure.setMessage("Sucessfully Customer is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.dtoattributes(db));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByCustomerException("Customer is not fount  to delete");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerByEmail(String email) {
		Customer db = dao.getCustomerByEmail(email);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure();
		if (db != null) {

			responseStructure.setMessage("Sucessfully User  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.dtoattributes(db));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByCustomerException(
					"customer is not found for your email " + email + " to display");
		}

	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerEntityByEmail(String email) {
		Customer db = dao.getCustomerByEmail(email);
		ResponseStructure<Customer> responseStructure = new ResponseStructure();
		if (db != null) {

			responseStructure.setMessage("Sucessfully User  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(db);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByCustomerException(
					"customer is not found for your email " + email + " to display");
		}

	}
	
	
	
	

	public ResponseEntity<ResponseStructure<CustomerDto>> updateEmail(String email, String id) {
		Customer db = dao.getCustomerByID(id);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure();
		if (db != null) {
			responseStructure.setMessage("Sucessfully UserEmail  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.dtoattributes(dao.updateCustomerEmail(email)));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByCustomerException("Customer is not found  to update email");
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> updatePassword(String pwd, String id) {
		Customer db = dao.getCustomerByID(id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure();
		if (db != null) {
			dao.updateCustomerPwd(pwd,id);
			responseStructure.setMessage("Sucessfully User  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(db);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByCustomerException("Customer is not found  to update password");
		}

	}

	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerById(String id) {
		Customer db = dao.getCustomerByID(id);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure();
		System.out.println(db);
		if (db != null) {

			responseStructure.setMessage("Sucessfully User  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.dtoattributes(db));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByCustomerException(
					"customer id is not found for your id " + id + " to display");
		}

	}

	public ResponseEntity<ResponseStructure<CustomerDto>> CustomerLogin(String email, String pwd) {
		Customer db = dao.getCustomerByEmail(email);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure();
		if (db != null) {

			if (db.getPwd().equals(pwd)) {
				responseStructure.setMessage("Sucessfully  Customer Loggedin  ");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(config.dtoattributes(db));
				return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
			} else {
				throw new NoSuchElementFoundByCustomerLoginException("pls check the password " + pwd + " properly");
			}
		} else {
			throw new NoSuchElementFoundByCustomerException(
					"Customer is not found for your email " + email + " to be login");
		}
	}

}
