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

	Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
}