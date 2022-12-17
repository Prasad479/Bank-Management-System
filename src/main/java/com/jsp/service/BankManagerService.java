package com.jsp.service;

import java.util.List;

import com.jsp.dao.BankManagerDao;
import com.jsp.dto.BankManagerDto;
import com.jsp.dto.CustomerDto;

public class BankManagerService {

	BankManagerDao bankManagerDao = new BankManagerDao();

	public BankManagerDto saveBankManager(BankManagerDto admin) {
		return bankManagerDao.saveBankManager(admin);
	}

	public BankManagerDto deleteBankManager(int id) {
		return bankManagerDao.deleteBankManager(id);
	}

	public BankManagerDto updateBankManagerName(int id, String name) {
		return bankManagerDao.updateBankManagerName(id, name);
	}

	public BankManagerDto updateBankManagerGmail(int id, String gmail) {
		return bankManagerDao.updateBankManagerGmail(id, gmail);
	}

	public BankManagerDto updateBankManagerCno(int id, long cno) {
		return bankManagerDao.updateBankManagerCno(id, cno);
	}

	public BankManagerDto getBankManager(int id) {
		return bankManagerDao.getBankManager(id);
	}

	public List<BankManagerDto> getAllBankManager() {
		return bankManagerDao.getAllBankManager();
	}
	
	public List<CustomerDto> approvedCustomers(int bankManagerId){
		return bankManagerDao.approvedCustomers(bankManagerId);
	}
	
	public CustomerDto approvedCustomer(int customerId, int bankManagerId){
		return bankManagerDao.approvedCustomer(customerId,bankManagerId);
	}
}
