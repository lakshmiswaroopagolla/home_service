package com.ty.home_service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.home_service.entity.Address;
import com.ty.home_service.service.AddressService;
import com.ty.home_service.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")//====router
public class AddressController {
	@Autowired
	private AddressService service;
	

	@PostMapping
	@ApiOperation(value = "save address", notes = "Api is used to save address ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully saved address"),
		@ApiResponse(code = 404, message = "id is not found to save")})
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address,@RequestParam String id) {
		return service.saveAddress(address,id);
	}

	@PutMapping
	@ApiOperation(value = "update  address", notes = "Api is used to update address ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  address is updated"),
		@ApiResponse(code = 404, message = " address id is not found to update")})
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,
			@RequestParam String id) {
		return service.updateAddress(id, address);
	}

//	@DeleteMapping
//	@ApiOperation(value = "delete  address", notes = "Api is used to delete address ")
//	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  address is updated"),
//		@ApiResponse(code = 404, message = " address id is not found to save")})
//	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam String id) {
//		return service.deleteAddress(id);
//	}

	
	@GetMapping
	@ApiOperation(value = "display  address", notes = "Api is used to display address ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  address is found to display"),
		@ApiResponse(code = 404, message = " address id is not found to display")})
	public ResponseEntity<ResponseStructure<Address>> getAddressbyID(@RequestParam String id) {
		return service.getById(id);
		
		
		
	}
	
	
	

}
