package com.jsp.controller;

import com.jsp.dao.CustomerDao;

public class GetBankAccountController {
	public static void main(String[] args) {
		CustomerDao customerDao=new CustomerDao();
		
		//Enter the bankAccountId
		customerDao.getBankAccount(5);
	}
}
