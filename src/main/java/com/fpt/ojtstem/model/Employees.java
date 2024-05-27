package com.fpt.ojtstem.model;
public class Employees{
	private int employeeID ;
	private String accountId;
	
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int employeeID, String accountId) {
		super();
		this.employeeID = employeeID;
		this.accountId = accountId;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	


}