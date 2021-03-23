package com.naveen.project.accountservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {


	
	@Autowired
	ApplicationContext appContext;
	
	@Scheduled(fixedDelay = 7000)
	public void detectLostDbConnection() {
		
		
		
		DataSourceHealthIndicator dshi = appContext.getBean(DataSourceHealthIndicator.class);
		Health health = dshi.health();
		Status status = health.getStatus();

		if (status != null && "DOWN".equals(status.getCode())) {
			System.out.println("************************DB-DOWN*******************");
		}
		else {
			System.out.println("************************DB-UP*******************");
		}
	}
}
