package com.anant.mv.hibernate.dao;

import java.util.List;

import com.anant.mv.hibernate.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theID);

	public void delete(int theID);

	public List<Customer> searchCustomer(String theSearchedName);

}
