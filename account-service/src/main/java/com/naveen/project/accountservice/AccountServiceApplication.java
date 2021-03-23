package com.naveen.project.accountservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;

import com.naveen.project.accountservice.models.Response;
import com.naveen.project.accountservice.models.TaskCountResponse;
import com.naveen.project.accountservice.repositories.AccountRepo;
import com.naveen.project.accountservice.repositories.CountRepo;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class AccountServiceApplication {
	
	@Autowired
	CountRepo repo;
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(AccountServiceApplication.class, args);
		
		String formula = "0<x<100";
		System.out.println("***********************************************************************************");
		//System.out.println(formula.chars().filter(num -> num == '<').count());
		
		String a= "";

}
	

		
		
		
	
	

}
