package arquillian;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Collection;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logmanager.formatters.Formatters;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.entity.User;
import com.interfaces.UserServiceLocal;


@RunWith(Arquillian.class)
public class UserEJBTests {

	@EJB
	UserServiceLocal service;
	
	@Deployment
	public static WebArchive createDeployment(){
		return ShrinkWrap.create(ZipImporter.class, "test.war").
				importFrom(new File("target/LTEManager.war")).as(WebArchive.class)
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                // Enable CDI
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
	}
	
	
	@Test
	public void testGetAllUsers() {
		Collection<User> users = service.getAllUsersInDatabase(); 
		assertTrue(users.size() > 0);
	}

	@Test
	public void testAddUser() {
		final User user = new User("Barry", "Barry", "password", "testUser");
		service.addToUserDatabase(user);
		
	}

	@Test
	public void testDeleteUser() {
		User user = service.getUserByName("Barry");
		service.deleteUser(user);
	}

	@Test
	public void testGetUserByUsernameAndPassword() {
		Collection<User> user = service.getUserByUsernameAndPassword("Barry", "password");
	}

	@Test
	public void testGetUserByName() {
		User user = service.getUserByName("Barry"); 
	}
}
