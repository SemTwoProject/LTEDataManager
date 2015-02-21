package arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;

import dao.EventCauseDAO;
import dao.FailureDAO;
import dao.FaultDAO;
import entities.CellHier;
import entities.EventCause;
import entities.Failure;
import entities.Fault;


public class FailureDAOTest {

	
	@EJB
	FailureDAO failureDao;
	FaultDAO faultDao;
	
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
	public void FailureListIsReturned() {
		assertEquals(failureDao.getFailure(), 3);
	}

	@Test
	public void FailureIsReturnedByFailure() {
		Failure fail = failureDao.getByFailure(1234);
		int x = fail.getId();
		int y = 1;
		assertEquals(1,x);
	}
	@Test
	public void FailureIsReturnedByFault() {
		Fault f = faultDao.getById(1234);
		Failure fail = (Failure)failureDao.getFailureByFault(f).iterator().next();
		int x = 1;
		int y = fail.getId();
		assertEquals(x, y);
	}

}
