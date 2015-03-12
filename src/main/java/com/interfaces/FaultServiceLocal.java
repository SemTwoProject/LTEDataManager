package com.interfaces;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	
	Collection<Fault> getEventCausePerIMSI(Long imsi);
	Collection<Fault> getIMSICount(Timestamp start, Timestamp end,Long imsi);
	Collection<Fault> getCauseCodePerIMSI(Long imsi);
	Collection<Fault> getIMSIFailureOverTime(Timestamp startDate, Timestamp endDate);
	Collection<Fault> getAllFault();
	Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
	Collection<Fault> getImsiPerFailure(int failure);
	Collection<Fault> getTopTenIMSIOverTime(Timestamp start, Timestamp end);
	Collection<Fault> getAmountOfCallFailuresPerModel(String model, Timestamp start, Timestamp end);
	Collection<Fault> getTopTenMarketOperatorCell(Timestamp start, Timestamp end);
}
