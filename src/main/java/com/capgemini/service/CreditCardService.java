package com.capgemini.service;

import java.util.List;


import com.capgemini.payloads.CreditCardRecieve;
import com.capgemini.payloads.CreditCardResponse;

public interface CreditCardService {

	public CreditCardResponse insert(CreditCardRecieve creditCardRecieve);
	public CreditCardResponse update(CreditCardRecieve creditCardRecieve, long id);
	public List<CreditCardResponse> getAll();
	public CreditCardResponse getById(long id);
	public void delete(long id);
	
	
}
