<<<<<<< HEAD
package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.CellHier;
import com.entity.EventCause;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.MccMnc;
import com.entity.UE;

@Local
public interface FaultDAO {

	Collection<Fault> getFault();

	Fault getById(Integer id);

	Collection<Object> getFaultByIMSI(Long imsi);

	Failure getByFailure(Integer failure);

	CellHier getByCellId(Integer cellId);

	EventCause getByEventCause(Integer event);

	MccMnc getByMCC(Integer mcc);
	
	MccMnc getByMNC(Integer mnc);

	UE getByTac(Integer tac);
	
	Fault getByEventId(Integer eventId);

	Collection<Object> getTotalFaultsAndDurationPerIMSI();
=======
package com.dao;

import java.sql.Timestamp;
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

	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}