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

import com.dao.NEVersionDAO;

@RunWith(Arquillian.class)
public class NEVersionDAOTest {

	@EJB
	private NEVersionDAO dao;

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
		assertEquals(dao.getNEVersion().size(), 5);
	}

	@Test
	public void NEReturnedByNEVersionValue() {
		String verizon = "1111";
		String three = "2222";
		String o2 = "3333";
		String telephonica = "4444";
		String vodafone = "5555";
				
		String testVerizon = dao.getByNE(verizon).getNe();
		String testThree = dao.getByNE(three).getNe();
		String testO2 = dao.getByNE(o2).getNe();
		String testTelephonica = dao.getByNE(telephonica).getNe();
		String testVodafone = dao.getByNE(vodafone).getNe();

		assertEquals(verizon, testVerizon);
		assertEquals(three, testThree);
		assertEquals(o2, testO2);
		assertEquals(telephonica, testTelephonica);
		assertEquals(vodafone, testVodafone);
	}

}
