package com.ty.home_service.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.home_service.entity.ServiceCost;
import com.ty.home_service.entity.Vendor;
import com.ty.home_service.repo.VendorRepo;
import com.ty.home_service.util.AES_homeService;

@Repository
public class VendorDao {
	
	@Autowired
	private VendorRepo repo;
	
	public Vendor saveVendor(Vendor vendor) {
		vendor.setPwd(AES_homeService.encrypt(vendor.getPwd()));
		return repo.save(vendor);
	}
	
	public Vendor updateVendor(Vendor vendor ,String id) {
		System.out.println(vendor);
		if(repo.findById(id).isPresent()) {
			Vendor c=repo.findById(id).get();
			vendor.setId(id);
			
			if(vendor.getAddress()==null) {
				vendor.setAddress(c.getAddress());
			}
			if(vendor.getCost()==null) {
				vendor.setCost(c.getCost());
			}
			
			
			
			
			
			if(vendor.getPwd()==null) {
				vendor.setPwd(c.getPwd());
			}
			else
			{
				vendor.setPwd(AES_homeService.encrypt(vendor.getPwd()));

			}
			repo.save(vendor);
			return vendor;
		}
		return null;
	}
	
	public Vendor updateVendorEmail(String email) {
		Vendor vendor=repo.findByEmail(email);
		if(vendor!=null) {
			vendor.setEmail(email);
			return  repo.save(vendor);
		}
		return null;
	}
	
	public Vendor updateVendorPwd(String pwd) {
		Vendor vendor=repo.findByEmail(pwd);
		if(vendor!=null) {
			vendor.setPwd(AES_homeService.encrypt(vendor.getPwd()));
			return  repo.save(vendor);
		}
		return null;
	}
	
	public Vendor deletevendor(String id) {
	  Optional<Vendor>optional=repo.findById(id);
	  if(optional.isPresent()) {
		  repo.deleteById(id);
	  return optional.get();}	  
	  else {
		 
		  return null;
	  }
	}
	
	public Vendor getVendorByID(String id) {
		  Optional<Vendor>optional=repo.findById(id);
		  if(optional.isPresent()) {
			  Vendor vendor=repo.findById(id).get();
				vendor.setPwd(AES_homeService.decrypt(vendor.getPwd()));

			  return vendor;}
		  else
			 
			  return null;
	}
	
	public Vendor getVendorByEmail(String email) {
		Vendor vendor=repo.findByEmail(email);
		if(vendor!=null) {
		vendor.setPwd(AES_homeService.decrypt(vendor.getPwd()));
		return vendor;}
		else
			return null;
	}
	
	
    public List<Vendor> listOfVenderBasedOnAvailability(String role){
    	String available="AVAILABLE";
    	
     List<Vendor>vendor=	repo.basedonAvailability( available,role);
     if(repo.basedonAvailability( available,role).isEmpty())
    	 return null;
     else
    	 return vendor;
    }
    
    public List<Vendor>listOfAvailabilityinState(String state){
    	String available="AVAILABLE";
    	
        List<Vendor>vendor=	repo.listOfState( state,available);
        if(repo.listOfState( state,available).isEmpty())
       	 return null;
        else
       	 return vendor;
    }
    public List<Vendor>listOfAvailabilityInDistrict(String state,String district){
    	String available="AVAILABLE";
    	
        List<Vendor>vendor=	repo.listOfDistrict( state,district,available);
        if(repo.listOfDistrict( state,district,available).isEmpty())
       	 return null;
        else
       	 return vendor;
    }

	

}
