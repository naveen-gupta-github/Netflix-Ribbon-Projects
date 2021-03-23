package com.naveen.project.accountservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="count")
@Entity
public class Count {

	private String processType;
	private String status;
	private String count;
	
	@Id
	//@Column(name = "Id")
	private Integer id;
	
	
	
	public Count(String processType, String status, String count, Integer id) {
		super();
		this.processType = processType;
		this.status = status;
		this.count = count;
		this.id = id;
	}
	
	
	
	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Count [processType=" + processType + ", status=" + status + ", count=" + count + ", id=" + id + "]";
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
}
