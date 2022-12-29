package com.jsp.controller;

import com.jsp.service.CustomerService;

public class TransferAmountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//Enter the customerId, creditorId, depositorId and amount
		customerService.transferAmount(2, 5, 6, 1000);
	}
}	
