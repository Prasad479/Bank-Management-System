package com.jsp.service;

import java.util.List;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.BankAccountDto;
import com.jsp.dto.CustomerDto;
import com.jsp.dto.StatementDto;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();

	public CustomerDto saveCustomer(CustomerDto customer) {
		return customerDao.saveCustomer(customer);
	}

	public CustomerDto deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}

	public CustomerDto updateCustomerName(int id, String name) {
		return customerDao.updateCustomerName(id, name);
	}

	public CustomerDto updateCustomerGmail(int id, String gmail) {
		return customerDao.updateCustomerGmail(id, gmail);
	}

	public CustomerDto updateCustomerCno(int id, long cno) {
		return customerDao.updateCustomerCno(id, cno);
	}

	public CustomerDto getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	public List<CustomerDto> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	public BankAccountDto saveBankAccount(BankAccountDto bankAccount, int customerId) {
		return customerDao.saveBankAccount(bankAccount, customerId);
	}

	public BankAccountDto deleteBankAccount(int id) {
		return customerDao.deleteBankAccount(id);
	}

	public BankAccountDto getBankAccount(int id) {
		return customerDao.getBankAccount(id);
	}

	public List<BankAccountDto> getAllBankAccounts() {
		return customerDao.getAllBankAccounts();
	}
	
	public BankAccountDto depositAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.depositAmount(customerId, bankAccountId, amount);
	}

	public BankAccountDto creditAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.creditAmount(customerId, bankAccountId, amount);
	}

	public BankAccountDto transferAmount(int customerId, int creditorId, int depositorId, double amount) {
		return customerDao.transferAmount(customerId, creditorId, depositorId, amount);
	}
	
	public List<StatementDto> bankAccountStatement(int bankAccountId) {
		return customerDao.bankAccountStatement(bankAccountId);
	}
}
