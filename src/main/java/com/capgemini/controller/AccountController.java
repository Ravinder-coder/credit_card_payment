package com.capgemini.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.payloads.AccountRecieve;
import com.capgemini.payloads.AccountResponse;
import com.capgemini.payloads.AddressRecieve;
import com.capgemini.payloads.AddressResponse;
import com.capgemini.service.AccountService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/save")
	public ResponseEntity<AccountResponse> saveAccount(@Valid @RequestBody AccountRecieve accountRecieve){
		AccountResponse response = this.accountService.insert(accountRecieve);
		return new ResponseEntity<AccountResponse>(response, HttpStatus.CREATED);
	}
	
	
	
	
	
}
