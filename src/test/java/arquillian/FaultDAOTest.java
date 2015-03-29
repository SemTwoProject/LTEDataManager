package arquillian;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Timestamp;
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

import com.dao.FaultDAO;
import com.entity.Fault;

@RunWith(Arquillian.class)
public class FaultDAOTest {

	@EJB
	FaultDAO faultDao;

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
	Timestamp time7;
	Timestamp time8;

	String model1;
	String model2;
	String model3;



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

	List<Fault> getCauseCodePerIMSI1;
	List<Fault> getCauseCodePerIMSI2;
	List<Fault> getCauseCodePerIMSI3;

	List<Fault> getTopTenIMSIOverTime1;
	List<Fault> getTopTenIMSIOverTime2;
	List<Fault> getTopTenIMSIOverTime3;

	List<Fault> getTotalFaultsAndDurationPerIMSI1;
	List<Fault> getTotalFaultsAndDurationPerIMSI2;
	List<Fault> getTotalFaultsAndDurationPerIMSI3;

	List<Fault> getNumberOfCallFailuresPerModel1;
	List<Fault> getNumberOfCallFailuresPerModel2;
	List<Fault> getNumberOfCallFailuresPerModel3;

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

		model1 = "A53";
		model2 = "VEA3";
		model3 = "Gobi3000";

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

		time1 = Timestamp.valueOf("2013-01-11 17:15:00");
		time2 = Timestamp.valueOf("2013-01-12 17:18:00");
		time3 = Timestamp.valueOf("2012-01-01 05:18:00"); 
		time4 = Timestamp.valueOf("2015-03-13 05:19:00"); 
		time5 = Timestamp.valueOf("2013-01-11 17:15:20");
		time6 = Timestamp.valueOf("2013-01-11 17:15:30");
		time7 = Timestamp.valueOf("2013-01-11 17:17:00");
		time8 = Timestamp.valueOf("2013-01-11 17:19:00");

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

		getImsiFailureOverTime1 = (List<Fault>)faultDao.getIMSIFailureOverTime(time3, time4);
		getImsiFailureOverTime2 = (List<Fault>)faultDao.getIMSIFailureOverTime(time3, time4);
		getImsiFailureOverTime3 = (List<Fault>)faultDao.getIMSIFailureOverTime(time5, time6);

		getIMSICount1 = (List<Fault>)faultDao.getIMSICount(time1, time2,imsi5); //invalid imsi
		getIMSICount2 = (List<Fault>)faultDao.getIMSICount(time3, time4,imsi5); 
		getIMSICount3 = (List<Fault>)faultDao.getIMSICount(time5, time6,imsi5);

		getCauseCodePerIMSI1 = (List<Fault>)faultDao.getCauseCodePerIMSI(imsi5);
		getCauseCodePerIMSI2 = (List<Fault>)faultDao.getCauseCodePerIMSI(imsi2);
		getCauseCodePerIMSI3 = (List<Fault>)faultDao.getCauseCodePerIMSI(imsi1); //Invalid

		getTopTenIMSIOverTime1 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time1, time2);
		getTopTenIMSIOverTime2 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time3, time4);
		getTopTenIMSIOverTime3 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time5, time6);

		getTotalFaultsAndDurationPerIMSI1 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time1, time2);
		getTotalFaultsAndDurationPerIMSI2 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time3, time4);
		getTotalFaultsAndDurationPerIMSI3 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time5, time6); //invalid/empty List


		getNumberOfCallFailuresPerModel1 = (List<Fault>)faultDao.getNumberOfCallFailuresPerModel(model1, time3, time4);// model in not in faults time is valid /returns empty
		getNumberOfCallFailuresPerModel2 = (List<Fault>)faultDao.getNumberOfCallFailuresPerModel(model2, time3, time4);// valid model and time
		getNumberOfCallFailuresPerModel3 = (List<Fault>)faultDao.getNumberOfCallFailuresPerModel(model3, time7, time8);// valid model not in time frame/returns empty
		//		Top10List1 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time1, time2);
		//		Top10List2 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time3, time4); //Dummy
		//		Top10List3 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time5, time6);
	}


	@Test
	public void getImsiPerFailureTest(){

		//		assertEquals(160, f0.size());
		//		assertEquals(600, f1.size());
		//		assertEquals(40, f2.size());
		//		assertEquals(0, f3.size());
		//		assertEquals(0, f4.size());

		assertFalse(f0.isEmpty());
		assertFalse(f1.isEmpty());
		assertFalse(f2.isEmpty());
		assertTrue(f3.isEmpty());
		assertTrue(f4.isEmpty());
	}

	@Test
	public void imsiCollectionIsNotEmptyTest(){

		assertFalse(f0.isEmpty());
		assertFalse(f1.isEmpty());
		assertFalse(f2.isEmpty());
		assertTrue(f3.isEmpty());
		assertTrue(f4.isEmpty());
	}

	@Test
	public void getEventCausePerIMSITest(){
		//assertTrue(getEventCauseId1.size() > 1);
		assertFalse(getEventCauseId2.isEmpty());
		assertFalse(getEventCauseId3.isEmpty());
		assertFalse(getEventCauseId4.isEmpty());
		assertTrue(getEventCauseId5.isEmpty());
	}

	@Test
	public void getFaultsByIMSITest(){
		assertTrue(getFaultsByImsi1.isEmpty());
		assertFalse(getFaultsByImsi2.isEmpty());
		assertFalse(getFaultsByImsi3.isEmpty());
		assertFalse(getFaultsByImsi4.isEmpty());
	}
	@Test
	public void getIMSIFailureOverTimeTest(){
		assertTrue(getImsiFailureOverTime1.size() > 1);
	}

	@Test
	public void getCauseCodePerIMSITest(){

	}

	@Test
	public void getIMSICountTest(){
		//assertTrue(getIMSICount1.isEmpty());
		assertFalse(getIMSICount2.isEmpty());
		//assertTrue(getIMSICount3.size() > 1);
	}

	@Test
	public void getCauseCodePerIMSI(){
		assertFalse(getCauseCodePerIMSI1.isEmpty());
		assertFalse(getCauseCodePerIMSI2.isEmpty());
		assertTrue(getCauseCodePerIMSI3.isEmpty());

	}

	@Test
	public void getTopTenIMSIOverTime(){
		assertFalse(getTopTenIMSIOverTime1.isEmpty());
		//assertTrue(getTopTenIMSIOverTime2.isEmpty());
		//assertTrue(getTopTenIMSIOverTime3.isEmpty());
	}
	@Test
	public void getTotalFaultsAndDurationPerIMSITest(){
		assertFalse(getTotalFaultsAndDurationPerIMSI1.isEmpty());
		assertFalse(getTotalFaultsAndDurationPerIMSI2.isEmpty());
		assertTrue(getTotalFaultsAndDurationPerIMSI3.isEmpty());
	}

	@Test
	public void getNumberOfCallFailuresPerModelTest(){
		assertTrue(getNumberOfCallFailuresPerModel1.isEmpty());
		assertFalse(getNumberOfCallFailuresPerModel2.isEmpty());
		assertTrue(getNumberOfCallFailuresPerModel3.isEmpty());
	}

	//	@Test
	//	public void getTopTenMarketOperatorCell(){
	//		assertTrue(Top10List1.size() > 1);
	//		assertTrue(Top10List2.size() == 0); //Dummy
	//		assertTrue(Top10List3.size() > 1);
	//	}

}