package com.jsp.controller;

import com.jsp.service.CustomerService;

public class TransferAmountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//Enter the customerId, creditorId, depositorId and amount
		customerService.transferAmount(1, 1, 2, 500);
	}
}	
