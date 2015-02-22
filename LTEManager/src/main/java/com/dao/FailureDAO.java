package com.dao;

import javax.ejb.Local;

import com.entity.Failure;
import com.entity.Fault;

import java.util.Collection;
@Local
public interface FailureDAO {

	Collection<Failure> getFailure();
	Failure getByFailure(Integer failure);
	Collection<Object> getFailureByFault(Fault fault);
	public void createFailures();
}
