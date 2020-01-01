package com.anant.mv.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anant.mv.hibernate.dao.CustomerDAO;
import com.anant.mv.hibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}
	@Override
	@Transactional
	public Customer getCustomer(int theID) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theID);
		
	}
	@Override
	@Transactional
	public void delete(int theID) {
		// TODO Auto-generated method stub
		customerDAO.delete(theID);
		
	}
	@Override
	@Transactional
	public List<Customer> searchCustomer(String theSearchedName) {
		// TODO Auto-generated method stub
		return customerDAO.searchCustomer(theSearchedName);
	}
	
	

}
