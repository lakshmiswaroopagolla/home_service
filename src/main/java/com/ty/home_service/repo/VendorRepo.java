package com.ty.home_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.home_service.entity.Vendor;

public interface VendorRepo  extends JpaRepository<Vendor, String>{

	
	public Vendor findByEmail(String email);
	
	@Query("select a from Vendor a where a.availability=?1 and role=?2")
	public List<Vendor> basedonAvailability(String AVAILABLE,String role);
	
	@Query("select a from Vendor a where a.address.state=?1 and a.availability=?2 ")
    public List<Vendor>listOfState(String state,String available);
	
	@Query("select a from Vendor a where a.address.state=?1 and a.address.district=?2 and  a.availability=?3")
    public List<Vendor>listOfDistrict(String state,String district,String available);
}
