package com.dao;

import java.sql.Timestamp;
import java.util.Collection;

import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.Fault;

@Local
public interface FaultDAO {

	Fault getById(Integer id);
	Collection<Fault> getEventCausePerIMSI(Long imsi);
	Collection<Fault> getIMSICount(Timestamp start,Timestamp end, Long imsi);
	Collection<Fault> getCauseCodePerIMSI(Long imsi);
	Collection<Fault> getIMSIFailureOverTime(Timestamp startDate, Timestamp endDate);
	Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
	Collection<Fault> getImsiPerFailure(int failure);
}
