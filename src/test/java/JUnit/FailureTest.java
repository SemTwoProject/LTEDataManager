package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.entity.Failure;
import com.entity.Fault;

public class FailureTest {
	Failure failure1;
	Failure sameFailure;
	Failure empty;
	@Before
	public void setUp() throws Exception {
		failure1 = new Failure(3, "MO SIGNALLING");
		sameFailure = new Failure(3, "MO SIGNALLING");
		empty = new Failure();
	}

	@Test
	public void testEquals_Symmetric() {
		assertEquals(failure1.equals(sameFailure),sameFailure.equals(failure1));
		assertEquals(failure1.hashCode(),sameFailure.hashCode());
	}

	@Test
	public void testFailureEmptyConstructor() {
		Failure fail = new Failure();
		assertTrue(fail.getClass().equals(Failure.class));
	}

	@Test
	public void testFailureConstructor() {
		Failure fail = new Failure(5,"Failure Description");
		assertTrue(fail.getClass().equals(Failure.class));
	}

	@Test
	public void testGetandSetfailure() {
		int id = 10;
		int val;
		empty.setfailure(id);
		val = empty.getfailure();
		assertEquals(id, val);
	}

	@Test
	public void testGetandSetDescription() {
		String desc = "Some Failure Desc";
		String val;
		empty.setDescription(desc);
		val = empty.getDescription();
		assertEquals(desc, val);
	}

	@Test
	public void testGetandSetFaultList() {
		List<Fault> faultList = new ArrayList<Fault>();
		List<Fault> val;
		empty.setFaultList(faultList);
		val = empty.getFaultList();
		assertEquals(faultList,val);
	}

	@Test
	public void testAddFault() {
		List<Fault> faultList = new ArrayList<Fault>();
		empty.setFaultList(faultList);
		Fault fault = new Fault();
		Fault val;
		empty.addFault(fault);
		val = empty.getFaultList().get(0);
		assertEquals(val, fault);
	}

}
