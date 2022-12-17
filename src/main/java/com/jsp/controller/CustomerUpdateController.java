package com.jsp.controller;

import com.jsp.service.CustomerService;

public class CustomerUpdateController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//Enter the customerId and update field
		customerService.updateCustomerName(2, "manas");
		customerService.updateCustomerGmail(2, "manas@gmail.com");
		customerService.updateCustomerCno(1, 892806940);
	}
}
