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

import com.dao.FailureDAO;
import com.dao.FaultDAO;
import com.entity.Failure;
import com.entity.Fault;

@RunWith(Arquillian.class)
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
		assertEquals(failureDao.getFailure().size(), 5);
	}

	@Test
	public void FailureIsReturnedByFailure() {
		Failure fail = failureDao.getByFailure(0);
		int x = fail.getId();
		int y = 1;
		assertEquals(1,x);
	}
	
	/*
	@Test
	public void FailureIsReturnedByFault() {
		Fault f = faultDao.getById(1234);
		Failure fail = (Failure)failureDao.getFailureByFault(f).iterator().next();
		int x = 1;
		int y = fail.getId();
		assertEquals(x, y);
	}*/

}
