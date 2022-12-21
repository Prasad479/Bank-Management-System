package com.jsp.controller;

import com.jsp.dao.CustomerDao;

public class GetAllBankAccountsController {
	public static void main(String[] args) {
		CustomerDao customerDao=new CustomerDao();
		customerDao.getAllBankAccounts();
	}
}
