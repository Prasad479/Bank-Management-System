package com.jsp.controller;

import com.jsp.service.CustomerService;

public class CreditAmountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//Enter the customerId , bankAccountId and amount
		customerService.creditAmount(2, 5, 1000);
	}
}
