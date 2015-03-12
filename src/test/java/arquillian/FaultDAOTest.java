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

import com.dao.CellDAO;
import com.dao.FaultDAO;
import com.entity.Fault;

@RunWith(Arquillian.class)
public class FaultDAOTest {

	@EJB
	FaultDAO faultDao;
	CellDAO cellDao;
	
	Long imsi;
	
	int failure;
	int failure1;
	int failure2;
	
	List<Fault> f;
	List<Fault> f1;
	List<Fault> f2;
	
	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}
	@Before
	public void setUp() {
		
		imsi = 191911000423411L;
		
		failure = 3;
		failure1 = 366;
		failure2 = 0;
		
		f = (List<Fault>) faultDao.getImsiPerFailure(failure);
		f1 = (List<Fault>) faultDao.getImsiPerFailure(failure1);
		f2 = (List<Fault>) faultDao.getImsiPerFailure(failure2);
	}

	
	@Test
	public void getImsiPerFailureTest(){
		
		assertEquals(imsi, f.get(0));
	}
	
	@Test
	public void imsiCollectionSizeTest(){
				
		assertEquals(0, f1.size());
		assertTrue(f2.size() > 1);
	}
	

}
