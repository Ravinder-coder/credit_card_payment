package com.capgemini.service;

import java.util.List;

import com.capgemini.payloads.AccountRecieve;
import com.capgemini.payloads.AccountResponse;


public interface AccountService {

	public AccountResponse insert(AccountRecieve accountRecieve);
	public AccountResponse update(AccountRecieve accountRecieve, long id);
	public List<AccountResponse> getAll();
	public AccountResponse getById(long id);
	public void delete(long id);
}
