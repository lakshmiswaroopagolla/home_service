package com.ty.home_service.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ty.home_service.entity.Address;
import com.ty.home_service.repo.AddressRepo;


@Repository
public class AddressDao {
	
	
	@Autowired
	private AddressRepo addressRepository;
	
	
	public Address saveAddress(Address address)
	{
		
		return addressRepository.save(address);
			
		
	}
	public Address updateAddress(String id, Address address)
	{
		
		if(addressRepository.findById( id).isPresent())
		{
			address.setId(id);
			return addressRepository.save(address);
		}else {
			return null;
		}
		
	}
	
	public Address deleteAddress(String id)
	{
		if(addressRepository.findById( id).isPresent())
		{
			Address address=addressRepository.findById( id).get();
			 addressRepository.delete(address);
			return address;
		}
		else {
			return null;
		}
	}
	
	public Address getById(String id)
	{
		if(addressRepository.findById( id).isPresent())
		{
			Address address=addressRepository.findById( id).get();
			return address;
		}
		else {
			return null;
		}
	}

}
