package arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Timestamp;
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
	
	Long imsi0;
	Long imsi1;
	Long imsi2;
	Long imsi3;
	Long imsi4;
	Long imsi5;
	
	int failure0;
	int failure1;
	int failure2;
	int failure3;
	int failure4;
	
	//Pairs of timestamps
	Timestamp time1;
	Timestamp time2;
	Timestamp time3; //Dummy
	Timestamp time4; //Dummy
	Timestamp time5;
	Timestamp time6;


	
	List<Fault> f0;
	List<Fault> f1;
	List<Fault> f2;
	List<Fault> f3;
	List<Fault> f4;
	
	List<Fault> getEventCauseId1;
	List<Fault> getEventCauseId2;
	List<Fault> getEventCauseId3;
	List<Fault> getEventCauseId4;
	List<Fault> getEventCauseId5;
	
	List<Fault> getFaultsByImsi1;
	List<Fault> getFaultsByImsi2;
	List<Fault> getFaultsByImsi3;
	List<Fault> getFaultsByImsi4;
	
	List<Fault> getImsiFailureOverTime1;
	List<Fault> getImsiFailureOverTime2;
	List<Fault> getImsiFailureOverTime3;
	List<Fault> getImsiFailureOverTime4;
	
	List<Fault> getIMSICount1;
	List<Fault> getIMSICount2;
	List<Fault> getIMSICount3;
	List<Fault> getIMSICount4;
	
//	List<Fault> Top10List1;
//	List<Fault> Top10List2;
//	List<Fault> Top10List3;
	
	
	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}
	@Before
	public void setUp() {
		
		//imsi0 = 191911000423411L;
		imsi1 = 838383838383838L;		//dummy
		imsi2 = 344930000000001L;
		imsi3 = 240210000000003L;
		imsi4 = 310560000000012L;
		imsi5 = 344930000000011L;
		
		failure0 = 0;
		failure1 = 1;
		failure2 = 2;
		failure3 = 3;
		failure4 = 5; // dummy
		
		time1 = Timestamp.valueOf("2013-01-11 17:16:00");
		time2 = Timestamp.valueOf("2013-01-11 17:17:00");
		time3 = Timestamp.valueOf("2013-01-11 17:18:00"); 
		time4 = Timestamp.valueOf("2013-01-11 17:19:00"); 
		time5 = Timestamp.valueOf("2013-01-11 17:10:00");
		time6 = Timestamp.valueOf("2013-01-11 17:14:00");
		
		f0 = (List<Fault>) faultDao.getImsiPerFailure(failure0);
		f1 = (List<Fault>) faultDao.getImsiPerFailure(failure1);
		f2 = (List<Fault>) faultDao.getImsiPerFailure(failure2);
		f3 = (List<Fault>) faultDao.getImsiPerFailure(failure3);
		f4 = (List<Fault>) faultDao.getImsiPerFailure(failure4);
		
		//getEventCauseId1 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi0);
		getEventCauseId2 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi2);
		getEventCauseId3 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi3);
		getEventCauseId4 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi4);
		getEventCauseId5 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi1);	//dummy imsi1
		
		getFaultsByImsi1 = (List<Fault>)faultDao.getFaultsByIMSI(imsi1);
		getFaultsByImsi2 = (List<Fault>)faultDao.getFaultsByIMSI(imsi2);
		getFaultsByImsi3 = (List<Fault>)faultDao.getFaultsByIMSI(imsi3);
		getFaultsByImsi4 = (List<Fault>)faultDao.getFaultsByIMSI(imsi4);
		
		getImsiFailureOverTime1 = (List<Fault>)faultDao.getIMSIFailureOverTime(time1, time2);
		getImsiFailureOverTime1 = (List<Fault>)faultDao.getIMSIFailureOverTime(time3, time4);
		getImsiFailureOverTime1 = (List<Fault>)faultDao.getIMSIFailureOverTime(time5, time6);
		
		getIMSICount1 = (List<Fault>)faultDao.getIMSICount(time1, time2,imsi5); //invalid imsi
		getIMSICount2 = (List<Fault>)faultDao.getIMSICount(time3, time4,imsi5); 
		getIMSICount3 = (List<Fault>)faultDao.getIMSICount(time5, time6,imsi5);
		
//		Top10List1 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time1, time2);
//		Top10List2 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time3, time4); //Dummy
//		Top10List3 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time5, time6);
	}

	
	@Test
	public void getImsiPerFailureTest(){
		
		assertEquals(160, f0.size());
		assertEquals(600, f1.size());
		assertEquals(40, f2.size());
		assertEquals(0, f3.size());
		assertEquals(0, f4.size());
	}
	
	@Test
	public void imsiCollectionIsNotEmptyTest(){
				
		assertTrue(f0.size() >= 1);
		assertTrue(f1.size() >= 1);
		assertTrue(f2.size() >= 1);
		assertTrue(f3.size() >= 0);
		assertTrue(f4.size() == 0);
	}
	
	@Test
	public void getEventCausePerIMSITest(){
		//assertTrue(getEventCauseId1.size() > 1);
		assertTrue(getEventCauseId2.size() > 1);
		assertTrue(getEventCauseId3.size() > 1);
		assertTrue(getEventCauseId4.size() > 1);
		assertTrue(getEventCauseId5.size() == 0);
	}
	
	@Test
	public void getFaultsByIMSITest(){
		assertTrue(getFaultsByImsi1.size() == 0);
		assertTrue(getFaultsByImsi2.size() > 1);
		assertTrue(getFaultsByImsi3.size() > 1);
		assertTrue(getFaultsByImsi4.size() > 1);
	}
	@Test
	public void getIMSIFailureOverTimeTest(){
		assertTrue(getImsiFailureOverTime1.size() > 1);
	}
	
	@Test
	public void getIMSICountTest(){
		assertTrue(getIMSICount1.isEmpty());
		assertTrue(getIMSICount2.size() > 1);
		assertTrue(getIMSICount3.size() > 1);
	}
	
//	@Test
//	public void getTopTenMarketOperatorCell(){
//		assertTrue(Top10List1.size() > 1);
//		assertTrue(Top10List2.size() == 0); //Dummy
//		assertTrue(Top10List3.size() > 1);
//	}

}