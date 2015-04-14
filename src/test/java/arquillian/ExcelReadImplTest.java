package arquillian;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.ExcelDAO;
import com.entity.Failure;
import com.entity.Fault;

@RunWith(Arquillian.class)
public class ExcelReadImplTest {

	@EJB
	private ExcelDAO dao;
	
	private ArrayList<Fault> correctFaults;
	private ArrayList<Fault> erroneousFaults;
	private Fault correctOne;
	private Fault errorOne;

	@Deployment
	public static WebArchive createDeployment() {
		File[] files = Maven.resolver().resolve("org.apache.poi:poi:3.11").withTransitivity().asFile();

		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true,"com")
				.addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addAsLibraries(files);
	}

	@Before
	public void setUp() {
		correctFaults = new ArrayList<Fault>();
		erroneousFaults =  new ArrayList<Fault>();
		correctOne = new Fault();
		Failure fail = new Failure();
		fail.setfailure(1);
		correctOne.setFailure(fail);
		correctFaults.add(correctOne);
		errorOne = new Fault();
		erroneousFaults.add(errorOne);
		}

	@Test
	public void testValidationRemovesInvalid() {
		
		assertNotNull(correctFaults);
	}
	@Test
	public void testCreateCell(){
		
	}
	@Test
	public void testEventCause(){
		
	}
	@Test
	public void testFailure(){
		
	}
	@Test
	public void testMccMnc(){
		
	}
	@Test
	public void testUE(){
		
	}
	@Test
	public void testFault(){
		
	}
}