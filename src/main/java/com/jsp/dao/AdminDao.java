package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.AdminDto;
import com.jsp.dto.BankManagerDto;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prasad");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save admin
	public AdminDto saveAdmin(AdminDto admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

	// delete admin
	public AdminDto deleteAdmin(int id) {
		AdminDto a = entityManager.find(AdminDto.class, id);
		if (a != null) {
			entityTransaction.begin();
			entityManager.remove(a);
			entityTransaction.commit();
			System.out.println("Admin deleted successfully");
		} else {
			System.out.println("Admin not exist");
		}
		return a;
	}

	// get Admin
	public AdminDto getAdmin(int id) {
		AdminDto a = entityManager.find(AdminDto.class, id);
		if (a != null) {
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getGmail());
			System.out.println(a.getCno());
		} else {
			System.out.println("Object not found");
		}
		return a;
	}

	// get All Admin
	public List<AdminDto> getAllAdmin() {
		String sql = "Select m FROM AdminDto m";
		Query query = entityManager.createQuery(sql);

		List<AdminDto> admins = query.getResultList();

		for (AdminDto a : admins) {
			System.out.println("=====================");
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getGmail());
			System.out.println(a.getCno());
		}
		return admins;
	}

	// update Admin Name
	public AdminDto updateAdminName(int id, String name) {
		AdminDto a = entityManager.find(AdminDto.class, id);
		a.setName(name);

		if (a != null) {
			entityTransaction.begin();
			entityManager.merge(a);
			entityTransaction.commit();
			System.out.println("Updated successfully");
		}
		return a;
	}

	// update Admin Gmail
	public AdminDto updateAdminGmail(int id, String gmail) {
		AdminDto a = entityManager.find(AdminDto.class, id);
		a.setGmail(gmail);

		if (a != null) {
			entityTransaction.begin();
			entityManager.merge(a);
			entityTransaction.commit();
			System.out.println("Updated successfully");
		}
		return a;
	}

	// update Admin Cno
	public AdminDto updateAdminCno(int id, long cno) {
		AdminDto a = entityManager.find(AdminDto.class, id);
		a.setCno(cno);

		if (a != null) {
			entityTransaction.begin();
			entityManager.merge(a);
			entityTransaction.commit();
			System.out.println("Updated successfully");
		}
		return a;
	}

	// approved all Managers
	public List<BankManagerDto> approvedBankManager(int adminId) {
		String sql = "select m from BankManagerDto m";
		Query query = entityManager.createQuery(sql);
		List<BankManagerDto> managers = query.getResultList();

		AdminDto a=entityManager.find(AdminDto.class, adminId);
		if(a!=null) {
		for (BankManagerDto m : managers) {
			if (m.getStatus().equals("Unapproved")) {
				m.setStatus("Approved");         
				m.setAdmin(a);							
				entityTransaction.begin();
				entityManager.merge(m);
				entityTransaction.commit();
			}
		}
		}else {
			System.out.println("Admin not exist");
		}
		return managers;
	}

	// approved particular Manager
	public BankManagerDto approvedBankManger(int bankManagerId, int adminId) {
		BankManagerDto b = entityManager.find(BankManagerDto.class, bankManagerId);
		AdminDto a=entityManager.find(AdminDto.class, adminId);
		if(a!=null) {
			if (b.getStatus().equals("Unapproved")) {
			b.setStatus("Approved");
			b.setAdmin(a);
			entityTransaction.begin();
			entityManager.merge(b);
			entityTransaction.commit();
			System.out.println("Approved Successfully");
			} else {
				System.out.println("BankManager already approved");
			}
		}
		else {
			System.out.println("Admin not exist");
		}
		return b;
	}
}
