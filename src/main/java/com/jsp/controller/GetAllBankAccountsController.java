package com.jsp.controller;

import com.jsp.service.CustomerService;

public class GetAllBankAccountsController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		customerService.getAllBankAccounts();
	}
}
