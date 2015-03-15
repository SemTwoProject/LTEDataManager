package arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;

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
	
	int cellId1; 
	int cellId2;
	int cellId3;
	
	Collection<CellHier> cellList1;
	Collection<CellHier> cell1;
	Collection<CellHier> cell2;
	Collection<CellHier> cell3;
	

	@Deployment
	public static WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}

	@Before
	public void setUp() {
		cellId1 = 4;
		cellId2 = 3842;
		cellId3 = 123; // not a cell id
		cellList1 = (Collection<CellHier>) dao.getCell();
		cell1 = dao.getByCellId(cellId1);
		cell2 = dao.getByCellId(cellId2);
		cell3= dao.getByCellId(cellId3);
	}

	@Test
	public void getCellTest() {
		assertFalse(cellList1.isEmpty());
	}

	@Test
	public void getByCellIdTest() {
		
		assertTrue(cell1.iterator().hasNext());
		assertTrue(cell2.iterator().hasNext());
		assertFalse(cell3.iterator().hasNext());
		
	}

}
