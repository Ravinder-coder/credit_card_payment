package com.capgemini.payloads;

import javax.validation.constraints.NotBlank;

public class AccountResponse {
	
	private long accountId;
	private String accountName;
	private double balance;
	private String accountType;
	private CustomerModel customer;
	public AccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountResponse(long accountId, String accountName, double balance, String accountType,
			CustomerModel customer) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.accountType = accountType;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "AccountResponse [accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance
				+ ", accountType=" + accountType + ", customer=" + customer + "]";
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public CustomerModel getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
}
