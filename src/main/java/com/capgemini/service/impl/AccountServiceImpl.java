package com.capgemini.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customexception.ResourseNotFoundException;
import com.capgemini.entity.Account;
import com.capgemini.entity.Address;
import com.capgemini.entity.Customer;
import com.capgemini.payloads.AccountRecieve;
import com.capgemini.payloads.AccountResponse;
import com.capgemini.payloads.AddressResponse;
import com.capgemini.repo.AccountRepo;
import com.capgemini.repo.AddressRepo;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AccountResponse insert(AccountRecieve accountRecieve) {
		// TODO Auto-generated method stub
		Account account = this.modelMapper.map(accountRecieve, Account.class);
		Customer customer = this.customerRepo.findById(accountRecieve.getCustomerId()).orElseThrow(
				() -> new ResourseNotFoundException("Customer", "customer id", accountRecieve.getCustomerId()));
		account.setCustomer(customer);
		Account save = this.accountRepo.save(account);
		AccountResponse response = this.modelMapper.map(save, AccountResponse.class);
		return response;
		}

	@Override
	public AccountResponse update(AccountRecieve accountRecieve, long id) {
		// TODO Auto-generated method stub
		Account account = this.accountRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Account", "account-id", id));
		account.setAccountId(accountRecieve.getAccountId());
		account.setAccountName(accountRecieve.getAccountName());
		account.setAccountType(accountRecieve.getAccountType());
		account.setBalance(accountRecieve.getBalance());
		
		Customer customer = this.customerRepo.findById(accountRecieve.getCustomerId()).orElseThrow(
				() -> new ResourseNotFoundException("Customer", "customer id", accountRecieve.getCustomerId()));
		account.setCustomer(customer);
		Account save = this.accountRepo.save(account);
		AccountResponse response = this.modelMapper.map(save, AccountResponse.class);
		return response;
		
	}

	@Override
	public List<AccountResponse> getAll() {
		// TODO Auto-generated method stub
		List<Account> accounts = this.accountRepo.findAll();
		List<AccountResponse> response = accounts.stream()
				.map((account) -> this.modelMapper.map(account, AccountResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public AccountResponse getById(long id) {
		// TODO Auto-generated method stub
		Account account = this.accountRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Account", "account-id", id));
		AccountResponse response = this.modelMapper.map(account, AccountResponse.class);
		return response;
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Account account = this.accountRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Account", "account-id", id));
      this.accountRepo.delete(account);
	}

	
}
