package com.ty.home_service.dto;

import org.springframework.stereotype.Component;

import com.ty.home_service.entity.Address;

import lombok.Data;

@Component

public class VendorDto {
	
	
	private String id;
	private String name;
	private String email;
	private long phone;
	private String role;
	private double costperday;
	private String availability;
	private Address address;
	//private List<ServiceCost>payments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getCostperday() {
		return costperday;
	}
	public void setCostperday(double costperday) {
		this.costperday = costperday;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	

}
