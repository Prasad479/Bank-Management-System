package com.jsp.controller;

import com.jsp.service.CustomerService;

public class CustomerDeleteController {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		
		//Enter the customerId
		customerService.deleteCustomer(3);
	}
}
