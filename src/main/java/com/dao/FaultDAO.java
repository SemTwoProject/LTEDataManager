package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.CellHier;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.UE;

@Local
public interface FaultDAO {

	Collection<Fault> getFault();

	Fault getById(Integer id);

	Collection<Object> getFaultByIMSI(Long imsi);

	Failure getByFailure(Integer failure);

	CellHier getByCellId(Integer cellId);

	UE getByTac(Integer tac);
	
	Fault getByEventId(Integer eventId);

	Collection<Object> getTotalFaultsAndDurationPerIMSI();
}