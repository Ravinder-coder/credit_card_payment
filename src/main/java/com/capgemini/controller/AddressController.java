package com.capgemini.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.payloads.AddressRecieve;
import com.capgemini.payloads.AddressResponse;
import com.capgemini.payloads.CustomerModel;
import com.capgemini.service.AddressService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
    private AddressService addressService;
	
	@PostMapping("/save")
	public ResponseEntity<AddressResponse> saveAddress(@Valid @RequestBody AddressRecieve addressRecieve){
		AddressResponse response = this.addressService.insert(addressRecieve);
		return new ResponseEntity<AddressResponse>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressResponse>  updateAddress(@Valid @RequestBody AddressRecieve addressRecieve, long id){
		AddressResponse response = this.addressService.update(addressRecieve, id);
		return new ResponseEntity<AddressResponse>(response, HttpStatus.CREATED);
	}

}
