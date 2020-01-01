package com.anant.mv.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anant.mv.hibernate.entity.Customer;
import com.anant.mv.hibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@RequestMapping("/showCustomer")
	public String customerList(Model theModel) {
		
		//get the customers from dao
		List<Customer> customersList=customerService.getCustomers();
		
		//add them in the model attribute
		theModel.addAttribute("customers",customersList);
		
		return "customer-list";
	}
	
	@GetMapping("/showFormForAdd")
		public String showCustomerForm(Model theModel) {
			
			Customer theCustomer=new Customer();
			
			theModel.addAttribute("customer",theCustomer);
		
			return "addCustomer-form";
		}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/showCustomer";
	}
	
	@GetMapping("/getTheCustomer")
	public String showUpdateCustomerPage(@RequestParam("customerID") int theID,Model theModel) {
		
		Customer theCustomer=customerService.getCustomer(theID);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "addCustomer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerID")int theID,Model theModel) {
		
		customerService.delete(theID);
		
		//theModel.addAttribute("customer", theCustomer);
		
		return "redirect:/customer/showCustomer";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchedName,Model themodel) {
		
		List<Customer> theCustomers=customerService.searchCustomer("theSearchedName");
		
		themodel.addAttribute("customer", theCustomers);
		
		return "customer-list";
		
	}
	}
	

