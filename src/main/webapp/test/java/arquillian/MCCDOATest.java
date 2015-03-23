package arquillian;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;

import com.dao.MCCDAO;
import com.entity.MccMnc;

public class MCCDOATest {

	@EJB
	private MCCDAO dao;

	@Deployment
	public WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}

	@Before
	public void setUp() {
	}		

	@Test
	public void MCCListReturned() {
		assertEquals(dao.getMCC().size(), 3);
	}

	@Test
	public void CountryIsReturnedByMCCValue() {
		int x = 301;
		int y = 500;
		int z = 404;
		
		String uSA = new String("United States");
		String germany = new String("Germany");
		String india = new String("India");
				
		MccMnc testUnitedStates = dao.getByMCC(x);
		MccMnc testGermany = dao.getByMCC(y);
		MccMnc testIndia = dao.getByMCC(z);
		
		assertEquals(uSA, testUnitedStates.getCountry());
		assertEquals(germany, testGermany.getCountry());
		assertEquals(india, testIndia.getCountry());
		
	}
}
