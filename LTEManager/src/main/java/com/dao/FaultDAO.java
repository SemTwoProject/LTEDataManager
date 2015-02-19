package com.dao;

import javax.ejb.Local;

import com.entities.CellHier;
import com.entities.Duration;
import com.entities.EventCause;
import com.entities.EventId;
import com.entities.Failure;
import com.entities.Fault;
import com.entities.MCC;
import com.entities.MNC;
import com.entities.NEVersion;
import com.entities.UE;

import java.util.Collection;
@Local
public interface FaultDAO {

	Collection<Fault> getFault();
	public void createFault(String date, EventId eventId, Failure failure, UE tac, MCC mcc,
			MNC mnc, CellHier cellId, 
			Duration duration, EventCause eventCause, NEVersion ne);
	Fault getById(Integer id);
}
