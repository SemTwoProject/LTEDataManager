package arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.List;

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
	
	Integer byFailure1;
	Integer byFailure2;
	
	String byFailureString1;
	String byFailureString2;
	
	List<Failure> failuresList1;
	
	//Collection<Failure> f1;
	Fault f2;
	Fault f3;
	
	Collection<Object> failureByFaultList1;
	Collection<Failure> failureByFaultList2;
	Collection<Failure> failureByFaultList3;
	
	Failure byFailuresList1;
	Failure byFailuresList2;
	
	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}
	
	@Before
	public void setUp() {
		
		//f1 = failureDao.getFailure();
		
		byFailure1 = 1;
		byFailure2 = 6;
		
		byFailureString1 = "HIGH PRIORITY ACCESS";
		byFailureString2 = null;
		
		failuresList1 = (List<Failure>)failureDao.getFailure();
		
		byFailuresList1 = failureDao.getByFailure(byFailure1);
		//byFailuresList2 = failureDao.getByFailure(byFailure2);
		
		//failureByFaultList1 = failureDao.getFailureByFault(f1);
	}

	@Test
	public void FailureListIsReturned() {
		assertEquals(failureDao.getFailure().size(), 5);
	}
	
	@Test
	public void getFailureTest(){
		assertFalse(failuresList1.isEmpty());
	}
	
	@Test
	public void getByFailureTest(){
		assertFalse(byFailuresList1.equals(byFailureString1));
		//assertTrue(byFailuresList2.getClass().equals(Failure.class));
	}
	
//	@Test
//	public void getFailureByFaultTest(){
//		assertFalse(failureByFaultList1.isEmpty());
//	}
}
