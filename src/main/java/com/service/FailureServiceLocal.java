package com.service;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.Failure;
import com.entity.Fault;

public interface FailureServiceLocal {
	Collection<Failure> getAllFailure();
}
