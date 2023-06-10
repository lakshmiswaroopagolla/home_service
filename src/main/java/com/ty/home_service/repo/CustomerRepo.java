package com.ty.home_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.home_service.entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, String>{

	
	public Customer findByEmail(String email);
}
