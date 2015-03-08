package com.interfaces;

import java.util.Collection;
import java.util.Date;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Date start, Date end);
}