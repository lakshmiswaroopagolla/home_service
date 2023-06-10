package com.ty.home_service.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.home_service.util.CustomIdGenerator;

import lombok.Data;

@Entity

public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_seq")
	@GenericGenerator(name = "work_seq", strategy = "com.ty.home_service.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "10"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "work_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@NotNull(message = "type cant be null")
	@NotBlank(message ="type cant be blank")
	private String type;
	private Date startDate;
	private Date endDate;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@ManyToMany
	private List<Vendor> vendor;

	@OneToOne(cascade = CascadeType.ALL)
	private ServiceCost cost;

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

	public List<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(List<Vendor> vendor) {
		this.vendor = vendor;
	}

	public ServiceCost getCost() {
		return cost;
	}

	public void setCost(ServiceCost cost) {
		this.cost = cost;
	}
	
	
	

}
