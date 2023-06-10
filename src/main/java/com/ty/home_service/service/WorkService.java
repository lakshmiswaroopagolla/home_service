package com.ty.home_service.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.home_service.dao.AddressDao;
import com.ty.home_service.dao.CustomerDao;
import com.ty.home_service.dao.VendorDao;
import com.ty.home_service.dao.WorkDao;
import com.ty.home_service.dto.DtoConfig;
import com.ty.home_service.dto.WorkDto;
import com.ty.home_service.entity.Address;
import com.ty.home_service.entity.Customer;
import com.ty.home_service.entity.Vendor;
import com.ty.home_service.entity.Work;
import com.ty.home_service.exception.IdNotFoundByAddressException;
import com.ty.home_service.exception.IdNotFoundByCustomerException;
import com.ty.home_service.exception.IdNotFoundByWorkException;
import com.ty.home_service.exception.NoSuchElementFoundByAddressException;
import com.ty.home_service.util.ResponseStructure;

@Service
public class WorkService {

	@Autowired
	private WorkDao dao;

	
	@Autowired
	private CustomerDao cdao;

	@Autowired
	private DtoConfig dto;
	

	public ResponseEntity<ResponseStructure<WorkDto>> saveWork(Work work, String id) {
		
		
		Customer customer=cdao.getCustomerByID(id);
		if (customer != null) {
			System.out.println(customer);
			List<Work>list=new ArrayList();
			java.sql.Date date= new java.sql.Date(new Date().getTime());
			work.setStartDate(date);
			
			list.add(work);
			list.addAll(customer.getWorks());
			customer.setWorks(list);
			Work dbwork=dao.saveWork(work);
			cdao.updatecustomer(customer, id);
			ResponseStructure<WorkDto> responseStructure = new ResponseStructure();
			responseStructure.setMessage("Work Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dto.workattributes(dbwork));
			return new ResponseEntity<ResponseStructure<WorkDto>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByCustomerException("Pls check the address  linked id " + id + " is not exist to save");
		}

	}

	public ResponseEntity<ResponseStructure<WorkDto>> updateWork(String id, Work work) {
		Work workdb= dao.getById(id);
		ResponseStructure<WorkDto> responseStructure = new ResponseStructure();
		if (workdb != null) {
			java.sql.Date date= new java.sql.Date(new Date().getTime());
			work.setEndDate(date);
			work.setStartDate(workdb.getStartDate());
			if(work.getType()==null) {
				work.setType(workdb.getType());
			}
			List<Vendor>vendor=new ArrayList();
            vendor.addAll(work.getVendor());
			vendor.addAll(workdb.getVendor());
			work.setVendor(vendor);
			

			responseStructure.setMessage("Sucessfully Work is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dto.workattributes(dao.updateWork(id, work)));
			return new ResponseEntity<ResponseStructure<WorkDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByWorkException("Pls check the work id " + id + " is not exist to update");
		}
	}

	public ResponseEntity<ResponseStructure<WorkDto>> deleteWork(String id) {
		Work workdb= dao.getById(id);
		ResponseStructure<WorkDto> responseStructure = new ResponseStructure();
		if (workdb != null) {

			responseStructure.setMessage("Sucessfully Address is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dto.workattributes(dao.deleteWork(id)));
			return new ResponseEntity<ResponseStructure<WorkDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByWorkException("Pls check the work id " + id + " is not exist to delete");
		}
	}

	public ResponseEntity<ResponseStructure<WorkDto>> getById(String id) {
		Work workdb= dao.getById(id);
		ResponseStructure<WorkDto> responseStructure = new ResponseStructure();
		if (workdb != null) {

			responseStructure.setMessage("Sucessfully work  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dto.workattributes(workdb));
			return new ResponseEntity<ResponseStructure<WorkDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByWorkException("Pls check the work id " + id + " is not exist to display");
		}

	}

}
