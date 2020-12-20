package com.kingdom.springdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kingdom.springdemo.dao.CustomerDAO;
import com.kingdom.springdemo.entity.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need inject the customer DAO
	@Autowired
	private CustomerDAO customerDao;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get the customer from DAO
		List<Customer> theCustomers = customerDao.getCustomers();
		
		//add the customers to the model 
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		 
		return "customer-form";
	}
	
	
}
