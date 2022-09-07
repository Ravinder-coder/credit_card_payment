package com.capgemini.payloads;

import javax.validation.constraints.NotBlank;

public class AccountRecieve {
	
	private long accountId;
	@NotBlank
	private String accountName;
	private double balance;
	@NotBlank
	private String accountType;
	
	private long customerId;

	public AccountRecieve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountRecieve(long accountId, @NotBlank String accountName, double balance, @NotBlank String accountType,
			long customerId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.accountType = accountType;
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "AccountRecieve [accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance
				+ ", accountType=" + accountType + ", customerId=" + customerId + "]";
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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	

}
