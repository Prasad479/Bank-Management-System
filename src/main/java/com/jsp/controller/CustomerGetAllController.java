package com.jsp.controller;

import com.jsp.service.CustomerService;

public class CustomerGetAllController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		customerService.getAllCustomer();
	}
}
