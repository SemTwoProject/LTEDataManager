package JUnit.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.entity.Fault;
import com.entity.UE;

public class UETest {
	
	UE ue1;
	UE ueSame;
	UE ueEmpty;
	
	@Before
	public void setUp() throws Exception {
		ue1 = new UE(162, "marketingName", "manufacturer", "accessCapability", "model", "vendorName", "os", "inputMode", "ueType");
		ueSame = new UE(162, "marketingName", "manufacturer", "accessCapability", "model", "vendorName", "os", "inputMode", "ueType");
		ueEmpty = new UE();
	}

	@Test
	public void testEquals_Symetric() {
		assertEquals(ue1.equals(ueSame),ueSame.equals(ue1));
		assertEquals(ue1.hashCode(),ueSame.hashCode());
	}

	@Test
	public void testUEEmptyConstr() {
		assertEquals(ueEmpty.getClass(),UE.class);
	}

	@Test
	public void testUE() {
		assertEquals(ue1.getClass(), UE.class);
	}

	@Test
	public void testGetandSetTac() {
		int tac = 1379;
		int val;
		ueEmpty.setTac(tac);
		val = ueEmpty.getTac();
		assertEquals(tac, val);
	}

	@Test
	public void testGetandSetMarketingName() {
		String marketingName = "MarketingName";
		String val;
		ueEmpty.setMarketingName(marketingName);
		val = ueEmpty.getMarketingName();
		assertEquals(marketingName, val);
	}

	@Test
	public void testGetandSetManufacturer() {
		String manufacturer = "Manufacturer";
		String val;
		ueEmpty.setManufacturer(manufacturer);
		val = ueEmpty.getManufacturer();
		assertEquals(manufacturer, val);
	}
	
	@Test
	public void testGetandSetAccessCapability() {
		String accessCapability = "AccessCapability";
		String val;
		ueEmpty.setAccessCapability(accessCapability);
		val = ueEmpty.getAccessCapability();
		assertEquals(accessCapability, val);
	}


	@Test
	public void testGetModel() {
		String model = "Model";
		String val;
		ueEmpty.setModel(model);
		val = ueEmpty.getModel();
		assertEquals(model, val);
	}

	@Test
	public void testGetandSetVendorName() {
		String vendorName = "VendorName";
		String val;
		ueEmpty.setVendorName(vendorName);
		val = ueEmpty.getVendorName();
		assertEquals(vendorName, val);
	}

	@Test
	public void testGetandSetUeType() {
		String ueType = "UeType";
		String val;
		ueEmpty.setUeType(ueType);
		val = ueEmpty.getUeType();
		assertEquals(ueType, val);
	}


	@Test
	public void testGetandSetOs() {
		String os = "Os";
		String val;
		ueEmpty.setOs(os);
		val = ueEmpty.getOs();
		assertEquals(os, val);
	}

	@Test
	public void testGetInputMode() {
		String inputMode = "InputMode";
		String val;
		ueEmpty.setInputMode(inputMode);
		val = ueEmpty.getInputMode();
		assertEquals(inputMode, val);
	}
	@Test
	public void testGetandSetFaultList() {
		List<Fault> faultList = new ArrayList<Fault>();
		List<Fault> val;
		ueEmpty.setFaultList(faultList);
		val = ueEmpty.getFaultList();
		assertEquals(faultList, val);
	}
	@Test
	public void testAddFault() {
		List<Fault> faultList = new ArrayList<Fault>();
		Fault fault = new Fault();
		Fault val;
		ueEmpty.setFaultList(faultList);
		ueEmpty.addFault(fault);
		val = ueEmpty.getFaultList().get(0);
		assertEquals(val, fault);
	}
}
