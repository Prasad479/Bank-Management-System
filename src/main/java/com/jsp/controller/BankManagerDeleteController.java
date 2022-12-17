package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class BankManagerDeleteController {

	public static void main(String[] args) {
		BankManagerService banakManagerService= new BankManagerService();
		
		//Enter the bankManager id
		banakManagerService.deleteBankManager(12);
	}
}
