package com.jsp.controller;

import com.jsp.dto.BankAccountDto;
import com.jsp.service.CustomerService;

public class SaveBankAccountController {
	public static void main(String[] args) {
		BankAccountDto bankAccount=new BankAccountDto();
		
		//Enter the account number
		bankAccount.setAccount_no(123456789);
		
		//Enter the ifsc_code
		bankAccount.setIfsc_code("UNION1234");
		
		//Enter the amount
		bankAccount.setBalance(500);
		
		CustomerService customerService=new CustomerService();
		
		//Enter the bankAccount and customerId
		customerService.saveBankAccount(bankAccount,6);
	}
}
