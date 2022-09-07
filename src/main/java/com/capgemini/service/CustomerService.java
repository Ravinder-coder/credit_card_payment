package com.capgemini.service;

import java.util.List;

import com.capgemini.payloads.CustomerModel;

public interface CustomerService {
	
	public CustomerModel saveCustomer(CustomerModel customerModel);
	public CustomerModel updateCustomer(CustomerModel customerModel, long id);
	public List<CustomerModel> getCustomers();
	public CustomerModel getCustomer(long id);
	public void deleteCustomer(long id);

}
