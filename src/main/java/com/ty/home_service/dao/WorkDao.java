package com.ty.home_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.home_service.entity.Address;
import com.ty.home_service.entity.Work;
import com.ty.home_service.repo.AddressRepo;
import com.ty.home_service.repo.WorkRepo;


@Repository
public class WorkDao {
	
	
	@Autowired
	private WorkRepo repo;
	
	
	public Work saveWork(Work work)
	{
		
		return repo.save(work);
			
		
	}
	public Work updateWork(String id, Work work)
	{
		
		if(repo.findById( id).isPresent())
		{
			work.setId(id);
			return repo.save(work);
		}else {
			return null;
		}
		
	}
	
	public Work deleteWork(String id)
	{
		if(repo.findById( id).isPresent())
		{
			Work work=repo.findById( id).get();
			 repo.deleteById(id);
			return work;
		}
		else {
			return null;
		}
	}
	
	public Work getById(String id)
	{
		if(repo.findById( id).isPresent())
		{
			Work work=repo.findById( id).get();
			return work;
		}
		else {
			return null;
		}
	}

}
