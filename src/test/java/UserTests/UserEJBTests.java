package UserTests;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.JPAUserDAO;
import com.entity.User;
import com.interfaces.UserService;
import com.webservice.UserServiceEJB;

@RunWith(Arquillian.class)
public class UserEJBTests {

	@Inject
	UserService service;
	
	@Deployment
	public static JavaArchive createDeployment(){
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
		.addClasses(UserServiceEJB.class,User.class,UserService.class,JPAUserDAO.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void testThatTheUserDAOReturnsTheRightUser(){
		assertEquals(service.getUserByName("Darren Kane").getUsername(), "Kane22");
	}

}
