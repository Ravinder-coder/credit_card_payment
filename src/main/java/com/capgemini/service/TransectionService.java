package com.capgemini.service;

import java.util.List;

import com.capgemini.payloads.TransectionRecieve;
import com.capgemini.payloads.TransectionResponse;

public interface TransectionService {

	public TransectionResponse insert(TransectionRecieve transectionRecieve);
	public TransectionResponse update(TransectionRecieve transectionRecieve, long id);
	public List<TransectionResponse> getAll();
	public TransectionResponse getById(long id);
	public void delete(long id);
}
