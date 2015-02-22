package com.service;

import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	public void createFaults();
	public void createFaultsTwo();
}