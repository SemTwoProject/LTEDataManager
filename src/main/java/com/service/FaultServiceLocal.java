package com.service;

import java.util.Collection;
import java.util.Date;

import com.entity.EventCause;

public interface FaultServiceLocal {

	Collection<EventCause> getFaultByIMSI(Long imsi);
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Date start, Date end);
}