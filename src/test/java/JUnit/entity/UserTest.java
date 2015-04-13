package JUnit.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.entity.User;

public class UserTest {
	User user1;
	User userSame;
	User userEmpty;
	@Before
	public void setUp() throws Exception {
		user1 = new User("name", "username", "password", "userType");
		userSame = new User("name", "username", "password", "userType");
		userEmpty = new User();
	}

	@Test
	public void testUserEmpty() {
		assertEquals(userEmpty.getClass(), User.class);
	}

	@Test
	public void testUser() {
		assertEquals(user1.getClass(), User.class);
	}

	@Test
	public void testGetId() {
		int id = 138;
		int val;
		userEmpty.setId(id);
		val = userEmpty.getId();
		assertEquals(id, val);
	}

	@Test
	public void testGetandSetName() {
		String name = "Name";
		String val;
		userEmpty.setName(name);
		val = userEmpty.getName();
		assertEquals(name, val);
	}
	
	@Test
	public void testGetandSetPassword() {
		String password = "Password";
		String val;
		userEmpty.setPassword(password);
		val = userEmpty.getPassword();
		assertEquals(password, val);
	}

	@Test
	public void testGetandSetUserType() {
		String userType = "UserType";
		String val;
		userEmpty.setUserType(userType);
		val = userEmpty.getUserType();
		assertEquals(userType, val);
	}

	@Test
	public void testGetandSetUsername() {
		String username = "Username";
		String val;
		userEmpty.setUsername(username);
		val = userEmpty.getUsername();
		assertEquals(username, val);
	}

}
