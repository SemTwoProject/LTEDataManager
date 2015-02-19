package com.dao;

import javax.ejb.Local;

import com.entities.Failure;

import java.util.Collection;
@Local
public interface FailureDAO {

	Collection<Failure> getFailure();
	Failure getByFailure(Integer failure);
	public void createFailure(Integer failure, String description);
}
