package com.interfaces;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
}