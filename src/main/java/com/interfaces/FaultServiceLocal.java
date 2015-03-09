package com.interfaces;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.EventCause;

public interface FaultServiceLocal {

	Collection<EventCause> getFaultByIMSI(Long imsi);
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
	Long getImsiCount(Timestamp start, Timestamp end,Long imsi);
}