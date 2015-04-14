package restAssured;

//import static com.jayway.restassured.RestAssured.expect;
//import static com.jayway.restassured.RestAssured.get;
//import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.entity.Fault;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

@RunWith(Arquillian.class)
public class FaultRestTest {

//	@Deployment
//	public static WebArchive createDeployment() {
//		// WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
//
//		return ShrinkWrap.create(ZipImporter.class, "test.war")
//				.importFrom(new File("target/LTEManager.war"))
//				.as(WebArchive.class);
//	}
	
//GET TESTS
	@Test
	public void TestGetImsis(){
		
		String[] imsis = expect().statusCode(200).given().when().get("http://localhost:8080/LTEManager/rest/fault/imsis")
				.as(String[].class);
		assertTrue(imsis[0].equals("344930000000011"));
		
	}
	
	@Test
	public void TestGetModels(){
		
		String[] models = expect().statusCode(200).given().when().get("http://localhost:8080/LTEManager/rest/fault/models")
				.as(String[].class);
		assertTrue(models[0].equals("G410"));			
	}
	
	@Test
	public void TestGetFailureDescriptions(){
		
		String[] failureDescriptions = expect().statusCode(200).given().when().get("http://localhost:8080/LTEManager/rest/fault/failuredescriptions")
				.as(String[].class);
		assertTrue(failureDescriptions[0].equals("EMERGENCY"));			
	}

//POST TESTS
	@Test
	public void testFaultsByImsi() {
		
		Fault[] faultsByImsi = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/faultsbyimsi")
				.as(Fault[].class);
		assertTrue(faultsByImsi.length == 0);	
	}
	

	 @Test
	 public void testTotalFaults() {
		 Fault[] totalfaults = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/totalfaults")
					.as(Fault[].class);
			assertTrue(totalfaults.length == 0);	
	 }

	 @Test
	 public void testTopTenImsiOverTime() {
		 Fault[] topTenImsiOverTime = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/toptenimsiovertime")
					.as(Fault[].class);
			assertTrue(topTenImsiOverTime.length == 0);
	 }
	 
	 @Test
	 public void testGetCountPerFaults() {
		 Fault[] getCountPerFaults = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/faultsbymodel")
					.as(Fault[].class);
			assertTrue(getCountPerFaults.length == 0);
	 }
	 
	 @Test
	 public void testGetModelFailures() {
		 Fault[] modelFailures = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/modelfailures")
					.as(Fault[].class);
			assertTrue(modelFailures.length == 0);
	 }
	 
	 @Test
	 public void testGetFaultsForModelCombo() {
		 Fault[] faultsForModelCombo = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/faultsformodeleventcombo")
					.as(Fault[].class);
			assertTrue(faultsForModelCombo.length == 0);
	 }
	 
	 @Test
	 public void testGetFaultsForCell() {
		 Fault[] faultsForCell = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/faultsforcell")
					.as(Fault[].class);
			assertTrue(faultsForCell.length == 0);
	 }
}
	 
//	 @Test
//	 public void testTopTenImsiOverTimePath() {
//	 Response res = get("rest/fault/toptenimsiovertime");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testFaultsOverTimePath() {
//	 Response res = get("rest/fault/faultsbymodel");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testImsiPerFailureCodePath() {
//	 Response res = get("rest/fault/imsiperfailurecode");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testTopTenMnnMcnPath() {
//	 Response res = get("rest/fault/toptenmnnmcncell");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testModelFailuresPath() {
//	 Response res = get("rest/fault/modelfailures");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testFaultsForModelEventComboPath() {
//	 Response res = get("rest/fault/faultsformodeleventcombo");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testFaultsForCellPath() {
//	 Response res = get("rest/fault/faultsforcell");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testModelsPath() {
//	 Response res = get("rest/fault/models");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testfailureDescriptionsPath() {
//	 Response res = get("rest/fault/failuredescriptions");
//	 assertEquals(404, res.getStatusCode());
//	 }
//	
//	 @Test
//	 public void testImsisPath() {
//	 Response res = get("rest/fault/imsis");
//	 assertEquals(404, res.getStatusCode());
//	 }
//}
	 
//N	 
//	 @Test
//	 public void testGetImsiPerFailure() {
//		 Fault[] getImsiPerFailure = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/imsiperfailurecode")
//					.as(Fault[].class);
//			assertTrue(getImsiPerFailure.length == 0);
//	 }
//N	 
//	 @Test
//	 public void testGetTopTenMarketOperatorCell() {
//		 Fault[] topTenMarketOperatorCells = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/toptenmnnmcncell")
//					.as(Fault[].class);
//			assertTrue(topTenMarketOperatorCells.length == 0);
//	 }
//	
//N
//	 @Test
//	 public void testImsiCauseCodes() {
//
//		 Fault[] imsiCauseCodes = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/imsicausecodes")
//					.as(Fault[].class);
//			assertTrue(imsiCauseCodes.length == 0);
//	 }
//	 
////N	 
//	 @Test
//	 public void testImsiFailuresOverTimePath() {
//		 Fault[] imsifailures = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/imsifailuresovertime")
//					.as(Fault[].class);
//			assertTrue(imsifailures.length == 0);
//	 }
	 
	
//	//rest/fault/imsicount
//	 @Test
//	 public void testImsiCountPath() {
//		 
//		 Fault[] faultscount = expect().statusCode(200).given().when().post("http://localhost:8080/LTEManager/rest/fault/imsicount")
//					.as(Fault[].class);
//		 
//		 assertTrue(faultscount.length == 0);
//	 }
	
	
	// @Test
	// public void testFaultsByImsiPath() {
	//
	// Response res = get("rest/fault/faultsbyimsi");
	// assertEquals(404, res.getStatusCode());
	// }
//		with().parameters("imsi", 344930000000011l ).expect()
//				.statusCode(200).when()
//				.post("http://localhost:8080/LTEManager/rest/fault/faultsbyimsi");
//		}
	
	// @Test
	// public void testFaultsByImsi() {
	//
	// Response res = get("rest/fault/faultsbyimsi");
	// assertEquals(404, res.getStatusCode());
	//
	// //Try to Post an imsi and check for existing imsi response
	//
	// String json = res.asString();
	// JsonPath jp = new JsonPath(json);
	// assertEquals("344930000000011", jp.get("IMSI"));
	// assertEquals("23", jp.get("Cause Code"));
	// }

	 
//	@Test
//	public void testGetSingleUserProgrammatic() {
//		Response res = get("rest/fault/faultsbyimsi");
//		assertEquals(200, res.getStatusCode());
//		String json = res.asString();
//		JsonPath jp = new JsonPath(json);
//		assertEquals("4125", jp.get("Event ID"));
//		assertEquals("23", jp.get("Cause Code"));
//		anything("Anything");
//	}
	 
	 


//	//rest/fault/totalfaults
//	 @Test
//	 public void testTotalFaultsPath() {
//		 with().parameters("2013-01-11 17:15:00", "2013-01-11 17:34:00" ).expect()
//			.statusCode(200).when()
//			.post("http://localhost:8080/LTEManager/rest/fault/totalfaults");
//	 }
	//

//}
