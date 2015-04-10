package arquillian;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
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

import com.dao.UEDAO;
import com.entity.Fault;
import com.entity.UE;

@RunWith(Arquillian.class)
public class UEDAOTest {

	@EJB
	private UEDAO dao;
	
	String model1;
	String model2;
	
	Integer tac1;
	Integer tac2;
	Integer tac3;
	
	UE device1;
	UE device2;
	UE device3;
	
	List<UE> getUEList;
	
	List<Fault> getEventCausePerModel1;
	List<Fault> getEventCausePerModel2;
	List<Fault> getEventCausePerModel3;

	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}

	@Before
	public void setUp() {
		
		tac1 = 102300;
		tac2 = 108100;
		tac3 = 33000153;
		
		model1 = "Fake";
		model2 = "VEA3";
		
		getEventCausePerModel1 = (List<Fault>) dao.getEventCausePerModel(model1);
		getEventCausePerModel2 = (List<Fault>) dao.getEventCausePerModel(model2);

	}		

	@Test
	public void getUETest() {
		assertFalse(getUEList.size() < 1);
	}

	@Test
	public void getByTacTest() {
		assertFalse(device1.getModel().equals("fakeModel"));
		assertTrue(device2.getClass().equals(UE.class));
		assertTrue(device3.getClass().equals(UE.class));
	}
	
	@Test
	public void getEventCausePerModelTest(){
		assertTrue(getEventCausePerModel1.isEmpty());
		assertFalse(getEventCausePerModel2.isEmpty());
	}

}
