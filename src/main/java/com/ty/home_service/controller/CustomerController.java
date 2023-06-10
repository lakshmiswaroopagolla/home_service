package com.ty.home_service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.home_service.dto.CustomerDto;
import com.ty.home_service.entity.Customer;
import com.ty.home_service.service.CustomerService;
import com.ty.home_service.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@PostMapping
	@ApiOperation(value = "save  customer", notes = "Api is used to save customer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  customer is saved")})
	public ResponseEntity<ResponseStructure<CustomerDto>> signupCustomer(@Valid @RequestBody Customer customer) {
		return service.signUpCustomer(customer);
	}

	@PutMapping
	@ApiOperation(value = "update  customer", notes = "Api is used to update customer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  customer is found to update"),
		@ApiResponse(code=404,message = "customer id is not found to update")})
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(@Valid @RequestBody Customer customer,
			@RequestParam String id) {
		return service.updatecustomer(id, customer);
	}

	@DeleteMapping
	@ApiOperation(value = "delete  customer", notes = "Api is used to delete customer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  customer is found to delete"),
		@ApiResponse(code=404,message = "customer id is not found to delete")})
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(@RequestParam String id) {
		return service.deleteCustomer(id);
	}

	@GetMapping
	@ApiOperation(value = "display  customer", notes = "Api is used to display customer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  customer is found to display"),
		@ApiResponse(code=404,message = "customer id is not found to display")})
	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerbyID(@RequestParam String id) {
		return service.getCustomerById(id);
	}

	@GetMapping("/email")
	@ApiOperation(value = "display  customer by email", notes = "Api is used to display customer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  customer is found to display"),
		@ApiResponse(code=404,message = "customer email is not found to display")})
	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerbyEmail(@RequestParam String email) {
		return service.getCustomerByEmail(email);
	}
	
	@GetMapping("/emailentity")
	@ApiOperation(value = "display  customer by email", notes = "Api is used to display customer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  customer is found to display"),
		@ApiResponse(code=404,message = "customer email is not found to display")})
	public ResponseEntity<ResponseStructure<Customer>> getCustomerEntitybyEmail(@RequestParam String email) {
		return service.getCustomerEntityByEmail(email);
	}

	@GetMapping("/login")
	@ApiOperation(value = "  customer Login", notes = "Api is used to login customer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  customer is found to login"),
		@ApiResponse(code=404,message = "login credentails are wrong pls provide correct details")})
	public ResponseEntity<ResponseStructure<CustomerDto>> customerLogin(@RequestParam String email,
			@RequestParam String pwd) {
		return service.CustomerLogin(email, pwd);
	}

	

	

}
