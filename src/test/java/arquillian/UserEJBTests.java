package arquillian;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.interfaces.UserServiceLocal;


@RunWith(Arquillian.class)
public class UserEJBTests {

	@EJB
	UserServiceLocal service;
	
	@Deployment
	public static WebArchive createDeployment(){
		return ShrinkWrap.create(ZipImporter.class, "test.war").
				importFrom(new File("target/LTEManager.war")).as(WebArchive.class);
	}
	
	
	@Test
	public void testThatTheAllUsersAreReturned(){
		assertEquals(service.getAllUsersInDatabase().size(),1);
	}
	
	@Test
	public void testThatTheUserDAOReturnsTheRightUser(){
		assertEquals(service.getUserByName("Stephen Douglas").getUsername(), "Hyde");
	}
}
