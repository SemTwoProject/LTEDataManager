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

import dao.DurationDAO;

@RunWith(Arquillian.class)
public class DurationEJBTest {

	@EJB
	private DurationDAO dao;

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
	public void durationsListIsReturned() {
		assertEquals(dao.getDuration().size(), 1);
	}

	@Test
	public void durationIsReturnedByValue() {
		int y = 1000;
		int x = dao.getByDuration(y).getDuration();
		assertEquals(x, y);
	}

}
