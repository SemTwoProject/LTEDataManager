package com.service;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Fault> getFaultByIMSI(Long imsi);
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp startdate, Timestamp enddate);
}