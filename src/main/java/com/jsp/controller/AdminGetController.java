package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminGetController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		//Enter the admin id
		adminService.getAdmin(2);
	}
}
