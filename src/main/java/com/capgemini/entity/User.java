package com.capgemini.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userId;
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, String userId, String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password=" + password + "]";
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
