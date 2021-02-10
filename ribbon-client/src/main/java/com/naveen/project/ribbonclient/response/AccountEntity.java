package com.naveen.project.ribbonclient.response;




public class AccountEntity {
	
	
	private Integer id;
	
	private String accountNumber;
	
	private String customerName;
	
	private Integer branchCode;
	
	

	public AccountEntity() {
		
	}

	public AccountEntity(Integer id, String accountNumber, String customerName, Integer branchCode) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.branchCode = branchCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", AccountNumber=" + accountNumber + ", customerName=" + customerName
				+ ", branchCode=" + branchCode + "]";
	}
	
	
	
}
