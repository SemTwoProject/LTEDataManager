package junit;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.entity.MccMnc;
import com.entity.UE;
import com.entity.User;

public class TestEntities
{

	MccMnc m;
	UE ue;
	User u;
	
	
	@Before
	public void setUp() throws Exception
	{
		m = new MccMnc();
		ue = new UE();
		u = new User();
	}
	
	@After
	public void tearDown() throws Exception
	{
		m = null;
		ue = null;
		u = null;
	}
	
	@Test
	public void testMccMnc()
	{
		m.setMccId(238);
		m.setCountry("Denmark");
		m.setMncId(1);
		m.setOperator("TDC-DK");
		assertEquals((int)m.getMccId(), 238);
		assertEquals(m.getCountry(), "Denmark");
		assertEquals((int)m.getMncId(), 1);
		assertEquals(m.getOperator(), "TDC-DK");
	}
	
	@Test
	public void testUE()
	{
		ue.setTac(100100);
		ue.setMarketingName("G410");
		ue.setManufacturer("Mitsubishi");
		ue.setAccessCapability("GSM 1800, GSM 900");
		ue.setModel("G410");
		ue.setVendorName("Mitsubishi");
		ue.setUeType("Handheld");
		ue.setOs("Blackberry");
		ue.setInputMode("QWERTY");
		assertEquals((int)ue.getTac(), 100100);
		assertEquals(ue.getMarketingName(), "G410");
		assertEquals(ue.getManufacturer(), "Mitsubishi");
		assertEquals(ue.getAccessCapability(), "GSM 1800, GSM 900");
		assertEquals(ue.getModel(), "G410");
		assertEquals(ue.getVendorName(), "Mitsubishi");
		assertEquals(ue.getUeType(), "Handheld");
		assertEquals(ue.getOs(), "Blackberry");
		assertEquals(ue.getInputMode(), "QWERTY");
	}
	
	@Test
	public void testUser()
	{
		u.setId(1);
		u.setName("Alan");
		u.setPassword("password");
		u.setUsername("AlanKavo");
		u.setUserType("System_Admin");
		assertEquals((int)u.getId(), 1);
		assertEquals(u.getName(), "Alan");
		assertEquals(u.getPassword(), "password");
		assertEquals(u.getUsername(), "AlanKavo");
		assertEquals(u.getUserType(), "System_Admin");
	}

}
