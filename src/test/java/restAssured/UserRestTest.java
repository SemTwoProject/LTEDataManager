package restAssured;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.entity.Fault;
import com.entity.User;
import com.jayway.restassured.response.Response;

@RunWith(Arquillian.class)
public class UserRestTest {

//	@Deployment
//	public static WebArchive createDeployment() {
//		//WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
//
//		return ShrinkWrap.create(ZipImporter.class, "test.war")
//				.importFrom(new File("target/LTEManager.war"))
//				.as(WebArchive.class);
//	}
	
	@Test
	public void TestListUsers(){
		
		User [] users = given().when().get("http://localhost:8080/LTEManager/rest/users/list")
				.as(User[].class);
		assertFalse(users[0].getId() == 0);
		assertEquals("S" , users[0].getName());
		assertEquals("p" , users[0].getPassword());
		assertEquals("System Administrator" , users[0].getUserType());
		assertEquals("s" , users[0].getUsername());		
	}
	
//	@Test
//	public void testGetStatus() {
//		
//		String[] status = expect().statusCode(200).given().when().get("http://localhost:8080/LTEManager/rest/users/status")
//				.as(String[].class);
//		//assertTrue(status.length == 0);	
//	}
	
//	@Test
//	public void testGetUsers() {
//		
//		User[] users = expect().statusCode(200).given().when().get("http://localhost:8080/LTEManager/rest/users/getuser")
//				.as(User[].class);
//		//assertTrue(users.length == 0);	
//	}
	
}
	
//	@Test
//	public void testGetUsers() {
//	  expect().
//	    statusCode(200).
//	    body(
//	      "id", equalTo("1"),
//	      "name", equalTo("S"),
//	      "password", equalTo("p"),
//	      "user_type", equalTo("System Administrator")).
//	    when().
//	    post("rest/users/getuser");
//	}
//	
//}