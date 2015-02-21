package arquillian;

import static org.junit.Assert.*;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;

import dao.EventCauseDAO;
import dao.EventIdDAO;
import entities.CellHier;
import entities.EventCause;
import entities.EventId;


public class EventIdDAOTest {

	
	@EJB
	EventIdDAO dao;
	
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
	public void EventCauseListIsReturned() {
		assertEquals(dao.getEventId(), 3);
	}

	@Test
	public void CellIsReturnedById() {
		EventId e = dao.getByEventId(1111);
		int x = 1;
		int y = e.getId();
		assertEquals(x,y);
	}

}
