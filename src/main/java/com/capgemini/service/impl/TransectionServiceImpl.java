package com.capgemini.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customexception.ResourseNotFoundException;

import com.capgemini.entity.Customer;
import com.capgemini.entity.Transection;

import com.capgemini.payloads.TransectionRecieve;
import com.capgemini.payloads.TransectionResponse;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.repo.TransectionRepo;
import com.capgemini.service.TransectionService;
@Service
public class TransectionServiceImpl implements TransectionService{

	@Autowired
	private TransectionRepo transectionRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TransectionResponse insert(TransectionRecieve transectionRecieve) {
		// TODO Auto-generated method stub
		      Transection transection = this.modelMapper.map(transectionRecieve, Transection.class);
				Customer customer = this.customerRepo.findById(transectionRecieve.getCustomerId()).orElseThrow(
						() -> new ResourseNotFoundException("Customer", "customer id", transectionRecieve.getCustomerId()));
				transection.setCustomer(customer);
				Transection save = this.transectionRepo.save(transection);
				TransectionResponse response = this.modelMapper.map(save, TransectionResponse.class);
				return response;
	}

	@Override
	public TransectionResponse update(TransectionRecieve transectionRecieve, long id) {
		// TODO Auto-generated method stub
		Transection transection = this.transectionRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Transection", "transection-id", id));
		transection.setTranId(transectionRecieve.getTranId());
		transection.setAmount(transectionRecieve.getAmount());
		transection.setCardNumber(transectionRecieve.getCardNumber());
		transection.setPaymentMethod(transectionRecieve.getPaymentMethod());
		transection.setDescription(transectionRecieve.getDescription());
		transection.setStatus(transectionRecieve.getStatus());
		transection.setTranDate(transectionRecieve.getTranDate());
		Customer customer = this.customerRepo.findById(transectionRecieve.getCustomerId()).orElseThrow(
				() -> new ResourseNotFoundException("Customer", "customer id", transectionRecieve.getCustomerId()));
		transection.setCustomer(customer);
		Transection save = this.transectionRepo.save(transection);
		TransectionResponse response = this.modelMapper.map(save, TransectionResponse.class);
		return response;
	
	}

	@Override
	public List<TransectionResponse> getAll() {
		// TODO Auto-generated method stub
		List<Transection> transections = this.transectionRepo.findAll();
		List<TransectionResponse> response = transections.stream()
				.map((transection) -> this.modelMapper.map(transection, TransectionResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public TransectionResponse getById(long id) {
		// TODO Auto-generated method stub
		Transection transection = this.transectionRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Transection", "transection-id", id));
		TransectionResponse response = this.modelMapper.map(transection, TransectionResponse.class);
		return response;
	
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Transection transection = this.transectionRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Transection", "transection-id", id));
      this.transectionRepo.delete(transection);
	}
}
