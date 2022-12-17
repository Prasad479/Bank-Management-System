package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class BankManagerUpdateController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		
		//Enter the bankManager id and update field
		bankManagerService.updateBankManagerName(3, "Nilesh");
		bankManagerService.updateBankManagerGmail(3, "Nilesh@gmail.com");
		bankManagerService.updateBankManagerCno(4, 12345678);
	}
}
