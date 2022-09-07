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
@Table(name = "address_tbl")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private int pincode;
	@Column
	private String  doorNo;
	@Column
	private String street;
	@Column
	private String area;
	@Column
	private String city;
	@Column
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(long id, int pincode, String doorNo, String street, String area, String city, String state,
			Customer customer) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", pincode=" + pincode + ", doorNo=" + doorNo + ", street=" + street + ", area="
				+ area + ", city=" + city + ", state=" + state + ", customer=" + customer + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
