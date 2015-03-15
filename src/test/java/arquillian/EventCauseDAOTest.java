package arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;

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


@RunWith(Arquillian.class)

public class EventCauseDAOTest {

	@EJB
	EventCauseDAO eventDao;
	@EJB
	FaultDAO faultDao;

	//FaultDAO faultDao;
	@EJB
	EventCauseDAO eventIdDao;
	
	
	
	Collection<EventCause> cause1;
	Collection<EventCause> cause2;
	Collection<EventCause> cause3;
	
	Collection<EventCause> cause4;
	Collection<EventCause> cause5;
	Collection<EventCause> cause6;
	
	Collection<EventCause> cause7;
	Collection<EventCause> cause8;
	Collection<EventCause> cause9;
	
	
	Integer causeID1;
	Integer causeID2;
	Integer causeID3;
	
	Integer eventID1;
	Integer eventID2;
	Integer eventID3;
	
	Fault fault1;
	Fault fault2;
	Fault fault3;
	
	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}

	@Before
	public void setUp() {
		
		fault1 = faultDao.getById(748);
		fault2 = faultDao.getById(445);
		fault3 = faultDao.getById(343);
		
		causeID1 = 0;
		causeID2 = 2;
		causeID3 = 66; //invalid
		
		eventID1 = 4125;
		eventID2 = 4106;
		eventID3 = 1010;//invalid
		
//		cause1 = eventDao.getEventCause(causeID1);
//		cause2 = eventDao.getEventCause(causeID2);
//		cause3 = eventDao.getEventCause(causeID3);
		
//		cause4 = eventDao.getByEventCause(eventID1);
//		cause5 = eventDao.getByEventCause(eventID2);
//		cause6 = eventDao.getByEventCause(eventID3);
		
		cause7 = eventDao.getEventCauseByFault(fault1);
		cause8 = eventDao.getEventCauseByFault(fault2);
		cause9 = eventDao.getEventCauseByFault(fault3);
	}

//	@Test
//	public void getEventCauseTest() {
//		assertFalse(cause1.isEmpty());
//		assertFalse(cause2.isEmpty());
//		assertTrue(cause3.isEmpty());
//	}

//	@Test
//	public void getByEventCause(){
//		assertFalse(cause4.isEmpty());
//		assertFalse(cause5.isEmpty());
//		assertTrue(cause6.isEmpty());
//	}
	@Test
	public void getEventCauseByFault(){
		assertFalse(cause7.isEmpty());
		assertFalse(cause8.isEmpty());
		assertFalse(cause9.isEmpty());
	}
	
}
