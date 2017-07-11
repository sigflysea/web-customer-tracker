package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired 
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel){
		//get customer from the service
		List <Customer> theCustomers = customerService.getCustomers();
		
		//Add theCustomers to the model using attribute name"customers"
		theModel.addAttribute("customers", theCustomers);
		
		//add the customers to the model
		
		return "list-customer";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
}
