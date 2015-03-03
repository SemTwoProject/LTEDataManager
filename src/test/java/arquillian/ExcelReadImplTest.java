package arquillian;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import javax.ejb.EJB;

import org.apache.poi.ss.usermodel.Cell;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.ExcelDAO;

@RunWith(Arquillian.class)
public class ExcelReadImplTest {

	@EJB
	private ExcelDAO dao;
	File file;
	ArrayList<Cell> cells;

	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}

	@Before
	public void setUp() {
		file = new File(getClass().getClassLoader().getResource("test.xls").getFile());
	}

	@Test
	public void getExcelResourceTest6() {
		assertNotNull(file);
	}
}