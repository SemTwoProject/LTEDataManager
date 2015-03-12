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

import com.dao.CellDAO;
import com.entity.CellHier;

@RunWith(Arquillian.class)
public class CellDAOTest {

	@EJB
	private CellDAO dao;

	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}

	@Before
	public void setUp() {
	}

	@Test
	public void CellListIsReturned() {
		assertEquals(dao.getCell().size(), 3);
	}

	@Test
	public void CellIsReturnedById() {
		
		CellHier cell = dao.getByCellId(4);
		int x = 4;
		int y = cell.getCellId();
		assertEquals(x,y);
	}

}
