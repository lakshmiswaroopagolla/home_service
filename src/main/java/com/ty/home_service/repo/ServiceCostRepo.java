package com.ty.home_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.home_service.entity.ServiceCost;

public interface ServiceCostRepo  extends JpaRepository<ServiceCost, String>{

}
