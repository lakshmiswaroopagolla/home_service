package com.ty.home_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.home_service.entity.Address;

public interface AddressRepo  extends JpaRepository<Address, String>{

}
