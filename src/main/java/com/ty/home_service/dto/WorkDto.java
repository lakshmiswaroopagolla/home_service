package com.ty.home_service.dto;

import java.sql.Date;



import org.springframework.stereotype.Component;

import com.ty.home_service.entity.Address;

import lombok.Data;

@Component

public class WorkDto {
	private String id;
	private String type;
	private Date startDate;
	private Date endDate;
	private Address address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
