package com.dao;

<<<<<<< HEAD
import java.util.Collection;

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.Local;

import com.entity.CellHier;
import com.entity.Duration;
import com.entity.EventCause;
import com.entity.EventId;
import com.entity.Failure;
import com.entity.Fault;
<<<<<<< HEAD
=======
import com.entity.IMSI;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import com.entity.MCC;
import com.entity.MNC;
import com.entity.NEVersion;
import com.entity.UE;
<<<<<<< HEAD
=======

import java.util.Collection;

>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface FaultDAO {

	Collection<Fault> getFault();
<<<<<<< HEAD
	public void createFault(String date, EventId eventId, Failure failure, UE tac, MCC mcc,
			MNC mnc, CellHier cellId, 
			Duration duration, EventCause eventCause, NEVersion ne);
	Fault getById(Integer id);
=======

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

	Collection<Object> getTotalFaultsAndDurationPerIMSI();
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
