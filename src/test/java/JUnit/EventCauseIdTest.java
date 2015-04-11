/*package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.entity.EventCauseId;

public class EventCauseIdTest {
	
	EventCauseId idSame;
	EventCauseId emptyId;
	
	@Before
	public void setUp() throws Exception {
		emptyId = new EventCauseId();
		idSame = new EventCauseId();
	}

	@Test
	public void testEquals_Symmetric() {
		assertEquals(emptyId.equals(idSame),idSame.equals(emptyId));
		assertEquals(emptyId.hashCode(),idSame.hashCode());
	}

	@Test
	public void testEventCauseId() {
		EventCauseId id = new EventCauseId();
		assertTrue(id.getClass().equals(EventCauseId.class));
	}

	@Test
	public void testGetandSetCauseCode() {
		int causeCode = 88483;
		int val;
		emptyId.setCauseCode(causeCode);
		val = emptyId.getCauseCode();
		assertEquals(causeCode, val);
	}

	@Test
	public void testGetandSetEventId() {
		int id = 8;
		int val;
		emptyId.setEventId(8);
		val = emptyId.getEventId();
		assertEquals(id, val);

	}
}
*/