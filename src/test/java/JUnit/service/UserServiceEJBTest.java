package JUnit.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;

import com.entity.User;
import com.service.UserServiceEJB;

public class UserServiceEJBTest {

	@Test
	public void testAddToUserDatabase() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllUsersInDatabase() {
		UserServiceEJB userEJB = new UserServiceEJB();
		assertTrue(userEJB.getAllUsersInDatabase().size() >=0);
	}

	@Test
	public void testGetUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByUsernameAndPassword() {
		UserServiceEJB userEJB = new UserServiceEJB();
		Collection<User> user = userEJB.getUserByUsernameAndPassword("Shane", "password");
		assertTrue(user.size()==0);
	}

}
