package restAssured;

//import static com.jayway.restassured.RestAssured.expect;
//import static com.jayway.restassured.RestAssured.get;
//import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
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
public class ExcelRestTest {
	
	private static final String TEST_FILE = "src/test/resources/modded.xls";
	
//	@Deployment
//	public static WebArchive createDeployment() {
//		// WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
//
//		return ShrinkWrap.create(ZipImporter.class, "test.war")
//				.importFrom(new File("target/LTEManager.war"))
//				.as(WebArchive.class);
//	}
	
//	   @Test
//	    public void testUpload() throws IOException {    
//	        given()
//	        .multiPart("selectedFile", new File(TEST_FILE))
//	        .expect()
//	        .statusCode(200)
//	        .log().ifError()
//	        .when()
//	        .post("/rest/excel");    
//	    }

}
