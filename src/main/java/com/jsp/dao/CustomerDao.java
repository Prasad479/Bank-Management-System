package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankAccountDto;
import com.jsp.dto.BankManagerDto;
import com.jsp.dto.CustomerDto;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prasad");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	//save customer
	public CustomerDto saveCustomer(CustomerDto customer, int bankManagerId) {
		BankManagerDto b = entityManager.find(BankManagerDto.class, bankManagerId);
		if(b!=null) {
		if (b.getStatus().equals("Approved")) {
			customer.setStatus("Unapproved");
			entityTransaction.begin();
			entityManager.persist(customer);
			entityTransaction.commit();
			System.out.println("Customer saved successfully");
		} else {
			System.out.println("BankManager is not Approved");
		}
		}else {
			System.out.println("BankManager not exist");
		}
		return customer;
	}

	//delete customer
	public CustomerDto deleteCustomer(int id) {
		CustomerDto c = entityManager.find(CustomerDto.class, id);
		if (c != null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			System.out.println("Customer deleted successfully");
		} else {
			System.out.println("Customer not exist");
		}
		return c;
	}

	//update customer name
	public CustomerDto updateCustomerName(int id, String name) {
		CustomerDto c = entityManager.find(CustomerDto.class, id);
		c.setName(name);
		if (c != null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
	}

	//update customer gmail
	public CustomerDto updateCustomerGmail(int id, String Gmail) {
		CustomerDto c = entityManager.find(CustomerDto.class, id);
		c.setGmail(Gmail);
		if (c != null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
	}

	//update customer contact number
	public CustomerDto updateCustomerCno(int id, long cno) {
		CustomerDto c = entityManager.find(CustomerDto.class, id);
		c.setCno(cno);
		if (c != null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
	}

	//get particular customer details
	public CustomerDto getCustomer(int id) {
		CustomerDto c = entityManager.find(CustomerDto.class, id);
		if (c != null) {
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getGmail());
			System.out.println(c.getCno());
			System.out.println(c.getStatus());
		} else {
			System.out.println("Customer not exist");
		}
		return c;
	}

	//get all customers details
	public List<CustomerDto> getAllCustomer() {
		String sql = "Select c from CustomerDto c";
		Query query = entityManager.createQuery(sql);
		List<CustomerDto> customers = query.getResultList();

		for (CustomerDto c : customers) {
			System.out.println("====================");
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getGmail());
			System.out.println(c.getCno());
			System.out.println(c.getStatus());
		}
		return customers;
	}

	//save bankAccount
	public BankAccountDto saveBankAccount(BankAccountDto bankAccount, int customerId) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		if (c.getStatus().equals("Approved")) {
			bankAccount.setCustomer(c);
			entityTransaction.begin();
			entityManager.persist(bankAccount);
			entityTransaction.commit();
			System.out.println("BankAccount added Successfully");
		} else {
			System.out.println("Customer is not Approved");
		}
		return bankAccount;
	}

	//delete bankAccount
	public BankAccountDto deleteBankAccount(int id) {
		BankAccountDto b = entityManager.find(BankAccountDto.class, id);
		if (b != null) {
			entityTransaction.begin();
			entityManager.remove(b);
			entityTransaction.commit();
			System.out.println("BankAccount deleted successfully");
		} else {
			System.out.println("BankAccount not exist");
		}
		return b;
	}

	//get particular bankAccount details
	public BankAccountDto getBankAccount(int id) {
		BankAccountDto b = entityManager.find(BankAccountDto.class, id);
		if (b != null) {
			System.out.println(b.getId());
			System.out.println(b.getAccount_no());
			System.out.println(b.getIfsc_code());
			System.out.println(b.getBalance());
		} else {
			System.out.println("BankAccount not exist");
		}
		return b;
	}

	//get all bankAccounts details
	public List<BankAccountDto> getAllBankAccounts() {
		String sql = "select b from BankAccountDto b";
		Query query = entityManager.createQuery(sql);
		List<BankAccountDto> bankAccounts = query.getResultList();

		for (BankAccountDto b : bankAccounts) {
			System.out.println("=================");
			System.out.println(b.getId());
			System.out.println(b.getAccount_no());
			System.out.println(b.getIfsc_code());
			System.out.println(b.getBalance());
		}
		return bankAccounts;
	}

	//deposit amount
	public BankAccountDto depositAmount(int customerId, int bankAccountId, double amount) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		BankAccountDto b = entityManager.find(BankAccountDto.class, bankAccountId);
		if (c.getStatus().equals("Approved")) {
			if (amount > 0) {
				b.setBalance(b.getBalance() + amount);
				entityTransaction.begin();
				entityManager.merge(b);
				entityTransaction.commit();
				System.out.println("Amount deposited successfully");
			} else {
				System.out.println("Invalid amount");
			}
		} else {
			System.out.println("Customer is not approved");
		}
		return b;
	}

	//credit amount
	public BankAccountDto creditAmount(int customerId, int bankAccountId, double amount) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		BankAccountDto b = entityManager.find(BankAccountDto.class, bankAccountId);
		if (c.getStatus().equals("Approved")) {
			if (b.getCustomer().getId() == customerId) {
				if(amount < b.getBalance() && amount > 0 ) {
				b.setBalance(b.getBalance() - amount);
				entityTransaction.begin();
				entityManager.merge(b);
				entityTransaction.commit();
				System.out.println("Amount credited successfully");
				}else {
					System.out.println("Invalid amount");
				}
			} else {
				System.out.println("This is not your bankAccount");
			}
		} else {
			System.out.println("Customer is not approved");
		}
		return b;
	}

	//transfer amount
	public BankAccountDto transferAmount(int customerId, int creditorId, int depositorId, double amount) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		BankAccountDto b1 = entityManager.find(BankAccountDto.class, creditorId);
		BankAccountDto b2 = entityManager.find(BankAccountDto.class, depositorId);
		if (c.getStatus().equals("Approved")) {
			if (b1.getCustomer().getId() == customerId) {
				if(amount > 0 && b1.getBalance() > amount ) {
				b2.setBalance(b2.getBalance() + amount);
				b1.setBalance(b1.getBalance() - amount);
				entityTransaction.begin();
				entityManager.merge(b1);
				entityManager.merge(b2);
				entityTransaction.commit();
				System.out.println("Amount transfer successfully");
				}else {
					System.out.println("Invalid amount");
				}
			} else {
				System.out.println("This is not your bankAccount");
			}
		} else {
			System.out.println("Customer is not approved");
		}
		return b1;
	}

	//get particular customer bankAccounts
	public List<BankAccountDto> getCustomersBankAccounts(int customerId) {
		String sql = "select b from BankAccountDto b";
		Query query = entityManager.createQuery(sql);
		List<BankAccountDto> bankAccounts = query.getResultList();

		for (BankAccountDto b : bankAccounts) {
			if (b.getCustomer().getId() == customerId) {
				System.out.println("=================");
				System.out.println(b.getId());
				System.out.println(b.getAccount_no());
				System.out.println(b.getIfsc_code());
				System.out.println(b.getBalance());
			} else {
				System.out.println("You not have BankAccounts");
				break;
			}
		}
		return bankAccounts;
	}
}
