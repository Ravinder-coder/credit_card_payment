package com.capgemini.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customexception.ResourseNotFoundException;
import com.capgemini.entity.User;
import com.capgemini.payloads.UserModel;
import com.capgemini.repo.UserRepo;
import com.capgemini.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserModel saveUser(UserModel userModel) {
		User user = this.modelMapper.map(userModel, User.class);
		User userSaved = this.userRepository.save(user);
		UserModel userResponse = this.modelMapper.map(userSaved, UserModel.class);
		return userResponse;
	}

	@Override
	public UserModel updateUser(UserModel userModel, long id) {
		User user = this.userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User", " User Id ", id));
		user.setId(userModel.getId());
		user.setUserId(userModel.getUserId());
		user.setPassword(userModel.getPassword());
		User save = this.userRepository.save(user);
		UserModel response = this.modelMapper.map(save, UserModel.class);
		return response;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserModel> response = users.stream().map((user) -> this.modelMapper.map(user, UserModel.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public UserModel getUser(long id) {
		User user = this.userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User", " User Id ", id));
		UserModel response = this.modelMapper.map(user, UserModel.class);
		return response;
	}

	@Override
	public void deleteUser(long id) {
		User user = this.userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User", " User Id ", id));
		this.userRepository.delete(user);
	}

}
