package com.naveen.project.ribbonclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.project.ribbonclient.service.AccountService;



@RestController
public class AccountController {
	
	 @Autowired
	 AccountService accountService;
	

	 
	 @GetMapping("/accounts")
	 public String getAllAccounts() {
		 
		return accountService.getAccounts();
		
	 }
}
