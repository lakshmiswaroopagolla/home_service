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

import com.ty.home_service.dto.WorkDto;
import com.ty.home_service.entity.Address;
import com.ty.home_service.entity.Work;
import com.ty.home_service.service.AddressService;
import com.ty.home_service.service.WorkService;
import com.ty.home_service.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/work")
public class WorkController {
	@Autowired
	private WorkService service;
	

	@PostMapping
	@ApiOperation(value = "save  work", notes = "Api is used to save work ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  work is save"),
		@ApiResponse(code=404,message = "customer id is not found to save work")})
	public ResponseEntity<ResponseStructure<WorkDto>> saveWork(@Valid @RequestBody Work work,@RequestParam String id) {
		return service.saveWork(work, id);
	}

//	@PutMapping
//	@ApiOperation(value = "update  work", notes = "Api is used to update work ")
//	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  work is updated"),
//		@ApiResponse(code=404,message = "work id is not found to update work")})
//	public ResponseEntity<ResponseStructure<WorkDto>> updateWork(@RequestBody Work work,
//			@RequestParam String id) {
//		return service.updateWork(id, work);
//	}
//
	@DeleteMapping
	@ApiOperation(value = "delete  work", notes = "Api is used to delete work ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  work is deleted"),
		@ApiResponse(code=404,message = "customer id is not found to delete work or cant delete the parent row column")})
	public ResponseEntity<ResponseStructure<WorkDto>> deleteWork(@RequestParam String id) {
		return service.deleteWork(id);
	}

	@GetMapping
	@ApiOperation(value = "display  work", notes = "Api is used to display work ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  work is displayed"),
		@ApiResponse(code=404,message = "work id is not found to display work")})
	public ResponseEntity<ResponseStructure<WorkDto>> getWorkbyID(@RequestParam String id) {
		return service.getById(id);
		
		
		
	}
	
	
	

}
