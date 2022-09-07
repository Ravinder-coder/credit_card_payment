package com.capgemini.payloads;

import java.time.LocalDate;


public class StatementRecieve {

	private long statementid;
	private double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;
	
	private long customerId;

	public StatementRecieve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatementRecieve(long statementid, double dueAmount, LocalDate billingDate, LocalDate dueDate,
			long customerId) {
		super();
		this.statementid = statementid;
		this.dueAmount = dueAmount;
		this.billingDate = billingDate;
		this.dueDate = dueDate;
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "StatementRecieve [statementid=" + statementid + ", dueAmount=" + dueAmount + ", billingDate="
				+ billingDate + ", dueDate=" + dueDate + ", customerId=" + customerId + "]";
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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	
}
