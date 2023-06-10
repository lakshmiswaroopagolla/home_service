package com.ty.home_service.dto;

import org.springframework.stereotype.Controller;

import com.ty.home_service.entity.Address;

import lombok.Data;


@Controller
public class CustomerDto {

	private String id;
	private String name;
	private String email;
	private long phone;
	private int familycount;
	
	private Address address;

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

	public int getFamilycount() {
		return familycount;
	}

	public void setFamilycount(int familycount) {
		this.familycount = familycount;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	


}
