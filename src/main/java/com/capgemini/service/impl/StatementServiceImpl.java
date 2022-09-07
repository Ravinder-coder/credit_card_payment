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
import com.capgemini.entity.Statement;
import com.capgemini.entity.Transection;
import com.capgemini.payloads.AccountResponse;
import com.capgemini.payloads.AddressResponse;
import com.capgemini.payloads.StatementRecieve;
import com.capgemini.payloads.StatementResponse;
import com.capgemini.repo.AddressRepo;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.repo.StatementRepo;
import com.capgemini.service.StatementService;
@Service
public class StatementServiceImpl implements StatementService{

	@Autowired
	private StatementRepo statementRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StatementResponse insert(StatementRecieve statementRecieve) {
		// TODO Auto-generated method stub
				Statement statement = this.modelMapper.map(statementRecieve, Statement.class);
				Customer customer = this.customerRepo.findById(statementRecieve.getCustomerId()).orElseThrow(
						() -> new ResourseNotFoundException("Customer", "customer id", statementRecieve.getCustomerId()));
				statement.setCustomer(customer);
				Statement save = this.statementRepo.save(statement);
				StatementResponse response = this.modelMapper.map(save, StatementResponse.class);
				return response;
	}

	@Override
	public StatementResponse update(StatementRecieve statementRecieve, long id) {
		// TODO Auto-generated method stub
		Statement statement = this.statementRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Statement", "statement-id", id));
		statement.setStatementid(statementRecieve.getStatementid());
		statement.setDueAmount(statementRecieve.getDueAmount());
		statement.setBillingDate(statementRecieve.getBillingDate());
		statement.setDueDate(statementRecieve.getDueDate());
		
		Customer customer = this.customerRepo.findById(statementRecieve.getCustomerId()).orElseThrow(
				() -> new ResourseNotFoundException("Customer", "customer id", statementRecieve.getCustomerId()));
		statement.setCustomer(customer);
		Statement save = this.statementRepo.save(statement);
		StatementResponse response = this.modelMapper.map(save, StatementResponse.class);
		return response;
	}

	@Override
	public List<StatementResponse> getAll() {
		// TODO Auto-generated method stub
		List<Statement> statements = this.statementRepo.findAll();
		List<StatementResponse> response = statements.stream()
				.map((statement) -> this.modelMapper.map(statement, StatementResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public StatementResponse getById(long id) {
		// TODO Auto-generated method stub
		Statement statement = this.statementRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Statement", "statement-id", id));
		StatementResponse response = this.modelMapper.map(statement, StatementResponse.class);
		return response;
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Statement statement = this.statementRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Statement", "statement-id", id));
      this.statementRepo.delete(statement);
	}
}
