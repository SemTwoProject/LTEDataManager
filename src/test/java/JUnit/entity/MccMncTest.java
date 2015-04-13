package JUnit.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.entity.Fault;
import com.entity.MccMnc;

public class MccMncTest {
	
	MccMnc mccMnc1;
	MccMnc mccMncSame;
	MccMnc mccMncEmpty;
	
	
	@Before
	public void setUp() throws Exception {
		mccMnc1 = new MccMnc(4322, "Country", 382, "Operator");
		mccMncSame = new MccMnc(4322, "Country", 382, "Operator");
		mccMncEmpty = new MccMnc();
	}

	@Test
	public void testEquals_Symetric() {
		assertEquals(mccMnc1.equals(mccMncSame),mccMncSame.equals(mccMnc1));
		assertEquals(mccMnc1.hashCode(),mccMncSame.hashCode());
	}

	@Test
	public void testMccMncEmpty() {
		assertEquals(mccMncEmpty.getClass(),MccMnc.class);
	}

	@Test
	public void testMccMncIntegerStringIntegerString() {
		assertEquals(mccMnc1.getClass(), MccMnc.class);
	}

	@Test
	public void testGetandSetMccId() {
		int mccId = 13;
		int val;
		mccMncEmpty.setMccId(mccId);
		val = mccMncEmpty.getMccId();
		assertEquals(mccId, val);
	}

	@Test
	public void testGetandSetMncId() {
		int mncId = 938;
		int val;
		mccMncEmpty.setMncId(mncId);
		val = mccMncEmpty.getMncId();
		assertEquals(mncId, val);
	}

	@Test
	public void testGetCountry() {
		String country = "Country";
		String val;
		mccMncEmpty.setCountry(country);
		val = mccMncEmpty.getCountry();
		assertEquals(country, val);
	}

	@Test
	public void testGetOperator() {
		String operator = "Operator";
		String val;
		mccMncEmpty.setOperator(operator);
		val = mccMncEmpty.getOperator();
		assertEquals(operator, val);
	}

	@Test
	public void testGetandSetFaultList() {
		List<Fault> faultList = new ArrayList<Fault>();
		List<Fault> val;
		mccMncEmpty.setFaultList(faultList);
		val = mccMncEmpty.getFaultList();
		assertEquals(faultList, val);
	}
	
	@Test
	public void testAddFault() {
		List<Fault> faultList = new ArrayList<Fault>();
		Fault fault = new Fault();
		Fault val;
		mccMncEmpty.setFaultList(faultList);
		mccMncEmpty.addFault(fault);
		val = mccMncEmpty.getFaultList().get(0);
		assertEquals(val, fault);
	}

}
