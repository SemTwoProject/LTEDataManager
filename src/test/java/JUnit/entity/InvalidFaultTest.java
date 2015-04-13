package JUnit.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.entity.InvalidFault;

public class InvalidFaultTest {
	
	InvalidFault invalidEmpty;
	InvalidFault invalid;
	
	@Before
	public void setUp() throws Exception {
		invalidEmpty = new InvalidFault();
		invalid = new InvalidFault(8, new Date(), "St", "St", "St", "St", "St", "St", "St", "St", "St", "St");
	}

	@Test
	public void testInvalidFaultEmptyConstuctor() {
		assertEquals(invalidEmpty.getClass(), InvalidFault.class);
	}

	@Test
	public void testInvalidFault() {
		assertEquals(invalidEmpty.getClass(), InvalidFault.class);
	}

}
