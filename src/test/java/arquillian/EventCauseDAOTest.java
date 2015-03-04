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
import com.entity.Fault;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
@RunWith(Arquillian.class)
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
public class EventCauseDAOTest {

	@EJB
	EventCauseDAO eventDao;
<<<<<<< HEAD
	FaultDAO faultDao;

<<<<<<< HEAD
=======
=======
	//FaultDAO faultDao;
	EventIdDAO eventIdDao;
	
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
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
		assertEquals(eventDao.getEventCause().size(), 3);
	}
		
	@Test
	public void EventCauseReturnedByEvent() {
		EventCause ec = eventDao.getByEventCause(2);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
		assertEquals("Test Cause Three", ec.getDescription());
	}

	@Test
	public void EventCauseReturnedByFault() {
<<<<<<< HEAD
=======
=======
		assertEquals("UE CTXT RELEASE-DETACH",ec.getDescription());
	}
	/*@Test
	public void EventCauseReturnedByFault(){
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
		Fault fault = faultDao.getById(1);
		EventCause ec = (EventCause) eventDao.getEventCauseByFault(fault)
				.get(0);
		int x = 1111;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
		int y = 1111;
		assertEquals(x, y);

	}
<<<<<<< HEAD
=======
=======
		EventId eventId = eventIdDao.getByEventId(ec.getEventId().getEventId());
		int y = eventId.getEventId();
		assertEquals(x,y);
		
	}*/
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18

}
