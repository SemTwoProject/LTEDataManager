package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.CellHier;
import com.entity.Duration;
import com.entity.EventCause;
import com.entity.EventId;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.MCC;
import com.entity.MNC;
import com.entity.NEVersion;
import com.entity.UE;
@Local
public interface FaultDAO {

	Collection<Fault> getFault();
	public void createFault(String date, EventId eventId, Failure failure, UE tac, MCC mcc,
			MNC mnc, CellHier cellId, 
			Duration duration, EventCause eventCause, NEVersion ne);
	Fault getById(Integer id);
}
