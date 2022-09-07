package com.capgemini.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customexception.ResourseNotFoundException;
import com.capgemini.entity.Account;
import com.capgemini.entity.Address;
import com.capgemini.entity.CreditCard;
import com.capgemini.entity.Customer;
import com.capgemini.payloads.AccountResponse;
import com.capgemini.payloads.AddressResponse;
import com.capgemini.payloads.CreditCardRecieve;
import com.capgemini.payloads.CreditCardResponse;
import com.capgemini.repo.CreditCardRepo;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.service.CreditCardService;
@Service
public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	private CreditCardRepo creditCardRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CreditCardResponse insert(CreditCardRecieve creditCardRecieve) {
		// TODO Auto-generated method stub
				CreditCard creditCard = this.modelMapper.map(creditCardRecieve, CreditCard.class);
				Customer customer = this.customerRepo.findById(creditCardRecieve.getCustomerId()).orElseThrow(
						() -> new ResourseNotFoundException("Customer", "customer id", creditCardRecieve.getCustomerId()));
				creditCard.setCustomer(customer);
				CreditCard save = this.creditCardRepo.save(creditCard);
				CreditCardResponse response = this.modelMapper.map(save, CreditCardResponse.class);
				return response;
	}

	@Override
	public CreditCardResponse update(CreditCardRecieve creditCardRecieve, long id) {
		// TODO Auto-generated method stub
		CreditCard creditCard = this.creditCardRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("CreditCard", "creditCard-id", id));
		creditCard.setId(creditCardRecieve.getId());
		creditCard.setBankName(creditCardRecieve.getBankName());
		creditCard.setCardName(creditCardRecieve.getCardName());
		creditCard.setCardNumber(creditCardRecieve.getCardNumber());
		creditCard.setCardType(creditCardRecieve.getCardType());
		creditCard.setExpiryDate(creditCardRecieve.getExpiryDate());
		Customer customer = this.customerRepo.findById(creditCardRecieve.getCustomerId()).orElseThrow(
				() -> new ResourseNotFoundException("Customer", "customer id", creditCardRecieve.getCustomerId()));
		creditCard.setCustomer(customer);
		CreditCard save = this.creditCardRepo.save(creditCard);
		CreditCardResponse response = this.modelMapper.map(save, CreditCardResponse.class);
		return response;
	}

	@Override
	public List<CreditCardResponse> getAll() {
		// TODO Auto-generated method stub
		List<CreditCard> creditCards = this.creditCardRepo.findAll();
		List<CreditCardResponse> response = creditCards.stream()
				.map((creditCard) -> this.modelMapper.map(creditCard, CreditCardResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public CreditCardResponse getById(long id) {
		// TODO Auto-generated method stub
		CreditCard creditCard = this.creditCardRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("CreditCard", "creditCard-id", id));
		CreditCardResponse response = this.modelMapper.map(creditCard, CreditCardResponse.class);
		return response;
	
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		CreditCard creditCard = this.creditCardRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("CreditCard", "creditCard-id", id));
      this.creditCardRepo.delete(creditCard);
	}
}
