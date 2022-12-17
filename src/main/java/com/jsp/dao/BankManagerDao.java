package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankManagerDto;
import com.jsp.dto.CustomerDto;

public class BankManagerDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("prasad");
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	//save bankManager
	public BankManagerDto saveBankManager(BankManagerDto BankManager) {
		//If anyone try to approved directly then also it will saved as unapproved automatically.
		BankManager.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(BankManager);
		entityTransaction.commit();
		return BankManager;
	}
	
	//delete bankManager
	public BankManagerDto deleteBankManager(int id) {
		BankManagerDto a=entityManager.find(BankManagerDto.class, id);
		if(a!=null) {
			entityTransaction.begin();
			entityManager.remove(a);
			entityTransaction.commit();
			System.out.println("BankManager deleted successfully");
		}else {
			System.out.println("BankManager not exist");
		}
		return a;
	}
	
	//update bankManager name
	public BankManagerDto updateBankManagerName(int id, String name) {
		BankManagerDto b=entityManager.find(BankManagerDto.class, id);
		b.setName(name);
		
		if(b!=null) {
			entityTransaction.begin();
			entityManager.merge(b);
			entityTransaction.commit();
			System.out.println("Updated successfully");
			}
			return b;
	}
	
	//update bankManager gmail
	public BankManagerDto updateBankManagerGmail(int id, String gmail) {
		BankManagerDto b=entityManager.find(BankManagerDto.class, id);
		b.setGmail(gmail);
		
		if(b!=null) {
			entityTransaction.begin();
			entityManager.merge(b);
			entityTransaction.commit();
			System.out.println("Updated successfully");
			}
			return b;
	}
	
	//update bankManager contact number
	public BankManagerDto updateBankManagerCno(int id, long cno) {
		BankManagerDto b=entityManager.find(BankManagerDto.class, id);
		b.setCno(cno);
		
		if(b!=null) {
			entityTransaction.begin();
			entityManager.merge(b);
			entityTransaction.commit();
			System.out.println("Updated successfully");
			}
			return b;
	}
	
	//get particular bankManager details
	public BankManagerDto getBankManager(int id) {
		BankManagerDto a=entityManager.find(BankManagerDto.class, id);
		if(a!=null) {
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getGmail());
			System.out.println(a.getCno());
			System.out.println(a.getStatus());
		}else {
			System.out.println("Object not found");
		}
		return a;
	}
	
	//get all bankManagers details
	public List<BankManagerDto> getAllBankManager() {
		String sql="Select m FROM BankManagerDto m";
		Query query=entityManager.createQuery(sql);
		
		List<BankManagerDto> BankManagers=query.getResultList();
		
		for(BankManagerDto a:BankManagers) {
			System.out.println("=====================");
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getGmail());
			System.out.println(a.getCno());
			System.out.println(a.getStatus());
		}
		return BankManagers;
	}
	
	//approve all customers
	public List<CustomerDto> approvedCustomers(int bankManagerId){
		String sql="Select c from CustomerDto c";
		Query query=entityManager.createQuery(sql);
		List<CustomerDto> customers=query.getResultList();
		
		BankManagerDto b=entityManager.find(BankManagerDto.class, bankManagerId);
		if(b.getStatus().equals("Approved")) {
		for(CustomerDto c:customers) {
			if(c.getStatus().equals("Unapproved")) {
				c.setStatus("Approved");
				c.setBankManager(b);
				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
			}
		}
		}else {
			System.out.println("BankManager is not Approved");
		}
		return customers;
	}
	
	//approve particular customer
	public CustomerDto approvedCustomer(int customerId, int bankManagerId) {
		CustomerDto c=entityManager.find(CustomerDto.class, customerId);
		BankManagerDto b=entityManager.find(BankManagerDto.class, bankManagerId);
		if(b.getStatus().equals("Approved")) {
		if(c.getStatus().equals("Unapproved")) {
			c.setStatus("Approved");
			c.setBankManager(b);
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
			System.out.println("Approved Successfully");
		}else {
			System.out.println("Customer already approved");
		}
		}else {
			System.out.println("Bankmanager is not Approved");
		}
		return c;
	}
}
