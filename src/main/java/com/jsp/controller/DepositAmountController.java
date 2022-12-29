package com.jsp.controller;

import com.jsp.service.CustomerService;

public class DepositAmountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//Enter the customerId , bankAccountId and amount
		customerService.depositAmount(2, 5, 1000);
	}
}
