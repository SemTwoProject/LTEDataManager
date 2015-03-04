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

import com.dao.IMSIDAO;
import com.entity.IMSI;

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
		assertEquals(dao.getIMSI().size(), 6);
	}

	@Test
	public void IMSIIsReturnedByIMSI() {
		IMSI imsi = dao.getByIMSI(240210000000013L);
		int y = 8;
		int x = imsi.getId();
		assertEquals(y,x);
	}

}
