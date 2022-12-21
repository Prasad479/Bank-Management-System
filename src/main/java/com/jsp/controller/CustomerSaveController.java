package com.jsp.controller;

import com.jsp.dto.CustomerDto;
import com.jsp.service.CustomerService;

public class CustomerSaveController {
	public static void main(String[] args) {
		CustomerDto customer =new CustomerDto();
		
		//If anyone try to approved directly then also it will saved as unapproved automatically.
		customer.setStatus("Approved");
		
		//Enter the customer name
		customer.setName("Prasad");
		
		//Enter the customer gmail
		customer.setGmail("prasad@gmail.com");
		
		//Enter the customer contact number
		customer.setCno(1234567890);
		
		//Enter the aadhar card number
		customer.setAddharCardNo(297978920041l);

		CustomerService customerService =new CustomerService();
		
		customerService.saveCustomer(customer);
	}
}
