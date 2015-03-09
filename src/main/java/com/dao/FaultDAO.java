package com.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.Fault;

@Local
public interface FaultDAO {

	Fault getById(Integer id);

	Collection<EventCause> getFaultByIMSI(Long imsi);
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
	Long getImsiCount(Timestamp start,Timestamp end, Long imsi);
}