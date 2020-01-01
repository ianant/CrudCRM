package com.anant.mv.hibernate.service;

import java.util.List;

import com.anant.mv.hibernate.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theID);
}
