package com.naveen.project.accountservice.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.project.accountservice.errorhandler.AccountServiceException;
import com.naveen.project.accountservice.models.AccountEntity;
import com.naveen.project.accountservice.repositories.AccountRepo;
import com.naveen.project.accountservice.util.MessageConstants;



@Service
public class AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	public List<AccountEntity> getAccounts() throws AccountServiceException{
		
		System.out.println("***************in Account Service******************");
		List<AccountEntity> accounts = null;
		try {
			
			
			accounts = accountRepo.findAll();
			
		} catch (Exception ex) {
			
			List<String> errors = new ArrayList<>();
			
		
			
			System.out.println("***************Account Service Exception******************");
			
			 Throwable rootCause = com.google.common.base.Throwables.getRootCause(ex);
			 
	            
			 if (rootCause instanceof SQLException) {
	                
				 if ("42P01".equals(((SQLException) rootCause).getSQLState())) {
	                	
					 errors.add(((SQLException) rootCause).getMessage());
	                	throw new AccountServiceException(MessageConstants.NO_TABLE_ERR_MSG, errors, "en", "DB_ERROR");
	                }
	            }
	          
			
		}
		
		return accounts;
		
	}
}
