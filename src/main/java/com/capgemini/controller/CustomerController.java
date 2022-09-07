package com.capgemini.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.payloads.CustomerModel;
import com.capgemini.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<CustomerModel>  saveCustomer(@Valid @RequestBody CustomerModel customerModel){
		CustomerModel saveCustomer = this.customerService.saveCustomer(customerModel);
		return new ResponseEntity<CustomerModel>(saveCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerModel>  updateCustomer(@Valid @RequestBody CustomerModel customerModel, long id){
		CustomerModel saveCustomer = this.customerService.updateCustomer(customerModel, id);
		return new ResponseEntity<CustomerModel>(saveCustomer, HttpStatus.CREATED);
	}
	
}
