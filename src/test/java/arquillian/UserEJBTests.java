package arquillian;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.entity.User;
import com.interfaces.UserServiceLocal;


@RunWith(Arquillian.class)
public class UserEJBTests {

	@Inject
	UserServiceLocal service;
	
	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true,"com")
				.addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
  }
		
	@Test
	public void testGetAllUsers() {
		Collection<User> users = service.getAllUsersInDatabase(); 
		assertTrue(users.size() > 0);
		assertFalse(users.isEmpty());
		}

	@Test
	public void testAddUser() { 
		int size = service.getAllUsersInDatabase().size();
		final User user = new User("Barry", "Barry", "password", "testUser");
		service.addToUserDatabase(user);	 
		assertTrue(service.getAllUsersInDatabase().size()==(size + 1));
		
	}

	@Test
	public void testDeleteUser() {
		int size = service.getAllUsersInDatabase().size();
		User user = service.getUserByName("Barry");
		service.deleteUser(user);
		assertTrue(service.getAllUsersInDatabase().size()==(size - 1));

	}

	@Test
	public void testGetUserByUsernameAndPassword() {
		final User user = new User("Barry", "Barry", "password", "testUser");
		Collection<User> userColl= service.getUserByUsernameAndPassword("Barry", "password");
		assertTrue(userColl.contains(user));
	}

	@Test
	public void testGetUserByName() {
		User user = service.getUserByName("Barry"); 
		assertTrue(user.getName().equals("Barry"));
	}
}
