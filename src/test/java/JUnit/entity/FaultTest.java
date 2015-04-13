package JUnit.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.jboss.util.collection.EmptyCollectionException;
import org.junit.Before;
import org.junit.Test;

import com.entity.CellHier;
import com.entity.EventCause;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.MccMnc;
import com.entity.UE;

public class FaultTest {
	Fault fault1;
	Fault sameFault;
	Fault emptyFault;

	@Before
	public void setUp() throws Exception {
		fault1 = new Fault();
		fault1.setId(1);
		fault1.setImsi(1234l);
		fault1.setDate(new Date());
		fault1.setNe("11B");
		fault1.setDuration(1000);
		
		fault1.setFailure(new Failure(0, "Emergency"));
		fault1.setTac(new UE());
		fault1.setCell(new CellHier(4, 123l, 124l, 125l));
		fault1.setMccid(new MccMnc(238, "Denmark", 1, "TDC-DK"));
		fault1.setEventCause(new EventCause(0, 4097, "RRC CONN-SETUP"));
		
		sameFault = new Fault();
		sameFault.setId(1);
		sameFault.setImsi(1234l);
		sameFault.setDate(new Date());
		sameFault.setNe("11B");
		sameFault.setDuration(1000);
		
		sameFault.setFailure(new Failure(0, "Emergency"));
		sameFault.setTac(new UE());
		sameFault.setCell(new CellHier(4, 123l, 124l, 125l));
		sameFault.setMccid(new MccMnc(238, "Denmark", 1, "TDC-DK"));
		sameFault.setEventCause(new EventCause(0, 4097, "RRC CONN-SETUP"));
		
		emptyFault = new Fault();
	}

	@Test
	public void testEquals_Symetric() {
		assertEquals(fault1.equals(sameFault),sameFault.equals(fault1));
		assertEquals(fault1.hashCode(),sameFault.hashCode());
	}
	
	@Test
	public void testFaultEmptyConstructor() {
		Fault empty = new Fault();
		assertTrue(empty.getClass().equals(Fault.class));
	}

	@Test
	public void testFaultFaultConstructor() {
		Fault fault = new Fault(1,new Date(), 33,1,2323,22,33,new CellHier(),1000,2,"R2323R",2323132L); 
		assertTrue(fault.getClass().equals(Fault.class));
	}
	

	@Test
	public void testGetAndSetId() {
		int id = 10;
		int val;
		emptyFault.setId(id);
		val = emptyFault.getId();
		assertEquals(id, val);
	}

	@Test
	public void testGetAndSetDate() {
		Date newDate = new Date();
		Date val;
		emptyFault.setDate(newDate);
		val = emptyFault.getDate();
		assertEquals(newDate,val);
	}

	@Test
	public void testGetAndSetNe() {
		String ne = "r222";
		String val;
		emptyFault.setNe(ne);
		val = emptyFault.getNe();
		assertEquals(ne,val);
	}

	@Test
	public void testGetAndSetImsi() {
		Long imsi = 23232L;
		Long val;
		emptyFault.setImsi(imsi);
		val = emptyFault.getImsi();
		assertEquals(imsi,val);
	}

	@Test
	public void testGetAndSetDuration() {
		int duration = 1000;
		int val;
		emptyFault.setDuration(duration);
		val = emptyFault.getDuration();
		assertEquals(duration,val);
	}

	@Test
	public void testGetAndSetFailure() {
		Failure failure = new Failure();
		Failure val;
		emptyFault.setFailure(failure);
		val = emptyFault.getFailure();
		assertEquals(failure,val);
	}

	@Test
	public void testGetAnsSetTac() {
		UE tac = new UE();
		UE val;
		emptyFault.setTac(tac);
		val = emptyFault.getTac();
		assertEquals(tac,val);
	}

	@Test
	public void testGetAndSetMccid() {
		MccMnc mcc = new MccMnc();
		MccMnc val;
		emptyFault.setMccid(mcc);
		val = emptyFault.getMccid();
		assertEquals(mcc,val);
	}

	@Test
	public void testGetAndSetCell() {
		CellHier cell = new CellHier();
		CellHier val;
		emptyFault.setCell(cell);
		val = emptyFault.getCell();
		assertEquals(cell,val);
	}

	@Test
	public void testGetEventAndSetCause() {
		EventCause eventCause = new EventCause();
		EventCause val;
		emptyFault.setEventCause(eventCause);
		val = emptyFault.getEventCause();
		assertEquals(eventCause,val);
	}
}
