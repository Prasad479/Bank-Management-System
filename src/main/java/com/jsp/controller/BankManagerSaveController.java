package com.jsp.controller;

import com.jsp.dto.BankManagerDto;
import com.jsp.service.BankManagerService;

public class BankManagerSaveController {
	public static void main(String[] args) {
		BankManagerDto bankManager = new BankManagerDto();
		
		//If anyone try to approved directly then also it will saved as unapproved automatically.
		bankManager.setStatus("Approved");		
		
		//Enter the bankManager name
		bankManager.setName("Prasad");
		
		//Enter the bankManager gmail
		bankManager.setGmail("prasad@gmail.com");
		
		//Enter the bankManager contact number
		bankManager.setCno(1234567890);

		BankManagerService bankManagerService = new BankManagerService();
		BankManagerDto bankManager1 = bankManagerService.saveBankManager(bankManager);
		if(bankManager1!=null) {
			System.out.println("BankManager saved successfully");
		}else {
			System.out.println("BankManager not saved");
		}
	}
}
