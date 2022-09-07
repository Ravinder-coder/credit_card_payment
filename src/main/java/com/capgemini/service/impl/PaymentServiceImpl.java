package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.repo.PaymentRepo;
import com.capgemini.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepo paymentRepo;

	
}
