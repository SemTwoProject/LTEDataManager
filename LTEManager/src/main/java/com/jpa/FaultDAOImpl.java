package com.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dao.CellDAO;
import com.dao.DurationDAO;
import com.dao.EventCauseDAO;
import com.dao.EventIdDAO;
import com.dao.FailureDAO;
import com.dao.FaultDAO;
import com.dao.MCCDAO;
import com.dao.MNCDAO;
import com.dao.NEVersionDAO;
import com.dao.UEDAO;
import com.entity.Fault;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FaultDAOImpl implements FaultDAO {

	@PersistenceContext
	private EntityManager em;

	@Temporal(TemporalType.DATE)
	

	public void createFaults(){
		ArrayList<Fault> faults = new ArrayList<Fault>();
		EventIdDAO eventId = new EventIdDAOImpl();
		FailureDAO fail = new FailureDAOImpl();
		UEDAO ue = new UEDAOImpl();
		MCCDAO mcc = new MCCDAOImpl();
		MNCDAO mnc = new MNCDAOImpl();
		CellDAO cell = new CellDAOImpl();
		DurationDAO duration = new DurationDAOImpl();
		EventCauseDAO eventCause = new EventCauseDAOImpl();
		NEVersionDAO ne = new NEVersionDAOImpl();
				
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098),fail.getByFailure(1),ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930),cell.getByCellId(4),duration.getByDuration(1000),eventCause.getByEventCause(0),ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1),ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1),ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1),ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(0),ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(0),ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(23)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));									
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));							
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));								
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:10"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:11"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:12"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:13"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:14"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		for(Fault fault: faults){
			em.persist(fault);
		}
	}
	
	public void createFaultsTwo(){
			ArrayList<Fault> faults = new ArrayList<Fault>();
			EventIdDAO eventId = new EventIdDAOImpl();
			FailureDAO fail = new FailureDAOImpl();
			UEDAO ue = new UEDAOImpl();
			MCCDAO mcc = new MCCDAOImpl();
			MNCDAO mnc = new MNCDAOImpl();
			CellDAO cell = new CellDAOImpl();
			DurationDAO duration = new DurationDAOImpl();
			EventCauseDAO eventCause = new EventCauseDAOImpl();
			NEVersionDAO ne = new NEVersionDAOImpl();
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(24)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(5)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(11)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(9)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:35"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:36"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:37"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(10)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:38"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(12)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("11B")));
											
		faults.add(new Fault("11/01/2013 17:39"	,eventId.getByEventId(4125)	,fail.getByFailure(0)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(3842)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("11B")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(25)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(1)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:15"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:16"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:17"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:18"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:19"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:20"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:21"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:22"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:23"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:24"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:25"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:26"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:27"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:28"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:29"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:30"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(13)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:31"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(14)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:32"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000153)	,mcc.getByMCC(310)	,mnc.getByMNC(560)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(14)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:33"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(33000253)	,mcc.getByMCC(240)	,mnc.getByMNC(21)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(26)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4098)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(2)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4097)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(0)	,ne.getByNE("12A")));
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4106)	,fail.getByFailure(1)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(14)	,ne.getByNE("12A")));
											
		faults.add(new Fault("11/01/2013 17:34"	,eventId.getByEventId(4125)	,fail.getByFailure(2)	,ue.getByTac(21060800)	,mcc.getByMCC(344)	,mnc.getByMNC(930)	,cell.getByCellId(4)	,duration.getByDuration(1000)	,eventCause.getByEventCause(27)	,ne.getByNE("12A")));
		for(Fault fault: faults){
			em.persist(fault);
		}
	}

	public Collection<Fault> getFault() {
		Query q = em.createQuery("select ft from Fault ft");
		return q.getResultList();
	}

	public Fault getById(Integer id) {
		Query q = em.createQuery("select f from Fault f where f.id ='" + id+"'",
				Fault.class);
		List<Fault> faults = q.getResultList();
		return faults.get(0);
	}

	public Collection<Fault> getFaultByIMSI(Long imsi) {
		Query q = em.createQuery("select f from Fault f where f.imsi ='" + imsi+"'", Fault.class);
		List<Fault> faults = q.getResultList();
		return faults;
	}
}