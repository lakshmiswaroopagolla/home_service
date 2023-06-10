package com.ty.home_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.home_service.entity.ServiceCost;
import com.ty.home_service.service.ServiceCostService;
import com.ty.home_service.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cost")
public class ServiceCostController {
	@Autowired
	private ServiceCostService service;
	

	@PostMapping
	@ApiOperation(value = "save  servicecost", notes = "Api is used to save servicecost ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  servicecost is saved"),
		@ApiResponse(code=404,message = "vendor id or work id is not found to save")})
	public ResponseEntity<ResponseStructure<ServiceCost>> saveServiceCost(@RequestBody ServiceCost cost,@RequestParam String W_id,@RequestParam String V_id) {
		return service.saveServiceCost(W_id, V_id, cost);
	}


	@GetMapping
	@ApiOperation(value = "display  servicecost list", notes = "Api is used to display list of servicecost  ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  vendor id is found to display the list "),
		@ApiResponse(code=404,message = "vendor id is not found to display the list")})
	public ResponseEntity<ResponseStructure<List<ServiceCost>>> getservicecostbyVendorID(@RequestParam String id) {
		return service.getServiceCostListByVendorId(id);
	}
		
		
		
	
	
	
	

}
