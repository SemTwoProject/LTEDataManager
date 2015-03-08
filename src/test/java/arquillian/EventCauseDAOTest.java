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

<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
@RunWith(Arquillian.class)
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
=======

@RunWith(Arquillian.class)

>>>>>>> 47165db3f2d9ab5460f15f85d647c3131cead450
public class EventCauseDAOTest {

	@EJB
	EventCauseDAO eventDao;

	FaultDAO faultDao;
<<<<<<< HEAD

<<<<<<< HEAD
=======
=======
	//FaultDAO faultDao;
	EventIdDAO eventIdDao;
	
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
=======

	//FaultDAO faultDao;
	EventCauseDAO eventIdDao;
	
>>>>>>> 47165db3f2d9ab5460f15f85d647c3131cead450
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
<<<<<<< HEAD
		EventCause ec = eventDao.getByEventCause(2);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
=======
		EventCause ec = eventDao.getByEventCause(2);
>>>>>>> 47165db3f2d9ab5460f15f85d647c3131cead450
		assertEquals("Test Cause Three", ec.getDescription());
	}

	@Test
<<<<<<< HEAD
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
=======
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
>>>>>>> 47165db3f2d9ab5460f15f85d647c3131cead450
		EventId eventId = eventIdDao.getByEventId(ec.getEventId().getEventId());
		int y = eventId.getEventId();
		assertEquals(x,y);
		
<<<<<<< HEAD
	}*/
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
=======
	}*/
>>>>>>> 47165db3f2d9ab5460f15f85d647c3131cead450

}
