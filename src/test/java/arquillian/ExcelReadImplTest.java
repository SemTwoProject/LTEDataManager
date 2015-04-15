package arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.ExcelDAO;
import com.dao.FaultDAO;
import com.entity.Fault;

@RunWith(Arquillian.class)
public class ExcelReadImplTest {

	@EJB
	private ExcelDAO dao;
	@EJB
	private FaultDAO fault;
	
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFSheet sheet1;
	private HSSFSheet sheet2;
	private HSSFSheet sheet3;
	private HSSFSheet sheet4;
	private HSSFRow row;
	private Collection<String> models;
	private Collection<Fault> imsi;
	private Collection<Fault> mccmnc;
	private Collection<Fault> cause;
	private Collection<Fault> events;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);
	}

	@Before
	public void setUp() throws IOException {
		 FileOutputStream fileOut = new FileOutputStream("c:\\excel\\sample.xls");
		 sheet = wb.createSheet();
		 sheet1 = wb.createSheet();
		 sheet2 = wb.createSheet();
		 sheet3 = wb.createSheet();
		 sheet4 = wb.createSheet();
		 
		  row = sheet.createRow((short)1);
		  row.createCell(0).setCellValue(210220132101L);
		  row.createCell(1).setCellValue(4098);
		  row.createCell(2).setCellValue(4);
		  row.createCell(3).setCellValue(33001735);
		  row.createCell(4).setCellValue(405);
		  row.createCell(5).setCellValue(1);
		  row.createCell(6).setCellValue(1);
		  row.createCell(7).setCellValue(1005);
		  row.createCell(8).setCellValue(1);
		  row.createCell(9).setCellValue("13A");
		  row.createCell(10).setCellValue(191911000456426L);

		  row = sheet1.createRow((short)1);
		  row.createCell(0).setCellValue(1);
		  row.createCell(1).setCellValue(4098);
		  row.createCell(2).setCellValue("S1 SIG CONN SETUP-S1 INTERFACE DOWN");
		  
		  row = sheet2.createRow((short)1);
		  row.createCell(0).setCellValue(0);
		  row.createCell(1).setCellValue("EMERGENCY");

		  row = sheet3.createRow((short)1);
		  row.createCell(0).setCellValue(33001735);
		  row.createCell(1).setCellValue("Mitsubishi GSM MT 20 Type MT 1171FD2");
		  row.createCell(2).setCellValue("Mitsubishi Electric France");
		  row.createCell(3).setCellValue("GSM 900");
		  row.createCell(4).setCellValue("Mitsubishi GSM MT 20 Type MT 1171FD2");
		  row.createCell(5).setCellValue("Mitsubishi Electric France");
		  row.createCell(6).setCellValue("null");
		  row.createCell(7).setCellValue("null");
		  row.createCell(8).setCellValue("null");

		  row = sheet4.createRow((short)1);
		  row.createCell(0).setCellValue(405);
		  row.createCell(1).setCellValue(1);
		  row.createCell(2).setCellValue("India");
		  row.createCell(2).setCellValue("Reliance Infocomm-IN");

		 wb.write(fileOut);
		 fileOut.close();
		 models = fault.getAllModels();
		 imsi = fault.getFaultsByIMSI(191911000456426L);
		 mccmnc = fault.getFaultsForCell("India","Reliance Infocomm-IN", 1);
		 cause= fault.getCauseCodePerIMSI(191911000456426L);
		 events = fault.getEventCausePerModel("Mitsubishi GSM MT 20 Type MT 1171FD2");
		 
		}

	@Test
	public void callAll() {
		//add to our database and ensure our numbers have at least increased or are present
		dao.callAll("sample.xls");
		assertTrue(models.size() < fault.getAllModels().size());
		assertTrue(imsi.size() < fault.getFaultsByIMSI(191911000456426L).size());
		assertTrue(mccmnc.size() < fault.getFaultsForCell("India","Reliance Infocomm-IN", 1).size());
		assertTrue(cause.size() < fault.getCauseCodePerIMSI(191911000456426L).size());
		assertTrue(events.size() < fault.getEventCausePerModel("Mitsubishi GSM MT 20 Type MT 1171FD2").size());
	}

}
