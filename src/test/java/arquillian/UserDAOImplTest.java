package arquillian;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.entity.User;
import com.interfaces.UserServiceLocal;


@RunWith(Arquillian.class)
public class UserDAOImplTest {

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);
	}

	@PersistenceContext
	private EntityManager em;


	@EJB
	UserServiceLocal service;


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
	public void testGetUserByUsernameAndPassword() {
		final User user = new User("Shane", "Shane", "password", "System Administrator");
		Collection<User> userColl= service.getUserByUsernameAndPassword("Shane", "password");
		assertTrue(userColl.size() == 1);
	}

	@Test
	public void testGetUserByName() {
		User user = service.getUserByName("Shane"); 
		assertTrue(user.getName().equals("Shane"));
	}
}
