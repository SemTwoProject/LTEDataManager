package com.interfaces;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.EventCause;
import com.entity.Fault;

public interface FaultServiceLocal {


	Collection<EventCause> getFaultByIMSI(Long imsi);
	Long getIMSICount(Timestamp start, Timestamp end,Long imsi);
	Collection<Fault> getCauseCodePerIMSI(Long imsi);
	Collection<Fault> getIMSIFailureOverTime(Timestamp startDate, Timestamp endDate);
	Collection<Fault> getAllFault();
	Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);

}
