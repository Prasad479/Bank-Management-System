package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class BankManagerGetAllController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		bankManagerService.getAllBankManager();
	}
}
