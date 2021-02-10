package com.naveen.project.accountservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.project.accountservice.models.AccountEntity;
import com.naveen.project.accountservice.repositories.AccountRepo;



@Service
public class AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	public List<AccountEntity> getAccounts(){
		
		return accountRepo.findAll();
		
	}
}
