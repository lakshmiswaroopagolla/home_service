package com.ty.home_service.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.home_service.dao.AddressDao;
import com.ty.home_service.dao.CustomerDao;
import com.ty.home_service.dao.VendorDao;
import com.ty.home_service.dao.WorkDao;
import com.ty.home_service.entity.Address;
import com.ty.home_service.entity.Customer;
import com.ty.home_service.entity.Vendor;
import com.ty.home_service.entity.Work;
import com.ty.home_service.exception.IdNotFoundByAddressException;
import com.ty.home_service.exception.NoSuchElementFoundByAddressException;
import com.ty.home_service.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private VendorDao dao;
	@Autowired
	private CustomerDao cdao;
	@Autowired
	private WorkDao wdao;

	public Address save(Address address, String id) {
		String vendorid = "vendor";
		String customerId="Cus_";
		String work_id="work_";
		if (id.substring(0, 4).equals(vendorid.substring(0, 4))) {
			Vendor vendor = dao.getVendorByID(id);

			if (vendor != null) {
				
				vendor.setAddress(address);
				return dao.updateVendor(vendor, id).getAddress();

			}
		}
		else if (id.substring(0, 4).equals(customerId.substring(0, 4))) {
			Customer  customer=cdao.getCustomerByID(id);
			if (customer != null) {

				customer.setAddress(address);
				return cdao.updatecustomer(customer, id).getAddress();

			}
		}
		
		else if (id.substring(0, 4).equals(work_id.substring(0, 4))) {
			Work work=wdao.getById(id);
			if (work != null) {
				
				work.setAddress(address);
				return wdao.updateWork(id, work).getAddress();

			}
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address, String id) {
		Address address1 = save(address, id);
		if (address1 != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setMessage("Address Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(address1);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundByAddressException("Pls check the address  linked id " + id + " is not exist to save");
		}

	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(String id, Address address) {
		Address addressdb = addressDao.updateAddress(id, address);
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		if (addressdb != null) {

			responseStructure.setMessage("Sucessfully Address is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByAddressException("Pls check the address id " + id + " is not exist to update");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(String id) {
		Address addressdb = addressDao.deleteAddress(id);
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		if (addressdb != null) {

			responseStructure.setMessage("Sucessfully Address is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(addressdb);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByAddressException("Pls check the address id " + id + " is not exist to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> getById(String id) {
		Address addressdb = addressDao.getById(id);
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		if (addressdb != null) {

			responseStructure.setMessage("Sucessfully Address  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(addressdb);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByAddressException(
					"Pls check the address id " + id + " is not exist to display");
		}

	}

}
