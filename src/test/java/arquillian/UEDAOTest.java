package arquillian;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.UEDAO;

@RunWith(Arquillian.class)
public class UEDAOTest {

	@EJB
	private UEDAO dao;

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
	public void NEVersionListReturned() {
		assertEquals(dao.getUE().size(), 5);
	}

	@Test
	public void NEIsReturnedByNEVersionValue() {
		int tac1 = 1234567;
		int tac2 = 2345678;
		int tac3 = 3456789;
		int tac4 = 4567891;
		int tac5 = 5678912;
		
/*		//Access_Capability
		String AC_gSM1900 = new String("GSM 1900");
		
		//Manufacturer
		String man_samsung = new String("Samsung");
		
		//marketing_name
		
		//model
		
		//vendor_name
		
		//input_mode
		
		//os
		
		//ue_type
		 * 
		 */
				
		int tac1Test = dao.getByTac(tac1).getTac();
		int tac2Test = dao.getByTac(tac2).getTac();
		int tac3Test = dao.getByTac(tac3).getTac();
		int tac4Test = dao.getByTac(tac4).getTac();
		int tac5Test = dao.getByTac(tac5).getTac();
		
		assertEquals(tac1, tac1Test);
		assertEquals(tac2, tac2Test);
		assertEquals(tac3, tac3Test);
		assertEquals(tac4, tac4Test);
		assertEquals(tac5, tac5Test);

	}

}
