package com.capgemini.payloads;

import javax.validation.constraints.NotBlank;

public class UserModel {
	
	private long id;
	@NotBlank(message = "User Id is Required !!")
	private String userId;
	
	@NotBlank(message = "Password is Required !!")
	private String password;
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(long id, String userId, String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userId=" + userId + ", password=" + password + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
