package com.ty.home_service.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.home_service.dao.CustomerDao;
import com.ty.home_service.dao.VendorDao;
import com.ty.home_service.dto.CustomerDto;
import com.ty.home_service.dto.DtoConfig;
import com.ty.home_service.dto.VendorDto;
import com.ty.home_service.entity.Customer;
import com.ty.home_service.entity.ServiceCost;
import com.ty.home_service.entity.Vendor;
import com.ty.home_service.exception.IdNotFoundByCustomerException;
import com.ty.home_service.exception.IdNotFoundByVendorException;
import com.ty.home_service.exception.NoSuchElementFoundByCustomerException;
import com.ty.home_service.exception.NoSuchElementFoundByCustomerLoginException;
import com.ty.home_service.exception.NoSuchElementFoundByCustomerSignException;
import com.ty.home_service.exception.NoSuchElementFoundByVendorException;
import com.ty.home_service.exception.NoSuchElementFoundByVendorLoginException;
import com.ty.home_service.exception.NoSuchElementFoundByVendorSignException;
import com.ty.home_service.exception.NoSuchListFoundForAvailabilityByVendorException;
import com.ty.home_service.exception.NoSuchListFoundForDistrictByVendorException;
import com.ty.home_service.util.ResponseStructure;

@Service
public class VendorService {
	@Autowired
	private VendorDao dao;
	@Autowired
	private DtoConfig config;

	public ResponseEntity<ResponseStructure<VendorDto>> signUpVendor(Vendor  vendor) {
		Vendor db=dao.getVendorByEmail(vendor.getEmail());
		ResponseStructure<VendorDto> structure = new ResponseStructure();
		if (db == null) {

			Vendor c = dao.saveVendor(vendor);

			structure.setData(config.vendorattributes(vendor));

			structure.setMessage("Vendor signup successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<VendorDto>>(structure, HttpStatus.CREATED);

		}
		throw new NoSuchElementFoundByVendorSignException(
				"Vendor is  found for your email " + vendor.getEmail() + " pls provide a new email");

	}

	public ResponseEntity<ResponseStructure<VendorDto>> updateVendor(String id, Vendor vendor) {
		Vendor db=dao.getVendorByID(id);
		ResponseStructure<VendorDto> responseStructure = new ResponseStructure();
		if (db != null) {
          
			responseStructure.setMessage("Sucessfully Vendor is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.vendorattributes(dao.updateVendor(vendor, id)));
			return new ResponseEntity<ResponseStructure<VendorDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByVendorException("Vendor is not found  to update");
		}
	}

	public ResponseEntity<ResponseStructure<VendorDto>> deleteVendor(String id) {
		Vendor db=dao.getVendorByID(id);
		ResponseStructure<VendorDto> responseStructure = new ResponseStructure();
		if (db != null) {
			dao.deletevendor(id);
			responseStructure.setMessage("Sucessfully Vendor is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.vendorattributes(db));
			return new ResponseEntity<ResponseStructure<VendorDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByVendorException("Vendor is not found  to delete");
		}
	}

	public ResponseEntity<ResponseStructure<VendorDto>> getVendorByEmail(String email) {
		Vendor db=dao.getVendorByEmail(email);
		ResponseStructure<VendorDto> responseStructure = new ResponseStructure();
		if (db != null) {

			responseStructure.setMessage("Sucessfully Vendor  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.vendorattributes(db));
			return new ResponseEntity<ResponseStructure<VendorDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByVendorException(
					"Vendor is not found for your email " + email + " to display");
		}

	}
	
	
	public ResponseEntity<ResponseStructure<Vendor>> getVendorEntityByEmail(String email) {
		Vendor db=dao.getVendorByEmail(email);
		ResponseStructure<Vendor> responseStructure = new ResponseStructure();
		if (db != null) {

			responseStructure.setMessage("Sucessfully Vendor  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(db);
			return new ResponseEntity<ResponseStructure<Vendor>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByVendorException(
					"Vendor is not found for your email " + email + " to display");
		}

	}

	public ResponseEntity<ResponseStructure<VendorDto>> updateEmail(String email, String id) {
		Vendor db=dao.getVendorByID(id);
		ResponseStructure<VendorDto> responseStructure = new ResponseStructure();
		if (db != null) {
			dao.updateVendorEmail(email);
			responseStructure.setMessage("Sucessfully VendorEmail  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.vendorattributes(db));
			return new ResponseEntity<ResponseStructure<VendorDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByVendorException("Vendor is not found  to update email");
		}

	}

	public ResponseEntity<ResponseStructure<VendorDto>> updatePassword(String pwd, String id) {
		Vendor db=dao.getVendorByID(id);
		ResponseStructure<VendorDto> responseStructure = new ResponseStructure();
		if (db != null) {
			dao.updateVendorPwd(pwd);
			responseStructure.setMessage("Sucessfully Vendor  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.vendorattributes(db));
			return new ResponseEntity<ResponseStructure<VendorDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByVendorException("Vendor is not found  to update password");
		}

	}

	public ResponseEntity<ResponseStructure<VendorDto>> getVendorById(String id) {
		Vendor db=dao.getVendorByID(id);
		ResponseStructure<VendorDto> responseStructure = new ResponseStructure();
		if (db != null) {

			responseStructure.setMessage("Sucessfully Vendor  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(config.vendorattributes(db));
			return new ResponseEntity<ResponseStructure<VendorDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByVendorException(
					"Vendor id is not found for your id " + id + " to display");
		}

	}

	public ResponseEntity<ResponseStructure<VendorDto>> VendorLogin(String email, String pwd) {
		Vendor db=dao.getVendorByEmail(email);
		ResponseStructure<VendorDto> responseStructure = new ResponseStructure();
		if (db != null) {

			if (db.getPwd().equals(pwd)) {
				responseStructure.setMessage("Sucessfully  Vendor Loggedin  ");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(config.vendorattributes(db));
				return new ResponseEntity<ResponseStructure<VendorDto>>(responseStructure, HttpStatus.OK);
			} else {
				throw new NoSuchElementFoundByVendorLoginException("pls check the password " + pwd + " properly");
			}
		} else {
			throw new NoSuchElementFoundByVendorException(
					"Vendor is not found for your email " + email + " to be login");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<VendorDto>>> listOfAvailabilityinState(String state) {
		List<Vendor>list=dao.listOfAvailabilityinState(state);
		ResponseStructure<List<VendorDto>> responseStructure = new ResponseStructure();
		if (list != null) {
			  List<VendorDto>dto=new ArrayList();
             for (Vendor vendor : list) {
            	VendorDto vendor2= config.vendorattributes(vendor);
            	dto.add(vendor2);
			}
			 

				responseStructure.setMessage("Sucessfully  found  list of vendor availabilty to the "+state);
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(dto);
				return new ResponseEntity<ResponseStructure<List<VendorDto>>>(responseStructure, HttpStatus.OK);
		}
		else
			throw new NoSuchListFoundForDistrictByVendorException("no such "+state+" found  for vendors");
		
	}
		

	public ResponseEntity<ResponseStructure<List<VendorDto>>> listOfAvailabilityInDistrict(String state,String district) {
		List<Vendor>list=dao.listOfAvailabilityInDistrict(state, district);
		ResponseStructure<List<VendorDto>> responseStructure = new ResponseStructure();
		if (list != null) {
			  List<VendorDto>dto=new ArrayList();
             for (Vendor vendor : list) {
            	VendorDto vendor2= config.vendorattributes(vendor);
            	dto.add(vendor2);
			}
			 

				responseStructure.setMessage("Sucessfully  found  list of vendor availabilty to the "+district);
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(dto);
				return new ResponseEntity<ResponseStructure<List<VendorDto>>>(responseStructure, HttpStatus.OK);
		}
		else
			throw new NoSuchListFoundForDistrictByVendorException("no such "+district+" found  for vendors");
		
	}
	
	public ResponseEntity<ResponseStructure<List<VendorDto>>> listOfAvailability(String role) {
		List<Vendor>list=dao.listOfVenderBasedOnAvailability( role);
		System.out.println(list);
		ResponseStructure<List<VendorDto>> responseStructure = new ResponseStructure();
		if (list!= null) {
			  List<VendorDto>dto=new ArrayList();
             for (Vendor vendor : list) {
            	VendorDto vendor2= config.vendorattributes(vendor);
            	dto.add(vendor2);
			}
			 

				responseStructure.setMessage("Sucessfully  found  list of vendor availabilty");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(dto);
				return new ResponseEntity<ResponseStructure<List<VendorDto>>>(responseStructure, HttpStatus.OK);
		}
		else
			throw new NoSuchListFoundForAvailabilityByVendorException("no availabity of vendors ");
		
	}
	
	
	
	

}
