package com.naveen.project.accountservice.models;


public class Response {

	
		
		String processType;
		String status;
		String count;
		
		public Response(String processType, String status, String count) {
			super();
			this.processType = processType;
			this.status = status;
			this.count = count;
		}
}
