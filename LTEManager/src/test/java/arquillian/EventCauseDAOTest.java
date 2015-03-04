package arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;

import dao.EventCauseDAO;
import dao.EventIdDAO;
import dao.FaultDAO;
import entities.CellHier;
import entities.EventCause;
import entities.EventId;
import entities.Fault;


public class EventCauseDAOTest {

	
	@EJB
	EventCauseDAO eventDao;
	FaultDAO faultDao;
	EventIdDAO eventIdDao;
	
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
		assertEquals(eventDao.getEventCause(), 5);
	}

	@Test
	public void EventCauseReturnedByEvent() {
		EventCause ec = eventDao.getByEventCause(2);
		assertEquals("Test Cause Three",ec.getDescription());
	}
	@Test
	public void EventCauseReturnedByFault(){
		Fault fault = faultDao.getById(1);
		EventCause ec = (EventCause)eventDao.getEventCauseByFault(fault).get(0);
		int x = 1111;
		EventId eventId = eventIdDao.getByEventId(ec.getEventId().getEventId());
		int y = eventId.getEventId();
		assertEquals(x,y);
		
	}

}
