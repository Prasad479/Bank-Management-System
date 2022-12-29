package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankAccountDto;
import com.jsp.dto.CustomerDto;
import com.jsp.dto.StatementDto;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prasad");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	StatementDto statement = new StatementDto();

	// save customer
	public CustomerDto saveCustomer(CustomerDto customer) {
		String sql = "Select c from CustomerDto c";
		Query query = entityManager.createQuery(sql);
		List<CustomerDto> customers = query.getResultList();
		for (CustomerDto c : customers) {
			if (c.getAddharCardNo() == customer.getAddharCardNo()) {
				System.out.println("Customer already exist");
				return null;
			}
		}
		customer.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		System.out.println("Customer saved successfully");
		return customer;
	}

	// delete customer
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

	// update customer name
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

	// update customer gmail
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

	// update customer contact number
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

	// get particular customer details
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

	// get all customers details
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

	// save bankAccount
	public BankAccountDto saveBankAccount(BankAccountDto bankAccount, int customerId) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		bankAccount.setCustomer(c);
		bankAccount.setAccount_no(147949000 + customerId); // For unique account number

		String sql = "Select b from BankAccountDto b";
		Query query = entityManager.createQuery(sql);
		List<BankAccountDto> bankAccountDto = query.getResultList();
		for (BankAccountDto b : bankAccountDto) {
			if (b.getAccount_no() == bankAccount.getAccount_no()) {
				System.out.println("BankAccount already exist for this customer");
				return null;
			}
		}
		if (c.getStatus().equals("Approved")) {
			if (bankAccount.getBalance() > 499) {
				entityTransaction.begin();
				entityManager.persist(bankAccount);
				entityTransaction.commit();
				System.out.println("BankAccount added Successfully");
			}else {
				System.out.println("Minimum 500 should be deposit for create bankAccount");
			}
		} else {
			System.out.println("Customer is not Approved");
		}
		return bankAccount;
	}

	// delete bankAccount
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

	// get particular bankAccount details
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

	// get all bankAccounts details
	public List<BankAccountDto> getAllBankAccounts() {
		String sql = "Select b from BankAccountDto b";
		Query query = entityManager.createQuery(sql);
		List<BankAccountDto> bankAccountDto = query.getResultList();
		for (BankAccountDto b : bankAccountDto) {
			System.out.println("=====================");
			System.out.println(b.getId());
			System.out.println(b.getAccount_no());
			System.out.println(b.getIfsc_code());
			System.out.println(b.getBalance());
		}
		return bankAccountDto;
	}

	// deposit amount
	public BankAccountDto depositAmount(int customerId, int bankAccountId, double amount) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		BankAccountDto b = entityManager.find(BankAccountDto.class, bankAccountId);
		if (c.getStatus().equals("Approved")) {
			if (amount > 0) {
				b.setBalance(b.getBalance() + amount);
				statement.setBid(bankAccountId);
				statement.setDetails("Deposited : Rs." + amount + " to your Account no:" + b.getAccount_no());

				entityTransaction.begin();
				entityManager.merge(b);
				entityManager.persist(statement);
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

	// credit amount
	public BankAccountDto creditAmount(int customerId, int bankAccountId, double amount) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		BankAccountDto b = entityManager.find(BankAccountDto.class, bankAccountId);
		if (c.getStatus().equals("Approved")) {
			if (b.getCustomer().getId() == customerId) {
				if (amount < b.getBalance() && amount > 0) {
					b.setBalance(b.getBalance() - amount);
					statement.setBid(bankAccountId);
					statement.setDetails("Credited : Rs." + amount + " from your Account no:" + b.getAccount_no());

					entityTransaction.begin();
					entityManager.merge(b);
					entityManager.persist(statement);
					entityTransaction.commit();
					System.out.println("Amount credited successfully");
				} else {
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

	// transfer amount
	public BankAccountDto transferAmount(int customerId, int creditorId, int depositorId, double amount) {
		CustomerDto c = entityManager.find(CustomerDto.class, customerId);
		BankAccountDto b1 = entityManager.find(BankAccountDto.class, creditorId);
		BankAccountDto b2 = entityManager.find(BankAccountDto.class, depositorId);
		if (c.getStatus().equals("Approved")) {
			if (b1.getCustomer().getId() == customerId) {
				if (amount > 0 && b1.getBalance() > amount) {
					b1.setBalance(b1.getBalance() - amount);
					statement.setBid(creditorId);
					statement.setDetails("Credited  : Rs." + amount + " from your Account no:" + b1.getAccount_no());

					b2.setBalance(b2.getBalance() + amount);
					StatementDto statement1 = new StatementDto();
					statement1.setBid(depositorId);
					statement1.setDetails("Deposited : Rs." + amount + " by Account no :" + b1.getAccount_no());

					entityTransaction.begin();
					entityManager.merge(b1);
					entityManager.merge(b2);
					entityManager.persist(statement);
					entityManager.persist(statement1);
					entityTransaction.commit();
					System.out.println("Amount transfer successfully");
				} else {
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

	// statement of bankAccounts
	public List<StatementDto> bankAccountStatement(int bankAccountId) {
		String sql = "Select s from StatementDto s";
		Query query = entityManager.createQuery(sql);

		List<StatementDto> s = query.getResultList();
		System.out.println("Statement of BankAccount Id : "+bankAccountId);
		for (StatementDto res : s) {
			if (bankAccountId == res.getBid()) {
				System.out.println(res.getDetails());
			}
		}
		return s;
	}
}
