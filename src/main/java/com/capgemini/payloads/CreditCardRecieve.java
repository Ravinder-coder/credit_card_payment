package com.capgemini.payloads;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class CreditCardRecieve {

	private long id;
	@NotBlank
	private String cardName;
	@NotBlank
	private String cardNumber;
	@NotBlank
	private String cardType;
	@NotBlank
	private String bankName;
	private LocalDate expiryDate;
	
	private long customerId;

	public CreditCardRecieve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCardRecieve(long id, @NotBlank String cardName, @NotBlank String cardNumber, @NotBlank String cardType,
			@NotBlank String bankName, LocalDate expiryDate, long customerId) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.bankName = bankName;
		this.expiryDate = expiryDate;
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "CreditCardRecieve [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardType="
				+ cardType + ", bankName=" + bankName + ", expiryDate=" + expiryDate + ", customerId=" + customerId
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
}
