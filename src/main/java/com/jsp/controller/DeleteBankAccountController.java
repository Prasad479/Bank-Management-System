package com.jsp.controller;

import com.jsp.service.CustomerService;

public class DeleteBankAccountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//Enter the bankAccountId
		customerService.deleteBankAccount(1);
	}
}
