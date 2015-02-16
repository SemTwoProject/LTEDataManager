package jpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;

import service.ApachePOIService;
import dao.*;

@Stateless
@Local
public class ExcelReadImpl implements ApachePOIReader {

	private DataFormatter formatter = new DataFormatter();
	private File file = new File("test.xls");
	private ApachePOIService service;
	private ApachePOIService service1;
	private ApachePOIService service2;
	private ApachePOIService service3;
	private ApachePOIService service4;
	private ApachePOIService service5;
	private ApachePOIService service6;
	private ApachePOIService service7;
	private ApachePOIService service8;
	@PersistenceContext
	private EntityManager em;

	public void createCell() throws InvalidFormatException,
			FileNotFoundException, IOException {

		CellDAO cellDAO = new CellDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		ArrayList<Cell> col2 = service2.selectColumnValue();
		ArrayList<Cell> col3 = service3.selectColumnValue();

		for (int i = 1; i < col.size(); i++) {

			cellDAO.createCellHier(
					Long.parseLong(formatter.formatCellValue(col.get(i))),
					Long.parseLong(formatter.formatCellValue(col1.get(i))),
					Long.parseLong(formatter.formatCellValue(col2.get(i))),
					Long.parseLong(formatter.formatCellValue(col3.get(i))));
		}
	}

	public void createDuration() throws InvalidFormatException,
			FileNotFoundException, IOException {

		DurationDAO durationDAO = new DurationDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {

			durationDAO.createDuration(Integer.parseInt(formatter
					.formatCellValue(col.get(i))));
		}
	}

	public void createEventId() throws InvalidFormatException,
			FileNotFoundException, IOException {
		EventIdDAO eventId = new EventIdDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {

			eventId.createEventId(Integer.parseInt(formatter
					.formatCellValue(col.get(i))));
		}
	}

	public void createIMSI() throws InvalidFormatException,
			FileNotFoundException, IOException {
		IMSIDAO imsi = new IMSIDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			imsi.createIMSI(Long.parseLong(formatter.formatCellValue(col.get(i))));
		}
	}

	public void createInputMode() throws InvalidFormatException,
			FileNotFoundException, IOException {
		InputModeDAO input = new InputModeDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			input.createInputMode(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createOSType() throws InvalidFormatException,
			FileNotFoundException, IOException {
		OSTypeDAO os = new OSTypeDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			os.createOSType(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createUEType() throws InvalidFormatException,
			FileNotFoundException, IOException {
		UETypeDAO ue = new UETypeDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			ue.createUEType(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createNEVersion() throws InvalidFormatException,
			FileNotFoundException, IOException {
		NEVersionDAO ne = new NEVersionDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			ne.createNEVersion(Integer.parseInt(formatter.formatCellValue(col
					.get(i))));
		}
	}

	public void createMCC() throws InvalidFormatException,
			FileNotFoundException, IOException {
		MCCDAO mcc = new MCCDAOImpl();
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			mcc.createMCC(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col1.get(i)));
		}
	}

	public void createMNC() throws InvalidFormatException,
			FileNotFoundException, IOException {
		MNCDAO mnc = new MNCDAOImpl();
		MCCDAO mcc = new MCCDAOImpl();
		service = new ApachePOIService(0, 6, file);

		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		ArrayList<Cell> col2 = service2.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			mnc.createMNC(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col1.get(i)), mcc
							.getByMCC(Integer.parseInt(formatter
									.formatCellValue(col2.get(i)))));
		}
	}

	public void createFailure() throws InvalidFormatException,
			FileNotFoundException, IOException {

		service = new ApachePOIService(0, 6, file);
		FailureDAO failureDAO = new FailureDAOImpl();
		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {

			failureDAO.createFailure(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col1.get(i)));
		}
	}

	public void createEventCause() throws InvalidFormatException,
			FileNotFoundException, IOException {
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		ArrayList<Cell> col2 = service2.selectColumnValue();
		EventCauseDAO eventCause = new EventCauseDAOImpl();
		EventIdDAO eventId = new EventIdDAOImpl();
		for (int i = 1; i < col.size(); i++) {

			eventCause.createEventCause(Integer.parseInt(formatter
					.formatCellValue(col.get(i))), formatter
					.formatCellValue(col1.get(i)), eventId.getByEventId(Integer
					.parseInt(formatter.formatCellValue(col2.get(i)))));
		}
	}

	public void createUE() throws InvalidFormatException,
			FileNotFoundException, IOException {
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		ArrayList<Cell> col2 = service2.selectColumnValue();
		ArrayList<Cell> col3 = service3.selectColumnValue();
		ArrayList<Cell> col4 = service4.selectColumnValue();
		ArrayList<Cell> col5 = service5.selectColumnValue();
		ArrayList<Cell> col6 = service6.selectColumnValue();
		ArrayList<Cell> col7 = service7.selectColumnValue();
		ArrayList<Cell> col8 = service8.selectColumnValue();

		/*
		 * tac, marketingName, manufacturer, accessCapability, model, vendorName,
		 *  os, inputMode, ueType
		 */

		UEDAO ue = new UEDAOImpl();

		OSTypeDAO os = new OSTypeDAOImpl();
		InputModeDAO input = new InputModeDAOImpl();
		UETypeDAO ueType = new UETypeDAOImpl();
		for (int i = 1; i < col.size(); i++) {

			ue.createUE(Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col1.get(i)),
					formatter.formatCellValue(col2.get(i)),
					formatter.formatCellValue(col3.get(i)),
					formatter.formatCellValue(col4.get(i)),
					formatter.formatCellValue(col5.get(i)),
					os.getByOSType(formatter.formatCellValue(col6.get(i))),
					input.getByInputMode(formatter.formatCellValue(col1.get(i))),
					ueType.getByUEType(formatter.formatCellValue(col1.get(i))));
		}
	}

	public void createFault() throws InvalidFormatException,
			FileNotFoundException, IOException {
		service = new ApachePOIService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		ArrayList<Cell> col2 = service2.selectColumnValue();
		ArrayList<Cell> col3 = service3.selectColumnValue();
		ArrayList<Cell> col4 = service4.selectColumnValue();
		ArrayList<Cell> col5 = service5.selectColumnValue();
		ArrayList<Cell> col6 = service6.selectColumnValue();
		ArrayList<Cell> col7 = service7.selectColumnValue();
		ArrayList<Cell> col8 = service8.selectColumnValue();

		/*
		 * date, eventId, failure, tac, mcc, mnc, cellId, duration, eventCause
		 */

		FaultDAO fault = new FaultDAOImpl();
		FailureDAO fail = new FailureDAOImpl();
		EventIdDAO eventId = new EventIdDAOImpl();
		UEDAO ue = new UEDAOImpl();
		MCCDAO mcc = new MCCDAOImpl();
		MNCDAO mnc = new MNCDAOImpl();
		CellDAO cell = new CellDAOImpl();
		DurationDAO duration = new DurationDAOImpl();
		EventCauseDAO eventCause = new EventCauseDAOImpl();
		for (int i = 1; i < col.size(); i++) {

			fault.createFault(formatter.formatCellValue(col.get(i)), eventId
					.getByEventId(Integer.parseInt(formatter
							.formatCellValue(col1.get(i)))), fail
					.getByFailure(Integer.parseInt(formatter
							.formatCellValue(col2.get(i)))), ue
					.getByTac(Integer.parseInt(formatter.formatCellValue(col3
							.get(i)))), mcc.getByMCC(Integer.parseInt(formatter
					.formatCellValue(col4.get(i)))), mnc.getByMNC(Integer
					.parseInt(formatter.formatCellValue(col5.get(i)))), cell
					.getByCellId(Long.parseLong(formatter.formatCellValue(col6
							.get(i)))), 
					duration.getByDuration(Integer
					.parseInt(formatter.formatCellValue(col7.get(i)))),
					eventCause.getByEventCause(Integer.parseInt(formatter
							.formatCellValue(col8.get(i)))));
		}
	}
}