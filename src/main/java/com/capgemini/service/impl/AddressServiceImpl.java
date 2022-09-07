package com.capgemini.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customexception.ResourseNotFoundException;
import com.capgemini.entity.Address;
import com.capgemini.entity.Customer;
import com.capgemini.payloads.AddressRecieve;
import com.capgemini.payloads.AddressResponse;
import com.capgemini.payloads.CustomerModel;
import com.capgemini.repo.AddressRepo;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AddressResponse insert(AddressRecieve adressRecieve) {
		// TODO Auto-generated method stub
		Address address = this.modelMapper.map(adressRecieve, Address.class);
		Customer customer = this.customerRepo.findById(adressRecieve.getCustomerId()).orElseThrow(
				() -> new ResourseNotFoundException("Customer", "customer id", adressRecieve.getCustomerId()));
		address.setCustomer(customer);
		Address save = this.addressRepo.save(address);
		AddressResponse response = this.modelMapper.map(save, AddressResponse.class);
		return response;

	}

	@Override
	public AddressResponse update(AddressRecieve addressRecieve, long id) {
		// TODO Auto-generated method stub
		Address address = this.addressRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Address", "address-id", id));
		address.setId(addressRecieve.getId());
		address.setArea(addressRecieve.getArea());
		address.setCity(addressRecieve.getCity());
		address.setDoorNo(addressRecieve.getDoorNo());
		address.setPincode(addressRecieve.getPincode());
		address.setState(addressRecieve.getState());
		address.setStreet(addressRecieve.getStreet());
		Customer customer = this.customerRepo.findById(addressRecieve.getCustomerId()).orElseThrow(
				() -> new ResourseNotFoundException("Customer", "customer id", addressRecieve.getCustomerId()));
		address.setCustomer(customer);
		Address save = this.addressRepo.save(address);
		AddressResponse response = this.modelMapper.map(save, AddressResponse.class);
		return response;
	}

	@Override
	public List<AddressResponse> getAll() {
		// TODO Auto-generated method stub
		List<Address> addresses = this.addressRepo.findAll();
		List<AddressResponse> response = addresses.stream()
				.map((address) -> this.modelMapper.map(address, AddressResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public AddressResponse getById(long id) {
		// TODO Auto-generated method stub
		Address address = this.addressRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Address", "address-id", id));
		AddressResponse response = this.modelMapper.map(address, AddressResponse.class);
		return response;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Address address = this.addressRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Address", "address-id", id));
      this.addressRepo.delete(address);
	}

}
