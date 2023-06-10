package com.ty.home_service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ty.home_service.entity.Customer;
import com.ty.home_service.entity.Vendor;
import com.ty.home_service.entity.Work;

@Controller
public class DtoConfig {
	
	@Autowired
	private CustomerDto dto;
	
	@Autowired
	private VendorDto vendor;
	
	@Autowired
	private WorkDto work;
	
	
	public CustomerDto dtoattributes( Customer c) {
		dto.setId(c.getId());
		dto.setFamilycount(c.getFamilycount());
		dto.setName(c.getName());
		dto.setPhone(c.getPhone());
		dto.setEmail(c.getEmail());
		dto.setAddress(c.getAddress());
		return dto;
	}
	
	
	public VendorDto vendorattributes(Vendor v) {
		vendor.setId(v.getId());
		vendor.setAddress(v.getAddress());
		vendor.setAvailability(v.getAvailability());
		vendor.setCostperday(v.getCostperday());
		vendor.setEmail(v.getEmail());
		vendor.setRole(v.getRole());
		//vendor.setPayments(v.getPayments());
		vendor.setName(v.getName());  
		vendor.setPhone(v.getPhone());
		vendor.setAddress(v.getAddress());
		
	
		return vendor;
	}
	

	
	public WorkDto workattributes(Work w) {
		work.setId(w.getId());
		work.setAddress(w.getAddress());
		work.setStartDate(w.getStartDate());
		work.setEndDate(w.getEndDate());
		work.setType(w.getType());
		return work;
	}
	
	

}
