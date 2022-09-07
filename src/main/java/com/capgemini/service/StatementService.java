package com.capgemini.service;

import java.util.List;

import com.capgemini.payloads.StatementRecieve;
import com.capgemini.payloads.StatementResponse;


public interface StatementService {

	public StatementResponse insert(StatementRecieve statementRecieve);
	public StatementResponse update(StatementRecieve statementRecieve, long id);
	public List<StatementResponse> getAll();
	public StatementResponse getById(long id);
	public void delete(long id);
}
