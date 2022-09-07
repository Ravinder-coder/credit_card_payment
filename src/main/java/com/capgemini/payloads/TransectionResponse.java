package com.capgemini.payloads;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class TransectionResponse {

    private long tranId;
    @NotBlank
	private String cardNumber;
    @NotBlank
	private String tranDate;
    @NotBlank
	private String status;
	private double amount;
	 @NotBlank
	private String paymentMethod;
	 @NotBlank
	private String description;
	 
	private CustomerModel customer;

	public TransectionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransectionResponse(long tranId, @NotBlank String cardNumber, @NotBlank String tranDate,
			@NotBlank String status, double amount, @NotBlank String paymentMethod, @NotBlank String description,
			CustomerModel customer) {
		super();
		this.tranId = tranId;
		this.cardNumber = cardNumber;
		this.tranDate = tranDate;
		this.status = status;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "TransectionResponse [tranId=" + tranId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate
				+ ", status=" + status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description="
				+ description + ", customer=" + customer + "]";
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

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
	
}
