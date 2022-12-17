package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class BankManagerGetController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		
		//Enter the bankManager id
		bankManagerService.getBankManager(5);
	}
}
