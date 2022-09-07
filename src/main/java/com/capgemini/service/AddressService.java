package com.capgemini.service;

import java.util.List;

import com.capgemini.payloads.AddressRecieve;
import com.capgemini.payloads.AddressResponse;

public interface AddressService {

	public AddressResponse insert(AddressRecieve addressRecieve);
	public AddressResponse update(AddressRecieve addressRecieve, long id);
	public List<AddressResponse> getAll();
	public AddressResponse getById(long id);
	public void delete(long id);
}
