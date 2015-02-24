package arquillian;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.InputModeDAO;
import com.entity.InputMode;

@RunWith(Arquillian.class)
public class InputModeDAOTest {

	@RunWith(Arquillian.class)
	public class DurationEJBTest {

		@EJB
		private InputModeDAO dao;

		@Deployment
		public WebArchive createDeployment() {

			return ShrinkWrap.create(ZipImporter.class, "test.war")
					.importFrom(new File("target/LTEManager.war"))
					.as(WebArchive.class);

		}

		@Before
		public void setUp() {
		}		

		@Test
		public void InputModeListReturned() {
			assertEquals(dao.getInputMode().size(), 2);
		}

		@Test
		public void InputModeIsReturnedByValue() {
			String y = new String("QWERTY");
			String x = new String("Touch");
			InputMode testIModeQWERTY = dao.getByInputMode(y);
			InputMode testImodeTouch = dao.getByInputMode(x);
			
			assertEquals(y, testIModeQWERTY.getInputMode());
			assertEquals(x, testImodeTouch.getInputMode());
		}
	}
}

