package com.capgemini.payloads;

import javax.persistence.Column;

public class TransectionRecieve {

    private long tranId;
	
	private String cardNumber;
    private String tranDate;
	private String status;
    private double amount;
	private String paymentMethod;
	private String description;
	
	private long customerId;

	public TransectionRecieve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransectionRecieve(long tranId, String cardNumber, String tranDate, String status, double amount,
			String paymentMethod, String description, long customerId) {
		super();
		this.tranId = tranId;
		this.cardNumber = cardNumber;
		this.tranDate = tranDate;
		this.status = status;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "TransectionRecieve [tranId=" + tranId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate
				+ ", status=" + status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description="
				+ description + ", customerId=" + customerId + "]";
	}

	public long getTranId() {
		return tranId;
	}

	public void setTranId(long tranId) {
		this.tranId = tranId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
}
