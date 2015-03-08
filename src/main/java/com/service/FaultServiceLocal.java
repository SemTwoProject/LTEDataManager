package com.service;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.EventCause;

public interface FaultServiceLocal {

	Collection<EventCause> getFaultByIMSI(Long imsi);
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp startdate, Timestamp enddate);
}