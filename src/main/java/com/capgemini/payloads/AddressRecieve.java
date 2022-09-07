package com.capgemini.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AddressRecieve {
	private int id;
	
	private int pincode;
	@NotBlank
	private String  doorNo;
	@NotBlank
	private String street;
	@NotBlank
	private String area;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	
	private long customerId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public AddressRecieve() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressRecieve(int id, @NotBlank int pincode, @NotBlank String doorNo, @NotBlank String street,
			@NotBlank String area, @NotBlank String city, @NotBlank String state, @NotBlank long customerId) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "AddressRecieve [id=" + id + ", pincode=" + pincode + ", doorNo=" + doorNo + ", street=" + street
				+ ", area=" + area + ", city=" + city + ", state=" + state + ", customerId=" + customerId + "]";
	}
	
}
