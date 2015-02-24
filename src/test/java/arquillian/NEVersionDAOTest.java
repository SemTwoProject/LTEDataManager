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
		int verizon = 1111;
		int three = 2222;
		int o2 = 3333;
		int telephonica = 4444;
		int vodafone = 5555;
				
		int testVerizon = dao.getByNE(verizon).getNe();
		int testThree = dao.getByNE(three).getNe();
		int testO2 = dao.getByNE(o2).getNe();
		int testTelephonica = dao.getByNE(telephonica).getNe();
		int testVodafone = dao.getByNE(vodafone).getNe();

		assertEquals(verizon, testVerizon);
		assertEquals(three, testThree);
		assertEquals(o2, testO2);
		assertEquals(telephonica, testTelephonica);
		assertEquals(vodafone, testVodafone);
	}

}
