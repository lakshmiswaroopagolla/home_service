package com.ty.home_service.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.home_service.entity.Customer;
import com.ty.home_service.entity.Work;
import com.ty.home_service.repo.CustomerRepo;
import com.ty.home_service.util.AES_homeService;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo repo;
	
	

	public Customer saveCustomer(Customer customer) {
		customer.setPwd(AES_homeService.encrypt(customer.getPwd()));;
		return repo.save(customer);
	}

	public Customer updatecustomer(Customer customer, String id) {

		if (repo.findById(id).isPresent()) {
			Customer c = repo.findById(id).get();
			customer.setId(id);
             if(customer.getAddress()==null) {
            	 customer.setAddress(c.getAddress());
             }
            
             if(customer.getFamilycount()==0) {
            	 customer.setFamilycount(c.getFamilycount());
             }
           
			if(customer.getPwd()==null) {
				customer.setPwd(c.getPwd());
			}
			else
			{
				customer.setPwd(AES_homeService.encrypt(customer.getPwd()));;

			}
			List<Work> list = new ArrayList();

			if (c.getWorks() == null) {
				customer.setWorks(list);
			} else {
				list.addAll(c.getWorks());
				customer.setWorks(list);
			}

			
			
			repo.save(customer);
			return customer;
		}
		return null;
	}

	public Customer updateCustomerEmail(String email) {
		Customer customer = repo.findByEmail(email);
		System.out.println(customer);
		if (customer != null) {
			customer.setEmail(email);
			System.out.println(customer+"----==");

			return repo.save(customer);
		}
		return null;
	}

	public Customer updateCustomerPwd(String pwd,String id) {
		Customer customer = getCustomerByID(id);
		if (customer != null) {
			customer.setPwd(AES_homeService.encrypt(customer.getPwd()));
			return repo.save(customer);
		}
		return null;
	}

	public Customer deleteCustomer(String id) {
		Optional<Customer> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}

		else

		{
			return null;
		}
	}

	public Customer getCustomerByID(String id) {
		
		if (repo.findById(id).isPresent()) {
			
			Customer customer=repo.findById(id).get();
			customer.setPwd(AES_homeService.decrypt(customer.getPwd()));;
			
			return customer;
		}
		else
			return null;

	}

	public Customer getCustomerByEmail(String email) {
		Customer customer = repo.findByEmail(email);
		if(customer!=null) {
		customer.setPwd(AES_homeService.decrypt(customer.getPwd()));

		return customer;
		}
		else
			return null;
	}

}
