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

import service.ExcelService;
import dao.*;

@Stateless
@Local
public class ExcelReadImpl implements ExcelDAO {

	private DataFormatter formatter = new DataFormatter();
	private ExcelService service;
	private ExcelService service1;
	private ExcelService service2;
	private ExcelService service3;
	private ExcelService service4;
	private ExcelService service5;
	private ExcelService service6;
	private ExcelService service7;
	private ExcelService service8;
	private ExcelService service9;
	@PersistenceContext
	private EntityManager em;

	public void createCell(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {

		CellDAO cellDAO = new CellDAOImpl();
		service = new ExcelService(0, 6, file);
		ArrayList<Cell> col = service.selectColumnValue();
		service1 = new ExcelService(0, 11, file);
		ArrayList<Cell> col1 = service1.selectColumnValue();
		service2 = new ExcelService(0, 12, file);
		ArrayList<Cell> col2 = service2.selectColumnValue();
		service3 = new ExcelService(0, 13, file);
		ArrayList<Cell> col3 = service3.selectColumnValue();

		for (int i = 1; i < col.size(); i++) {

			cellDAO.createCellHier(
					Long.parseLong(formatter.formatCellValue(col.get(i))),
					Long.parseLong(formatter.formatCellValue(col1.get(i))),
					Long.parseLong(formatter.formatCellValue(col2.get(i))),
					Long.parseLong(formatter.formatCellValue(col3.get(i))));
		}
	}

	public void createDuration(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {

		DurationDAO durationDAO = new DurationDAOImpl();
		service = new ExcelService(0, 7, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {

			durationDAO.createDuration(Integer.parseInt(formatter
					.formatCellValue(col.get(i))));
		}
	}

	public void createEventId(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		EventIdDAO eventId = new EventIdDAOImpl();
		service = new ExcelService(1, 1, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {

			eventId.createEventId(Integer.parseInt(formatter
					.formatCellValue(col.get(i))));
		}
	}

	public void createIMSI(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		IMSIDAO imsi = new IMSIDAOImpl();
		service = new ExcelService(0, 10, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			imsi.createIMSI(Long.parseLong(formatter.formatCellValue(col.get(i))));
		}
	}

	public void createInputMode(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		InputModeDAO input = new InputModeDAOImpl();
		service = new ExcelService(3, 8, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			input.createInputMode(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createOSType(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		OSTypeDAO os = new OSTypeDAOImpl();
		service = new ExcelService(3, 9, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			os.createOSType(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createUEType(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		UETypeDAO ue = new UETypeDAOImpl();
		service = new ExcelService(3, 8, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			ue.createUEType(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createNEVersion(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		NEVersionDAO ne = new NEVersionDAOImpl();
		service = new ExcelService(0, 9, file);
		ArrayList<Cell> col = service.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			ne.createNEVersion(Integer.parseInt(formatter.formatCellValue(col
					.get(i))));
		}
	}

	public void createMCC(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		MCCDAO mcc = new MCCDAOImpl();
		service = new ExcelService(4, 0, file);
		ArrayList<Cell> col = service.selectColumnValue();
		service1 = new ExcelService(4, 2, file);
		ArrayList<Cell> col1 = service1.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {
			mcc.createMCC(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col1.get(i)));
		}
	}

	public void createMNC(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		MNCDAO mnc = new MNCDAOImpl();
		MCCDAO mcc = new MCCDAOImpl();
		service = new ExcelService(4, 1, file);
		service1 = new ExcelService(4, 3, file);
		service2 = new ExcelService(4, 0, file);
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

	public void createFailure(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {

		service = new ExcelService(2, 0, file);
		service1 = new ExcelService(2, 1, file);
		FailureDAO failureDAO = new FailureDAOImpl();
		ArrayList<Cell> col = service.selectColumnValue();
		ArrayList<Cell> col1 = service1.selectColumnValue();
		for (int i = 1; i < col.size(); i++) {

			failureDAO.createFailure(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col1.get(i)));
		}
	}

	public void createEventCause(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		service = new ExcelService(1, 0, file);
		ArrayList<Cell> col = service.selectColumnValue();
		service1 = new ExcelService(1, 2, file);
		ArrayList<Cell> col1 = service1.selectColumnValue();
		service2 = new ExcelService(1, 1, file);
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

	public void createUE(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		service = new ExcelService(3, 0, file);
		ArrayList<Cell> col = service.selectColumnValue();
		service1 = new ExcelService(3, 1, file);
		ArrayList<Cell> col1 = service1.selectColumnValue();
		service2 = new ExcelService(3, 2, file);
		ArrayList<Cell> col2 = service2.selectColumnValue();
		service3 = new ExcelService(3, 3, file);
		ArrayList<Cell> col3 = service3.selectColumnValue();
		service4 = new ExcelService(3, 4, file);
		ArrayList<Cell> col4 = service4.selectColumnValue();
		service5 = new ExcelService(3, 5, file);
		ArrayList<Cell> col5 = service5.selectColumnValue();
		service6 = new ExcelService(3, 6, file);
		ArrayList<Cell> col6 = service6.selectColumnValue();
		service7 = new ExcelService(3, 7, file);
		ArrayList<Cell> col7 = service7.selectColumnValue();
		service8 = new ExcelService(3, 8, file);
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
					input.getByInputMode(formatter.formatCellValue(col7.get(i))),
					ueType.getByUEType(formatter.formatCellValue(col8.get(i))));
		}
	}

	public void createFault(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		service = new ExcelService(0, 0, file);
		ArrayList<Cell> col = service.selectColumnValue();
		service1 = new ExcelService(0, 1, file);
		ArrayList<Cell> col1 = service1.selectColumnValue();
		service2 = new ExcelService(0, 2, file);
		ArrayList<Cell> col2 = service2.selectColumnValue();
		service3 = new ExcelService(0, 3, file);
		ArrayList<Cell> col3 = service3.selectColumnValue();
		service4 = new ExcelService(0, 4, file);
		ArrayList<Cell> col4 = service4.selectColumnValue();
		service5 = new ExcelService(0, 5, file);
		ArrayList<Cell> col5 = service5.selectColumnValue();
		service6 = new ExcelService(0, 6, file);
		ArrayList<Cell> col6 = service6.selectColumnValue();
		service7 = new ExcelService(0, 7, file);
		ArrayList<Cell> col7 = service7.selectColumnValue();
		service8 = new ExcelService(0, 8, file);
		ArrayList<Cell> col8 = service8.selectColumnValue();
		service9 = new ExcelService(0, 9, file);
		ArrayList<Cell> col9 = service9.selectColumnValue();

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
		NEVersionDAO ne = new NEVersionDAOImpl();
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
							.formatCellValue(col8.get(i)))), ne.getByNE(Integer.parseInt(formatter
							.formatCellValue(col9.get(i)))));
		}
	}
}