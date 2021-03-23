package com.naveen.project.accountservice.models;

public class TaskCountResponse {
	
	
	String count;
	

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public TaskCountResponse(String count) {
		super();
		
		this.count = count;
	}
	
	
	
}
