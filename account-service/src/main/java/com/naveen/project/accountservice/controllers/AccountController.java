package com.naveen.project.accountservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.project.accountservice.services.AccountService;

@RestController
public class AccountController {
	
	 @Autowired
	 AccountService accountService;
	
	 @Value("${server.port}")
	 private String port;
	 
	 @GetMapping("/accounts")
	 public String getAllAccounts() {
		 
		return "Response from port (Account-Service) "+ port+ ":"+ "\r\n" +  accountService.getAccounts().toString();
		
	 }
}
