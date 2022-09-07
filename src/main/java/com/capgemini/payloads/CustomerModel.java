package com.capgemini.payloads;

import javax.validation.constraints.NotBlank;

public class CustomerModel {
	
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String contactNumber;
	@NotBlank
	private String dateOfBirth;
	private long uid;
	
	public CustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerModel(long id, @NotBlank String name, @NotBlank String email, @NotBlank String contactNumber,
			@NotBlank String dateOfBirth, @NotBlank long uid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.uid = uid;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "CustomerModel [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", dateOfBirth=" + dateOfBirth + ", uid=" + uid + "]";
	}
	
}
