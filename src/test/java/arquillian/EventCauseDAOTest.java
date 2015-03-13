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

import com.dao.EventCauseDAO;
import com.dao.FaultDAO;
import com.entity.EventCause;


@RunWith(Arquillian.class)

public class EventCauseDAOTest {

	@EJB
	EventCauseDAO eventDao;

	FaultDAO faultDao;

	//FaultDAO faultDao;
	EventCauseDAO eventIdDao;
	
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
	
	}
		
	@Test
	public void EventCauseReturnedByEvent() {
		EventCause ec = eventDao.getByEventCause(2);
		assertEquals("Test Cause Three", ec.getDescription());
	}

	@Test
	public void EventCauseReturnedByFault() {
		
	}
	/*@Test
	public void EventCauseReturnedByFault(){
		Fault fault = faultDao.getById(1);
		EventCause ec = (EventCause) eventDao.getEventCauseByFault(fault)
				.get(0);
		int x = 1111;
		int y = 1111;
		assertEquals(x, y);

	}
		EventId eventId = eventIdDao.getByEventId(ec.getEventId().getEventId());
		int y = eventId.getEventId();
		assertEquals(x,y);
		
	}*/

}
