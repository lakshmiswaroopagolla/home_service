package com.ty.home_service.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.home_service.dao.ServiceCostDao;
import com.ty.home_service.dao.VendorDao;
import com.ty.home_service.dao.WorkDao;
import com.ty.home_service.entity.ServiceCost;
import com.ty.home_service.entity.Vendor;
import com.ty.home_service.entity.Work;
import com.ty.home_service.exception.IdNotFoundByCustomerException;
import com.ty.home_service.exception.IdNotFoundByVendorException;
import com.ty.home_service.exception.IdNotFoundByWorkException;
import com.ty.home_service.util.ResponseStructure;

@Service
public class ServiceCostService {

	@Autowired
	private ServiceCostDao dao;
	
	@Autowired
	private WorkDao wdao;
	
	@Autowired
	private VendorDao vdao;

	
	
	

	public ResponseEntity<ResponseStructure<ServiceCost>> saveServiceCost( String W_id,String V_id,ServiceCost cost) {
        Work work=wdao.getById(W_id);
        
		if(work!=null) {
			  
			Vendor vendor=vdao.getVendorByID(V_id);
			if(vendor!=null) {
				double perpay=vendor.getCostperday();
				cost.setTotalamount(perpay*cost.getDays());
				work.setCost(cost);
				List<Vendor>vendor2=new ArrayList();
				vendor2.addAll(work.getVendor());
				vendor2.add(vendor);
				work.setVendor(vendor2);
				List<ServiceCost>costs=vendor.getCost();
				costs.add(cost);
				java.sql.Date date= new java.sql.Date(new Date().getTime());
				work.setEndDate(date);
				//cost.setWork(work);
				

			
		   
			ResponseStructure<ServiceCost> responseStructure = new ResponseStructure();
			responseStructure.setMessage("ServiceCost Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveServiceCost(cost));
			vendor.setCost(costs);
			wdao.updateWork(W_id, work);
			vdao.updateVendor(vendor, V_id);
			return new ResponseEntity<ResponseStructure<ServiceCost>>(responseStructure, HttpStatus.CREATED);
			}
			else
			{
				throw new IdNotFoundByVendorException("pls check the vendor id "+V_id+"is not exist to save the payment");
			}
		} else {
			throw new IdNotFoundByWorkException("Pls check the Work id " + W_id + " is not exist to save tha payment");
		}

	}



	public ResponseEntity<ResponseStructure<List<ServiceCost>>> getServiceCostListByVendorId(String id) {
		Vendor vendor=vdao.getVendorByID(id);
		ResponseStructure<List<ServiceCost>> responseStructure = new ResponseStructure();
		if (vendor != null) {
           List<ServiceCost>list=vendor.getCost();
           
			responseStructure.setMessage("Sucessfully Vendor  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(list);
			return new ResponseEntity<ResponseStructure<List<ServiceCost>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByVendorException("Pls check the Vendor id " + id + " is not exist to display the service cost list");
		}

	}

}
