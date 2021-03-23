package com.naveen.project.accountservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.project.accountservice.errorhandler.AccountServiceException;
import com.naveen.project.accountservice.models.TaskCountResponse;
import com.naveen.project.accountservice.repositories.AccountRepo;
import com.naveen.project.accountservice.repositories.CountRepo;
import com.naveen.project.accountservice.services.AccountService;
import com.sun.org.slf4j.internal.Logger;

@RestController
public class AccountController {
	
	 @Autowired
	 AccountService accountService;
	 
	 @Autowired
	 CountRepo repo;
	
	 @Value("${server.port}")
	 private String port;
	 
	
	 private String str= "";
	 
	 @GetMapping("/accounts")
	 public String getAllAccounts() throws AccountServiceException {
		
		 
		 System.out.println("***************in Account Controller******************");
		
		
		 
		 return "Response from port (Account-Service) "+ port+ ":"+ "\r\n" +  accountService.getAccounts().toString();
		
	 }
	 
	 @GetMapping("/count")
	 public void getAllCounts()  {
		
		 
		 System.out.println("***************in Account Controller******************");
		
		List<Object[]> lst =  repo.getCount();
		
		//System.out.println(lst.stream().filter(x-> x[0].toString().equals("C")).collect(Collectors.toList()));
		//System.out.println(lst.stream().filter(x-> x[0].toString().equals("C")).);
		//List<TaskCountResponse> lst2 = lst.stream().filter(x-> (x[1].toString().equals("C")||x[1].toString().equals("I")))
				//.map(x -> new TaskCountResponse(x[0].toString(), x[2].toString())).collect(Collectors.toList());
		 
		List<TaskCountResponse> lst2 = lst.stream().filter(x-> (x[1].toString().equals("O")))
				.map(x -> new TaskCountResponse(x[0].toString())).collect(Collectors.toList());
		 
		String groupTasksCount = lst.stream().filter(x-> (x[0].toString().equals("O")))
		.map(x -> new TaskCountResponse(x[1].toString())).collect(Collectors.toList()).get(0).getCount();
		
		String myTasksCount = lst.stream().filter(x-> (x[0].toString().equals("I")))
		.map(x -> new TaskCountResponse(x[1].toString())).collect(Collectors.toList()).get(0).getCount();
		
		String TasksHistoryCount = lst.stream().filter(x-> (x[0].toString().equals("C") || x[0].toString().equals("R") ))
		.map(x -> new TaskCountResponse(x[1].toString())).collect(Collectors.toList()).get(0).getCount();
		
		
		String TasksHistoryCount2 = lst.stream().filter(x-> (x[0].toString().equals("C") || x[0].toString().equals("R") ))
		.map(x -> (x[1].toString())).collect(Collectors.toList()).get(0);
		
		System.out.println(groupTasksCount);
		System.out.println(myTasksCount);
		System.out.println(TasksHistoryCount);
		System.out.println(TasksHistoryCount2);
		
		//System.out.println(lst2.get(1).getCount());
		
	 }

}
















