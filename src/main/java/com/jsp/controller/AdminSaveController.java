package com.jsp.controller;

import com.jsp.dto.AdminDto;
import com.jsp.service.AdminService;

public class AdminSaveController {
	public static void main(String[] args) {
		AdminDto admin=new AdminDto();
		
		//Enter the admin name
		admin.setName("Prasad");
		
		//Enter the admin gmail
		admin.setGmail("prasad@gmail.com");
		
		//Enter the admin contact number
		admin.setCno(1234567890);
		
		AdminService adminService=new AdminService();

		AdminDto admin1=adminService.saveAdmin(admin);
		if(admin1!=null) {
			System.out.println("Admin saved successfully");
		}else {
			System.out.println("Admin not saved");
		}
	}
}
