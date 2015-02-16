package dao;

import javax.ejb.Local;

import java.util.Collection;

import entities.CellHier;
import entities.Duration;
import entities.EventCause;
import entities.EventId;
import entities.Failure;
import entities.Fault;
import entities.MCC;
import entities.MNC;
import entities.NEVersion;
import entities.UE;
@Local
public interface FaultDAO {

	Collection<Fault> getFault();
	public void createFault(String date, EventId eventId, Failure failure, UE tac, MCC mcc,
			MNC mnc, CellHier cellId, 
			Duration duration, EventCause eventCause, NEVersion ne);
	Fault getById(Integer id);
}
