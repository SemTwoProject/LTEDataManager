package arquillian;

import static org.junit.Assert.*;

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

import dao.IMSIDAO;
import entities.CellHier;
import entities.Fault;
import entities.IMSI;

@RunWith(Arquillian.class)
public class IMSIDAOTest {

	@EJB
	IMSIDAO dao;
	
	
	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}
	
	
	@Before
	public void setUp() {
		
	}

	@Test
	public void IMSIListIsReturned() {
		assertEquals(dao.getIMSI().size(), 7);
	}

	@Test
	public void IMSIIsReturnedByIMSI() {
		IMSI imsi = dao.getByIMSI(new Long("33000000000003"));
		int y = 3;
		int x = imsi.getId();
		assertEquals(y,x);
	}

}
