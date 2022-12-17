package com.jsp.controller;

import com.jsp.dao.CustomerDao;

public class GetCustomersBankAccountsController {
	public static void main(String[] args) {
		CustomerDao customerDao=new CustomerDao();
		
		//Enter the customerId
		customerDao.getCustomersBankAccounts(1);
	}
}
