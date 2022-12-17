package com.jsp.service;

import java.util.List;

import com.jsp.dao.AdminDao;
import com.jsp.dto.AdminDto;
import com.jsp.dto.BankManagerDto;

public class AdminService {
	AdminDao adminDao=new AdminDao();
	
	public AdminDto saveAdmin(AdminDto admin) {
		return adminDao.saveAdmin(admin);
	}
	
	public AdminDto deleteAdmin(int id) {
		return adminDao.deleteAdmin(id);
	}
	
	public AdminDto getAdmin(int id) {
		return adminDao.getAdmin(id);
	}
	
	public AdminDto updateAdminName(int id,String name) {
		return adminDao.updateAdminName(id, name);
	}
	
	public AdminDto updateAdminGmail(int id,String gmail) {
		return adminDao.updateAdminGmail(id, gmail);
	}
	
	public AdminDto updateAdminCno(int id,long cno) {
		return adminDao.updateAdminCno(id, cno);
	}
	
	public List<AdminDto> getAllAdmin() {
		return adminDao.getAllAdmin();
	}
	
	public List<BankManagerDto> approvedBankManager(int adminId){
		return adminDao.approvedBankManager(adminId);
	}
	public BankManagerDto approvedBankManager(int bankManagerId, int adminId) {
		return adminDao.approvedBankManger(bankManagerId, adminId);
	}
}
