package com.capgemini.payloads;

import java.time.LocalDate;

import javax.persistence.Column;

public class StatementResponse {

	private long statementid;
	private double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;

	private CustomerModel customer;

	public StatementResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatementResponse(long statementid, double dueAmount, LocalDate billingDate, LocalDate dueDate,
			CustomerModel customer) {
		super();
		this.statementid = statementid;
		this.dueAmount = dueAmount;
		this.billingDate = billingDate;
		this.dueDate = dueDate;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "StatementResponse [statementid=" + statementid + ", dueAmount=" + dueAmount + ", billingDate="
				+ billingDate + ", dueDate=" + dueDate + ", customer=" + customer + "]";
	}

	public long getStatementid() {
		return statementid;
	}

	public void setStatementid(long statementid) {
		this.statementid = statementid;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	
}
