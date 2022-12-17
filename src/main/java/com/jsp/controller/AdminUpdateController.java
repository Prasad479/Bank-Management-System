package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminUpdateController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		
		//Enter the admin id and update field
		adminService.updateAdminName(2, "Prasad");
		adminService.updateAdminGmail(5, "Pradeep@gmail.com");
		adminService.updateAdminCno(3, 1234567);
	}
}