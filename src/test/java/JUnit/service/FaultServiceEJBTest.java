package JUnit.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

import com.entity.Fault;
import com.service.FaultServiceEJB;

//@RunWith(MockitoJUnitRunner.class)
public class FaultServiceEJBTest {
	
	
	@Mock
	private EntityManager mockedEM;
	@EJB
	private FaultServiceEJB faultServiceEjb;
	@Mock
	private Query mockedQuery;
	
	Timestamp time1 = Timestamp.valueOf("2010-01-11 17:15:00");
	Timestamp time2 = Timestamp.valueOf("2015-01-12 17:18:00");
	
//	@Test
	public void testGetEventCausePerIMSI() {
		List<Fault> eventCausePerIMSI = new ArrayList<Fault>();
		when(mockedEM.createQuery("select eventCause.eventId, eventCause.causeCode, eventCause.description,failure.description,date From Fault f where f.imsi = 191911000456426")).thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(eventCausePerIMSI);
		List<Fault> eventCauses = (List<Fault>)faultServiceEjb.getEventCausePerIMSI(191911000456426L);
		assertSame(eventCausePerIMSI, eventCauses);
	}

//	@Test
	public void testGetTotalFaultsAndDurationPerIMSI() {
		List<Fault> faultAndDurationPerIMSI = new ArrayList<Fault>();
		when(mockedEM.createQuery("select distinct mccid.country, mccid.operator, cell.cellId, count(*) from Fault f WHERE f.date >= :start AND f.date <= :end group by f.mccid.mccId,f.mccid.mncId,f.cell.cellId order by count(*) desc")
				.setParameter("start", time1)
				.setParameter("end", time2))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(faultAndDurationPerIMSI);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getTotalFaultsAndDurationPerIMSI(time1, time2);
		assertSame(faultAndDurationPerIMSI, faults);
	}

//	@Test
	public void testGetTopTenTotalFaultsAndDurationPerIMSI() {
		List<Fault> topTenTotalFaults = new ArrayList<Fault>();
		when(mockedEM.createQuery("select imsi, COUNT(f.imsi), SUM(duration) from Fault f where f.date >= :startdate and f.date <= :enddate group by f.imsi order by sum(duration) desc")
				.setParameter("startdate", time1)
				.setParameter("enddate", time2))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(topTenTotalFaults);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getTopTenTotalFaultsAndDurationPerIMSI(time1, time2);
		assertSame(topTenTotalFaults, faults);
	}

//	@Test
	public void testGetIMSICount() {
		List<Fault> imsiCount = new ArrayList<Fault>();
		when(mockedEM.createQuery("select COUNT(*) FROM Fault i WHERE i.imsi = :imsi AND i.date >= :start AND i.date <= :end")
				.setParameter("start", time1)
				.setParameter("end", time2)
				.setParameter("imsi", 191911000456426L))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(imsiCount);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getIMSICount(time1, time2,191911000456426L);
		assertSame(imsiCount, faults);
	}

//	@Test
	public void testGetCauseCodePerIMSI() {
		List<Fault> causePerIMSI = new ArrayList<Fault>();
		when(mockedEM.createQuery("select Distinct eventCause.causeCode, COUNT(eventCause.causeCode) FROM Fault i WHERE i.imsi = :imsi Group by eventCause.causeCode")
					.setParameter("imsi", 191911000456426L))
					.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(causePerIMSI);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getCauseCodePerIMSI(191911000456426L);
		assertSame(causePerIMSI, faults);
	}

//	@Test
	public void testGetIMSIFailureOverTime() {
		List<Fault> imsiFailureOverTime = new ArrayList<Fault>();
		when(mockedEM.createQuery("select distinct imsi, eventCause.description,failure.description,mccid.operator,mccid.country,duration, date from Fault i where i.date >= :start AND i.date <= :end")
				.setParameter("start", time1)
				.setParameter("end", time2))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(imsiFailureOverTime);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getIMSIFailureOverTime(time1, time2);
		assertSame(imsiFailureOverTime, faults);
	}

//	@Test
	public void testGetTopTenIMSIOverTime() {
		List<Fault> topTenIMSI = new ArrayList<Fault>();
		when(mockedEM.createQuery("select imsi, count(f.imsi) from Fault f where f.date >= :startdate and f.date <= :enddate group by f.imsi order by count(f.imsi) desc")
				.setParameter("startdate", time1)
				.setParameter("enddate", time2))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(topTenIMSI);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getTopTenIMSIOverTime(time1, time2);
		assertSame(topTenIMSI, faults);
	}

//	@Test
	public void testGetImsiPerFailure() {
		List<Fault> imsiPerFailure  = new ArrayList<Fault>();
		when(mockedEM.createQuery("select imsi,eventCause.description,mccid.operator,mccid.country,date FROM Fault f where f.failure.failure = :failure Order by imsi")
					.setParameter("failure", 1))
					.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(imsiPerFailure);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getImsiPerFailure(1);
		assertSame(imsiPerFailure, faults);
	}

//	@Test
	public void testGetAmountOfCallFailuresPerModel() {
		List<Fault> callFailures = new ArrayList<Fault>();
		when(mockedEM.createQuery("select tac.manufacturer, count(f) from Fault f where tac.model=:model AND f.date BETWEEN :from AND :to group by tac.model")
				.setParameter("model", "Mitsubishi GSM MT 20 Type MT 1171FD2")
				.setParameter("from", time1)
				.setParameter("to", time2))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(callFailures);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getAmountOfCallFailuresPerModel("A53", time1, time2);
		assertSame(callFailures, faults);
	}

//	@Test
	public void testGetTopTenMarketOperatorCell() {
		List<Fault> topTenMarket = new ArrayList<Fault>();
		when(mockedEM.createQuery("select distinct mccid.country, mccid.operator, cell.cellId, count(*) from Fault f WHERE f.date >= :start AND f.date <= :end group by f.mccid.mccId,f.mccid.mncId,f.cell.cellId order by count(*) desc")
				.setParameter("start", time1)
				.setParameter("end", time2))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(topTenMarket);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getTopTenMarketOperatorCell(time1, time2);
		assertSame(topTenMarket, faults);
	}

//	@Test
	public void testGetEventCausePerModel() {
		List<Fault> eventCausePerModel  = new ArrayList<Fault>();
		when(mockedEM.createQuery("select distinct eventCause.eventId,eventCause.causeCode,eventCause.description, Count(*) "
				+ "FROM Fault f where f.tac.model = :model group by eventCause.eventId, eventCause.causeCode")
					.setParameter("model", "Mitsubishi GSM MT 20 Type MT 1171FD2"))
					.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(eventCausePerModel);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getEventCausePerModel("Mitsubishi GSM MT 20 Type MT 1171FD2");
		assertSame(eventCausePerModel, faults);
	}

//	@Test
	public void testGetFaultsForCell() {
		List<Fault> faultsForCell = new ArrayList<Fault>();
		when(mockedEM.createQuery("select distinct imsi, eventCause.causeCode, eventCause.eventId, eventCause.description, failure.description, date from Fault f where mccid.country = :country AND mccid.operator = :operator AND cell.cellId = :cellid")
				.setParameter("country", "India")
				.setParameter("operator", "Reliance Infocomm-IN")
				.setParameter("cellid", 1))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(faultsForCell);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getFaultsForCell("India", "Reliance Infocomm-IN", 1);
		assertSame(faultsForCell, faults);
	}

//	@Test
	public void testGetFaultsForModelCombo() {
		List<Fault> faultsForModel = new ArrayList<Fault>();
		when(mockedEM.createQuery("select distinct imsi, eventCause.causeCode, eventCause.eventId, eventCause.description, failure.description, date from Fault f where tac.model = :model AND eventCause.eventId = :eventid AND eventCause.causeCode = :causecode")
				.setParameter("model", "Mitsubishi GSM MT 20 Type MT 1171FD2")
				.setParameter("eventid", 4098)
				.setParameter("causecode", 1))
				.thenReturn(mockedQuery);
		when(mockedQuery.getResultList()).thenReturn(faultsForModel);
		List<Fault> faults = (List<Fault>)faultServiceEjb.getFaultsForModelCombo("Mitsubishi GSM MT 20 Type MT 1171FD2", 4098, 1);
		assertSame(faultsForModel, faults);
	}

//	@Test
	public void testGetAllModels() {
		List<String> models = new ArrayList<String>();
		when(mockedEM.createQuery("Select u.model from UE u"));
		when(mockedQuery.getResultList()).thenReturn(models);
		List<String> m = (List<String>)faultServiceEjb.getAllModels();
		assertSame(models, m);
	}

//	@Test
	public void testGetFailureDescriptions() {
		List<String> failureDesc = new ArrayList<String>();
		when(mockedEM.createQuery("Select f.description from Failure f"));
		when(mockedQuery.getResultList()).thenReturn(failureDesc);
		List<String> fails = (List<String>)faultServiceEjb.getFailureDescriptions();
		assertSame(failureDesc, fails);
	}

//	@Test
	public void testGetIMSIS() {
		List<Long> imsis = new ArrayList<Long>();
		when(mockedEM.createQuery("Select distinct f.imsi from Fault f"));
		when(mockedQuery.getResultList()).thenReturn(imsis);
		List<Long> i = (List<Long>)faultServiceEjb.getIMSIS();
		assertSame(imsis, i);
	}

}
