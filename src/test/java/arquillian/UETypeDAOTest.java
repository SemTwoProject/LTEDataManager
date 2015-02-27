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

import com.dao.UETypeDAO;

public class UETypeDAOTest {

	@EJB
	private UETypeDAO dao;

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
		assertEquals(dao.getUEType().size(), 3);
	}

	@Test
	public void NEIsReturnedByNEVersionValue() {
		String ue1 = new String("LandLine");
		String ue2 = new String("Mobile");
		String ue3 = new String("Tablet");
				
		String testUe1 = dao.getByUEType(ue1).getUeType();
		String testUe2 = dao.getByUEType(ue2).getUeType();
		String testUe3 = dao.getByUEType(ue3).getUeType();
	
		assertEquals(ue1, testUe1);
		assertEquals(ue2, testUe2);
		assertEquals(ue3, testUe3);
	}
}
