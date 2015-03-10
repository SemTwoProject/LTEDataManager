package arquillian;

import static org.junit.Assert.assertEquals;

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

import com.dao.CellDAO;
import com.dao.FaultDAO;
import com.entity.CellHier;
import com.entity.Fault;

@RunWith(Arquillian.class)
public class FaultDAOTest {

	@EJB
	FaultDAO faultDao;
	CellDAO cellDao;
	
	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}
	@Before
	public void setUp() {
		
	}

	/*@Test
	public void FaultListIsReturned() {
	
	}

	@Test
	public void FaultIsReturnedById() {
		Fault f = faultDao.getById(1);
		CellHier cell = f.getCell();
		int y = 4;
		int x = cell.getCellId();
		assertEquals(y,x);
	}*/
	/*@Test
	public void FaultIsReturnedByIMSI() {
		Fault f = faultDao.getFaultByIMSI(new Long("11000000000003"));
		int x = f.getId();
		There is more than one fault per imsi. so needs to return a list. 
	}*/
	@Test
	public void getImsiPerFailureTest(){
		int failure = 3;
		Long imsi = 191911000423411L;
		
		Collection<Fault> f = faultDao.getImsiPerFailure(failure);
		//the actual result is out of bounds for type int
		assertEquals(imsi, f);
	}
	

}
