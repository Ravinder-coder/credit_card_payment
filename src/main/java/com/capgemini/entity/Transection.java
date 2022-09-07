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
@Table(name = "transection_tbl")
public class Transection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tranId;
	
	@Column(name = "cardNumber")
	private String cardNumber;
	
	@Column(name = "trandate")
	private String tranDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "paymentMethod")
	private String paymentMethod;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Transection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transection(long tranId, String cardNumber, String tranDate, String status, double amount,
			String paymentMethod, String description, Customer customer) {
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
		return "Transection [tranId=" + tranId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate + ", status="
				+ status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description=" + description
				+ ", customer=" + customer + "]";
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
