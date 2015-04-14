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
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.FaultDAO;
import com.entity.Fault;
import com.interfaces.FaultServiceLocal;

@RunWith(Arquillian.class)
public class FaultDAOTest {

	@EJB
	FaultServiceLocal faultDao;

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

	List<Fault> getFaultsByImsi0;
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

	List<Fault> Top10List1;
	List<Fault> Top10List2;
	List<Fault> Top10List3;


	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}
	@Before
	public void setUp() {

		model1 = "Mitsubishi GSM MT 20 Type MT 1171FD2";
		model2 = "Model";

		imsi0 = 100101001000100L;//dummy
		imsi1 = 191911000456426L;		
		imsi2 = 191911000269383L;
		imsi3 = 191911000187300L;
		imsi4 = 191911000560407L;
		imsi5 = 191911000563502L;

		failure0 = 0;
		failure1 = 1;
		failure2 = 2;
		failure3 = 3;
		failure4 = 5; // dummy

		time1 = Timestamp.valueOf("2010-01-11 17:15:00");
		time2 = Timestamp.valueOf("2015-01-12 17:18:00");
		time3 = Timestamp.valueOf("2015-01-12 17:18:00");
		time4 = Timestamp.valueOf("2015-05-12 17:18:00");
	}


	@Test
	public void getImsiPerFailureTest(){

		f0 = (List<Fault>) faultDao.getImsiPerFailure(failure0);
		f1 = (List<Fault>) faultDao.getImsiPerFailure(failure1);
		f2 = (List<Fault>) faultDao.getImsiPerFailure(failure2);
		f3 = (List<Fault>) faultDao.getImsiPerFailure(failure3);
		f4 = (List<Fault>) faultDao.getImsiPerFailure(failure4);

		assertFalse(f0.isEmpty());
		assertFalse(f1.isEmpty());
		assertFalse(f2.isEmpty());
		assertFalse(f3.isEmpty());
		assertTrue(f4.isEmpty());
	}


	@Test
	public void getEventCausePerIMSITest(){
		getEventCauseId1 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi0);//dummy imsi0
		getEventCauseId2 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi2);
		getEventCauseId3 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi3);
		getEventCauseId4 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi4);
		getEventCauseId5 = (List<Fault>) faultDao.getEventCausePerIMSI(imsi1);
		//assertTrue(getEventCauseId1.size() > 1);
		assertFalse(getEventCauseId2.isEmpty());
		assertFalse(getEventCauseId3.isEmpty());
		assertFalse(getEventCauseId4.isEmpty());
		assertFalse(getEventCauseId5.isEmpty());
		assertTrue(getEventCauseId1.isEmpty());
	}

	@Test
	public void getFaultsByIMSITest(){
		getFaultsByImsi0 = (List<Fault>)faultDao.getEventCausePerIMSI(imsi0);
		getFaultsByImsi1 = (List<Fault>)faultDao.getEventCausePerIMSI(imsi1);
		getFaultsByImsi2 = (List<Fault>)faultDao.getEventCausePerIMSI(imsi2);
		getFaultsByImsi3 = (List<Fault>)faultDao.getEventCausePerIMSI(imsi3);
		getFaultsByImsi4 = (List<Fault>)faultDao.getEventCausePerIMSI(imsi4);

		
		assertTrue(getFaultsByImsi0.isEmpty());
		assertFalse(getFaultsByImsi2.isEmpty());
		assertFalse(getFaultsByImsi2.isEmpty());
		assertFalse(getFaultsByImsi3.isEmpty());
		assertFalse(getFaultsByImsi4.isEmpty());
	}
	@Test
	public void getIMSIFailureOverTimeTest(){
		getImsiFailureOverTime1 = (List<Fault>)faultDao.getIMSIFailureOverTime(time1, time2);
		getImsiFailureOverTime2 = (List<Fault>)faultDao.getIMSIFailureOverTime(time3, time4);
//		getImsiFailureOverTime3 = (List<Fault>)faultDao.getIMSIFailureOverTime(time5, time6);
		
		assertTrue(getImsiFailureOverTime2.isEmpty());
		assertTrue(getImsiFailureOverTime1.size() > 1);
	}
	@Test
	public void getIMSICountTest(){
		getIMSICount1 = (List<Fault>)faultDao.getIMSICount(time1, time2,imsi5); 
		getIMSICount3 = (List<Fault>)faultDao.getIMSICount(time3, time4,imsi5);
		assertTrue(getIMSICount1.size()>0);
		assertTrue(getIMSICount3.getClass() != List.class);
	}

	@Test
	public void getCauseCodePerIMSI(){
		getCauseCodePerIMSI1 = (List<Fault>)faultDao.getCauseCodePerIMSI(imsi5);
		getCauseCodePerIMSI2 = (List<Fault>)faultDao.getCauseCodePerIMSI(imsi2);
		getCauseCodePerIMSI3 = (List<Fault>)faultDao.getCauseCodePerIMSI(imsi0); //Invalid imsi


		assertFalse(getCauseCodePerIMSI1.isEmpty());
		assertFalse(getCauseCodePerIMSI2.isEmpty());
		assertTrue(getCauseCodePerIMSI3.isEmpty());

	}

	@Test
	public void getTopTenIMSIOverTime(){
		getTopTenIMSIOverTime1 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time1, time2);
		getTopTenIMSIOverTime2 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time3, time4);

		assertFalse(getTopTenIMSIOverTime1.isEmpty());
		assertTrue(getTopTenIMSIOverTime2.isEmpty());
		//assertTrue(getTopTenIMSIOverTime3.isEmpty());
	}
	@Test
	public void getTotalFaultsAndDurationPerIMSITest(){
		getTotalFaultsAndDurationPerIMSI1 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time1, time2);
		getTotalFaultsAndDurationPerIMSI2 =(List<Fault>)faultDao.getTopTenIMSIOverTime(time3, time4);
		assertFalse(getTotalFaultsAndDurationPerIMSI1.isEmpty());
		assertTrue(getTotalFaultsAndDurationPerIMSI2.isEmpty());
		
	}

	@Test
	public void getNumberOfCallFailuresPerModelTest(){
		getNumberOfCallFailuresPerModel1 = (List<Fault>)faultDao.getAmountOfCallFailuresPerModel(model1, time1, time2);// model in faults time is valid
		getNumberOfCallFailuresPerModel2 = (List<Fault>)faultDao.getAmountOfCallFailuresPerModel(model2, time3, time4);// invalid model and invalid time

		assertTrue(getNumberOfCallFailuresPerModel1.size()>0);
		assertTrue(getNumberOfCallFailuresPerModel2.getClass() != List.class);
	}

		@Test
		public void getTopTenMarketOperatorCell(){
			Top10List1 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time1, time2);
			Top10List2 = (List<Fault>) faultDao.getTopTenMarketOperatorCell(time3, time4); //Dummy
			
			assertTrue(Top10List1.size() > 1);
			assertTrue(Top10List2.size() == 0); //Dummy
		}

}