package com.ty.home_service.controller;

import java.util.List;

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

import com.ty.home_service.dto.VendorDto;
import com.ty.home_service.entity.Vendor;
import com.ty.home_service.service.VendorService;
import com.ty.home_service.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorService service;

	@PostMapping
	@ApiOperation(value = "save  vendor", notes = "Api is used to save vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor is saved")})
	public ResponseEntity<ResponseStructure<VendorDto>> signupVendor(@Valid @RequestBody Vendor vendor) {
		return service.signUpVendor(vendor);
	}

	@PutMapping
	@ApiOperation(value = "update  vendor", notes = "Api is used to update vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor is updated"),
		@ApiResponse(code=404,message = "vendor id is not found to update")})
	public ResponseEntity<ResponseStructure<VendorDto>> updateVendor(@RequestBody Vendor vendor,
			@RequestParam String id) {
		return service.updateVendor(id, vendor);
	}

	@DeleteMapping
	@ApiOperation(value = "delete  vendor", notes = "Api is used to delete vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor is deleted"),
		@ApiResponse(code=404,message = "vendor id is not found to delete")})
	public ResponseEntity<ResponseStructure<VendorDto>> deleteVendor(@RequestParam String id) {
		return service.deleteVendor(id);
	}

	@GetMapping
	@ApiOperation(value = "display  vendor", notes = "Api is used to display the vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor is found to display"),
		@ApiResponse(code=404,message = "vendor id is not found to display")})
	public ResponseEntity<ResponseStructure<VendorDto>> getVendorbyID(@RequestParam String id) {
		return service.getVendorById(id);
	}

	@GetMapping("/email")
	@ApiOperation(value = "update  vendor email", notes = "Api is used to update vendor email ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor email is updated"),
		@ApiResponse(code=404,message = "vendor id is not found to update email")})
	public ResponseEntity<ResponseStructure<VendorDto>> getVendorbyEmail(@RequestParam String email) {
		return service.getVendorByEmail(email);
	}
	
	@GetMapping("/emailentity")
	@ApiOperation(value = "update  vendor email", notes = "Api is used to update vendor email ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor email is updated"),
		@ApiResponse(code=404,message = "vendor id is not found to update email")})
	public ResponseEntity<ResponseStructure<Vendor>> getVendorEntitybyEmail(@RequestParam String email) {
		return service.getVendorEntityByEmail(email);
	}

	@GetMapping("/login")
	@ApiOperation(value = "login  vendor", notes = "Api is used to login  vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor is found to loggin"),
		@ApiResponse(code=404,message = "vendor id is not found to login")})
	public ResponseEntity<ResponseStructure<VendorDto>> VendorLogin(@RequestParam String email,
			@RequestParam String pwd) {
		return service.VendorLogin(email, pwd);
	}

//	@GetMapping("/pwdupdate")
//	@ApiOperation(value = "update  vendor password", notes = "Api is used to update vendor password ")
//	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor password is updated"),
//		@ApiResponse(code=404,message = "vendor id is not found to update password")})
//	public ResponseEntity<ResponseStructure<VendorDto>> updatepassword(@RequestParam String id,
//			@RequestParam String pwd) {
//		return service.updatePassword(pwd, id);
//	}
//
//	@GetMapping("/emailupdate")
//	public ResponseEntity<ResponseStructure<VendorDto>> updateEmail(@RequestParam String id,
//			@RequestParam String email) {
//		return service.updateEmail(email, id);
//	}
	
	@GetMapping("/role")
	@ApiOperation(value = "list of  vendor based on role", notes = "Api is used to display list of  vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor list is found to display"),
		@ApiResponse(code=404,message = "vendor list is not found based on role")})
	public ResponseEntity<ResponseStructure<List<VendorDto>>> listofAvailabilty(@RequestParam String role) {
		return service.listOfAvailability( role);
	}
	@GetMapping("/state")
	@ApiOperation(value = "list of  vendor based on state", notes = "Api is used to display list of  vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor list is found to display"),
		@ApiResponse(code=404,message = "vendor list is not found based on state")})
	public ResponseEntity<ResponseStructure<List<VendorDto>>> listOfAvailabilityinState(@RequestParam String state) {
		return service.listOfAvailabilityinState(state);
	}
	@GetMapping("/district")
	@ApiOperation(value = "list of  vendor based on state and district", notes = "Api is used to display list of  vendor ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor list is found to display"),
		@ApiResponse(code=404,message = "vendor list is not found based on state and district")})
	public ResponseEntity<ResponseStructure<List<VendorDto>>> listOfAvailabilityInDistrict(@RequestParam String state,@RequestParam String district) {
		return service.listOfAvailabilityInDistrict(state, district);
	}
	

}
