package com.dao;

import javax.ejb.Local;

import com.entity.CellHier;
import com.entity.Duration;
import com.entity.EventCause;
import com.entity.EventId;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.IMSI;
import com.entity.MCC;
import com.entity.MNC;
import com.entity.NEVersion;
import com.entity.UE;

import java.util.Collection;

@Local
public interface FaultDAO {

	Collection<Fault> getFault();

	Fault getById(Integer id);

	Collection<Fault> getFaultByIMSI(Long imsi);

	Failure getByFailure(Integer failure);

	CellHier getByCellId(Integer cellId);

	NEVersion getByNE(String ne);

	IMSI getByIMSI(Long imsi);

	Duration getByDuration(Integer duration);

	EventCause getByEventCause(Integer event);

	EventId getByEventId(Integer eventId);

	MCC getByMCC(Integer mcc);

	MNC getByMNC(Integer mnc);

	UE getByTac(Integer tac);
}
