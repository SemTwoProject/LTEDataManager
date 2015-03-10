package com.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import com.entity.EventCause;
import com.entity.Fault;

public interface FaultServiceLocal {

	Collection<EventCause> getFaultByIMSI(Long imsi);
	Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start,Timestamp end);
}