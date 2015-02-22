package com.service;

import java.util.Collection;

import com.entity.Failure;

public interface FailureServiceLocal {
	Collection<Failure> getAllFailure();
	public void createFailures();
}
