package com.ty.home_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.home_service.entity.ServiceCost;
import com.ty.home_service.repo.ServiceCostRepo;

@Repository
public class ServiceCostDao {
	
	@Autowired
	private ServiceCostRepo repo;

	public ServiceCost saveServiceCost(ServiceCost cost)
	{
		
		return repo.save(cost);
			
		
	}
	public ServiceCost updateServiceCost(String id, ServiceCost cost)
	{
		
		if(repo.findById( id).isPresent())
		{
			cost.setId(id);
			return repo.save(cost);
		}else {
			return null;
		}
		
	}
	
	public ServiceCost deleteServiceCost(String id)
	{
		if(repo.findById( id).isPresent())
		{
			ServiceCost cost=repo.findById( id).get();
			 repo.deleteById(id);
			return cost;
		}
		else {
			return null;
		}
	}
	
	public ServiceCost getById(String id)
	{
		if(repo.findById( id).isPresent())
		{
			ServiceCost cost=repo.findById( id).get();
			return cost;
		}
		else {
			return null;
		}
	}


}
