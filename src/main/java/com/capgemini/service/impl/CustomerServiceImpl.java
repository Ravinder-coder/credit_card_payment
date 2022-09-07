package com.capgemini.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customexception.ResourseNotFoundException;
import com.capgemini.entity.Customer;
import com.capgemini.entity.User;
import com.capgemini.payloads.CustomerModel;
import com.capgemini.payloads.UserModel;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.repo.UserRepo;
import com.capgemini.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	UserRepo userRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CustomerModel saveCustomer(CustomerModel customerModel) {
		Customer map = this.modelMapper.map(customerModel, Customer.class);
		User user = this.userRepository.findById(customerModel.getUid()).orElseThrow(()-> new ResourseNotFoundException("User", "user id", customerModel.getUid()));
		map.setUser(user);
		Customer save = this.customerRepo.save(map);
		CustomerModel response = this.modelMapper.map(save, CustomerModel.class);
		return response;
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel customerModel, long id) {
		Customer map = this.modelMapper.map(customerModel, Customer.class);
		User user = this.userRepository.findById(customerModel.getUid()).orElseThrow(()-> new ResourseNotFoundException("User", "user id", customerModel.getUid()));
		map.setUser(user);
		map.setContactNumber(customerModel.getContactNumber());
		map.setDateOfBirth(customerModel.getDateOfBirth());
		map.setEmail(customerModel.getName());
		map.setName(customerModel.getName());
		map.setId(customerModel.getId());
		Customer save = this.customerRepo.save(map);
		CustomerModel response = this.modelMapper.map(save, CustomerModel.class);
		return response;
	}

	@Override
	public List<CustomerModel> getCustomers() {
		List<Customer> customers = this.customerRepo.findAll();
		List<CustomerModel> customerModel = customers.stream().map((customer) -> this.modelMapper.map(customer, CustomerModel.class)).collect(Collectors.toList());
		return customerModel;
	}

	@Override
	public CustomerModel getCustomer(long id) {
		Customer customer = this.customerRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("Customer", " customer id ", id));
		CustomerModel response = this.modelMapper.map(customer, CustomerModel.class);
		return response;
	}

	@Override
	public void deleteCustomer(long id) {
		Customer customer = this.customerRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("Customer", " customer id ", id));
		this.customerRepo.delete(customer);
	}

}
