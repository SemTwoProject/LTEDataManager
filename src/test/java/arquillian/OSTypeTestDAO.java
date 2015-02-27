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

import com.dao.OSTypeDAO;

@RunWith(Arquillian.class)
public class OSTypeTestDAO {

	@EJB
	private OSTypeDAO dao;

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
		assertEquals(dao.getOSType().size(), 3);
	}

	@Test
	public void NEIsReturnedByNEVersionValue() {
		String android = new String("Android");
		String iOS = new String("iOS");
		String windows8 = new String("Windows 8");
				
		String testAndroid = dao.getByOSType(android).getOs();
		String testiOS = dao.getByOSType(iOS).getOs();
		String testwindows8 = dao.getByOSType(windows8).getOs();
		
		assertEquals(android, testAndroid);
		assertEquals(iOS, testiOS);
		assertEquals(windows8, testwindows8);
	}

}
