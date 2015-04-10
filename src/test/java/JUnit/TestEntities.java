package JUnit;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.entity.CellHier;
import com.entity.EventCause;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.MarketOperator;
import com.entity.MccMnc;
import com.entity.UE;
import com.entity.User;

public class TestEntities
{
	Fault f;
	MarketOperator mo;
	MccMnc m;
	UE ue;
	User u;
	
	
	@Before
	public void setUp() throws Exception
	{
		f = new Fault();
		mo = new MarketOperator();
		m = new MccMnc();
		ue = new UE();
		u = new User();
	}
	
	@After
	public void tearDown() throws Exception
	{
		f = null;
		mo = null;
		m = null;
		ue = null;
		u = null;
	}
	
	@Test
	public void testFault()
	{
		f.setId(1);
		f.setImsi(1234l);
		f.setDate(new Date());
		f.setNe("11B");
		f.setDuration(1000);
		assertEquals((int)f.getId(), 1);
		assertEquals((long)f.getImsi(), 1234l);
		assertEquals(f.getDate(), new Date());
		assertEquals(f.getNe(), "11B");
		assertEquals((int)f.getDuration(), 1000);
		f.setFailure(new Failure(0, "Emergency"));
		f.setTac(new UE());
		f.setCell(new CellHier(4, 123l, 124l, 125l));
		f.setMccid(new MccMnc(238, "Denmark", 1, "TDC-DK"));
		f.setEventCause(new EventCause(0, 4097, "RRC CONN-SETUP"));
		assertEquals((int)f.getFailure().getfailure(), 0);
		assertEquals((int)f.getCell().getCellId(), 4);
		assertEquals((int)f.getMccid().getMccId(), 238);
		assertEquals((int)f.getEventCause().getEventId(), 4097);
		
	}
	
	@Test
	public void testMarketOperator()
	{
		mo.setMccId(238);
		mo.setMncId(1);
		assertEquals((int)mo.getMccId(), 238);
		assertEquals((int)mo.getMncId(), 1);
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
