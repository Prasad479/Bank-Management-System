package com.jsp.controller;

import com.jsp.service.AdminService;

public class BankManagerApprovedController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		
		//Enter the admin id for approve all bankManagers
		adminService.approvedBankManager(2);       
		
		
		//Enter the bankManager id and admin id for approve particular bankManager
		adminService.approvedBankManager(18,50);	  
	}
}
