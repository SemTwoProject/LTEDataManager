package com.service;

import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Object> getTotalFaultsAndDurationPerIMSI();
}