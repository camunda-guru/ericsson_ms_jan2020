package com.ericsson.customerserviceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.customerserviceapp.models.Customer;
import com.ericsson.customerserviceapp.services.CustomerService;

@RestController
public class CustomerController {
    @Autowired
	private CustomerService customerService;
	@CrossOrigin("*")
    @PostMapping("/addcustomer")
    public @ResponseBody Customer addCustomer(@RequestBody Customer customer)
    {
    	return customerService.saveCustomer(customer);
    }
	@CrossOrigin("*")
    @GetMapping("/getallcustomers")
    public List<Customer> getAllCustomers()
    {
    	return customerService.findAllCustomers();
    }
	
	@CrossOrigin("*")
    @GetMapping("/getcustomerbyid")
    public Customer getCustomerById(@PathVariable("adharCardNo") long adharCardNo)
    {
    	return customerService.findByCustomerId(adharCardNo);
    }
    
	
}
