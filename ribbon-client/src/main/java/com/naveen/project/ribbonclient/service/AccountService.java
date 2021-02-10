package com.naveen.project.ribbonclient.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.project.ribbonclient.proxy.AccountProxy;



@Service
public class AccountService {
	
	@Autowired
	AccountProxy accountProxy;
	
	public String getAccounts(){
		
		return accountProxy.getAllAccounts();
		
	}
}
