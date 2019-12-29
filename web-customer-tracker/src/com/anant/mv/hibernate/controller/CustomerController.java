package com.anant.mv.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anant.mv.hibernate.dao.CustomerDAO;
import com.anant.mv.hibernate.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	@RequestMapping("/showCustomer")
	public String customerList(Model theModel) {
		
		//get the customers from dao
		List<Customer> customersList=customerDAO.getCustomers();
		
		//add them in the model attribute
		theModel.addAttribute("customers",customersList);
		
		return "customer-list";
	}
}
