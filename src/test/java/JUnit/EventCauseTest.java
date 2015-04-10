package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.entity.EventCause;
import com.entity.Fault;

public class EventCauseTest {
	
	EventCause event1;
	EventCause eventSame;
	EventCause emptyEvent;
	
	@Before
	public void setUp(){
		event1 = new EventCause(1, 4106,"INITIAL CTXT SETUP-UNSPECIFIED");
		eventSame = new EventCause(1, 4106,"INITIAL CTXT SETUP-UNSPECIFIED");
		emptyEvent = new EventCause();
	}
	@Test
	public void testEquals_Symmetric() {
		assertTrue(event1.equals(eventSame) && eventSame.equals(event1));
		assertTrue(event1.hashCode() == eventSame.hashCode());
	}

	@Test
	public void testEventCauseEmptyConstuctor() {
		EventCause empty = new EventCause();
		assertTrue(empty.getClass().equals(EventCause.class));
	}

	@Test
	public void testEventCauseConstructor() {
		EventCause cause = new EventCause(5, 83829, "A Description");
		assertTrue(cause.getClass().equals(EventCause.class));
	}

	@Test
	public void testGetandSetEventId() {
		int id = 9;
		int val;
		emptyEvent.setEventId(id);
		val = emptyEvent.getEventId();
		assertEquals(id, val);
	}

	@Test
	public void testGetandSetEvent() {
		int causeCode = 34828;
		int val;
		emptyEvent.setEvent(causeCode);
		val = emptyEvent.getCauseCode();
		assertEquals(val, causeCode);
	}

	@Test
	public void testGetandSetDescription() {
		String description = "Some Description";
		String val;
		emptyEvent.setDescription(description);
		val = emptyEvent.getDescription();
		assertEquals(description, val);
	}

	@Test
	public void testGetandSetCauseCode() {
		int causeCode =  28399;
		int val;
		emptyEvent.setCauseCode(causeCode);
		val = emptyEvent.getCauseCode();
		assertEquals(causeCode, val);
	}

	@Test
	public void testGetandSetFaultList() {
		List<Fault> faultList = new ArrayList<Fault>();
		List<Fault> val;
		emptyEvent.setFaultList(faultList);
		val = emptyEvent.getFaultList();
		assertEquals(faultList, val);
	}

	@Test
	public void testAddFault() {
		List<Fault> faultList = new ArrayList<Fault>();
		Fault fault = new Fault();
		Fault val;
		emptyEvent.setFaultList(faultList);
		emptyEvent.addFault(fault);
		val = emptyEvent.getFaultList().get(0);
		assertEquals(val, fault);
		
	}
}
