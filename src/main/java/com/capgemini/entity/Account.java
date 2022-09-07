package com.capgemini.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_tbl")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	@Column
	private String accountName;
	@Column
	private double balance;
	@Column
	private String accountType;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long accountId, String accountName, double balance, String accountType, Customer customer) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.accountType = accountType;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
	
}
