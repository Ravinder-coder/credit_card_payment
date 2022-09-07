package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.payloads.ApiResponse;
import com.capgemini.payloads.UserModel;
import com.capgemini.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserModel userModel){
		UserModel saveUser = this.userService.saveUser(userModel);
		return new ResponseEntity<UserModel>(saveUser, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserModel> updateUser(@Valid @RequestBody UserModel userModel, @PathVariable("id") long id){
		UserModel updateUser = this.userService.updateUser(userModel, id);
		return new ResponseEntity<UserModel>(updateUser ,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<UserModel>> getUsers(){
		List<UserModel> allUsers = this.userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<UserModel> getUser(@PathVariable("id") long id){
		UserModel user = this.userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") long id){
		this.userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted SucceFully !!", true), HttpStatus.OK);
	}
	
	
	
	
	
}
