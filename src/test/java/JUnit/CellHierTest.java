/*package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.entity.CellHier;
import com.entity.Fault;

public class CellHierTest {

	CellHier cell1;
	CellHier cellSame;
	CellHier emptyCell;
	
	@Before
	public void setUp(){
		cell1 = new CellHier(1, 6281097336314240000L, 91747911120979008L, 1771871205659990016L);
		cellSame = new CellHier(1, 6281097336314240000L, 91747911120979008L, 1771871205659990016L);
		emptyCell = new CellHier();

	}
	
	@Test
	public void testEquals_Symmetric() {
		assertEquals(cell1.equals(cellSame),cellSame.equals(cell1));
		assertEquals(cell1.hashCode(),cellSame.hashCode());
	}

	@Test
	public void testCellHierEmptyConstructor() {
		CellHier empty = new CellHier();
		assertTrue(empty.getClass().equals(CellHier.class));
	}

	@Test
	public void testCellHierParameterisedConstructor() {
		CellHier cell = new CellHier(2,178273789383L,883992920038L,4882992902774L);
		assertTrue(cell.getClass().equals(CellHier.class));
	}

	@Test
	public void testGetandSetCellId() {
		int id = 10;
		int val;
		emptyCell.setCellId(id);
		val = emptyCell.getCellId();
		assertEquals(id, val);
		
	}

	@Test
	public void testGetandSetHier3Id() {
		Long hier3 = 38302828978L;
		Long val;
		emptyCell.setHier3Id(hier3);
		val = emptyCell.getHier3Id();
		assertEquals(hier3, val);
	}
	
	@Test
	public void testGetHier32Id() {
		Long hier32 = 38302828978L;
		Long val;
		emptyCell.setHier32Id(hier32);
		val = emptyCell.getHier32Id();
		assertEquals(hier32, val);
	}

	@Test
	public void testGetandSetHier321Id() {
		Long hier321 = 38302828978L;
		Long val;
		emptyCell.setHier321Id(hier321);
		val = emptyCell.getHier321Id();
		assertEquals(hier321, val);
	}

	@Test
	public void testGetandSetFaultList() {
		List<Fault> faultList = new ArrayList<Fault>();
		List<Fault> val;
		emptyCell.setFaultList(faultList);
		val = emptyCell.getFaultList();
		assertEquals(faultList, val);
	}

	@Test
	public void testAddFault() {
		List<Fault> faultList = new ArrayList<Fault>();
		emptyCell.setFaultList(faultList);
		Fault fault = new Fault();
		Fault val;
		emptyCell.addFault(fault);
		val = emptyCell.getFaultList().get(0);
		assertEquals(val, fault);
	}
}
*/