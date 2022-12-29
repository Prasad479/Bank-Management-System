package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class CustomerApprovedController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		
		//For approved all customers
		//Enter the bankManagerId
//		bankManagerService.approvedCustomers(4);
		
		//For approved particular customer
		//Enter the customerId and bankManagerId
		bankManagerService.approvedCustomer(6, 3);
	}
}
