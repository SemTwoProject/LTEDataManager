package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.Failure;
@Local
public interface FailureDAO {

	Collection<Failure> getFailure();
	Failure getByFailure(Integer failure);
	public void createFailure(Integer failure, String description);
}
