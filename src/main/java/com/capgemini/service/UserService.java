package com.capgemini.service;

import java.util.List;

import com.capgemini.payloads.UserModel;

public interface UserService {
	
	public UserModel saveUser(UserModel userModel);
	
	public UserModel updateUser(UserModel userModel, long id);
	
	public List<UserModel> getAllUsers();
	
	public UserModel getUser(long id);
	
	public void deleteUser(long id);

}
