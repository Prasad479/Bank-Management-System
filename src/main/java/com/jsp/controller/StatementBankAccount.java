package com.jsp.controller;

import com.jsp.service.CustomerService;

public class StatementBankAccount {
	public static void main(String[] args) {
		CustomerService statement = new CustomerService();
		// Enter BankAccount Id
		statement.bankAccountStatement(5);
	}
}
