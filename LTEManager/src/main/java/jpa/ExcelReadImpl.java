package jpa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import dao.CellDAO;
import dao.DurationDAO;
import dao.EventCauseDAO;
import dao.EventIdDAO;
import dao.ExcelDAO;
import dao.FailureDAO;
import dao.InputModeDAO;
import dao.MCCDAO;
import dao.MNCDAO;
import dao.NEVersionDAO;
import dao.OSTypeDAO;
import dao.UEDAO;
import dao.UETypeDAO;
import entities.CellHier;
import entities.Duration;
import entities.EventCause;
import entities.EventId;
import entities.Failure;
import entities.Fault;
import entities.IMSI;
import entities.InputMode;
import entities.MCC;
import entities.MNC;
import entities.NEVersion;
import entities.OSType;
import entities.UE;
import entities.UEType;

@Stateless
@Local
public class ExcelReadImpl implements ExcelDAO {

	@PersistenceContext
	private EntityManager em;

	private CellHier cell;
	private Duration duration;
	private EventCause eventCause;
	private EventId eventId;
	private Failure failure;
	private Fault fault;
	private IMSI imsi;
	private InputMode input;
	private OSType os;
	private NEVersion ne;
	private MCC mcc;
	private MNC mnc;
	private UE ue;
	private UEType ueType;
	private HSSFDataFormatter formatter;

	public void createCell() throws InvalidFormatException,
			FileNotFoundException, IOException {
		ArrayList<Cell> col;
		ArrayList<Cell> col1;
		ArrayList<Cell> col2;
		ArrayList<Cell> col3;
		try {
			col = selectColumnValue(0, 10);
			col1 = selectColumnValue(0, 11);
			col2 = selectColumnValue(0, 12);
			col3 = selectColumnValue(0, 13);

			for (int i = 0; i < col.size(); i++) {
				cell = new CellHier(Integer.parseInt(formatter
						.formatCellValue(col.get(i))), Long.parseLong(formatter
						.formatCellValue(col1.get(i))),
						Long.parseLong(formatter.formatCellValue(col2.get(i))),
						Long.parseLong(formatter.formatCellValue(col3.get(i))));
				em.persist(cell);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}

	}

	public void createDuration() {
		ArrayList<Cell> col;
		try {
			col = selectColumnValue(1, 1);
			for (int i = 0; i < col.size(); i++) {
				duration = new Duration(Integer.parseInt(formatter
						.formatCellValue(col.get(i))));
				em.persist(duration);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createEventId() {
		ArrayList<Cell> col;
		try {
			col = selectColumnValue(1, 1);
			for (int i = 0; i < col.size(); i++) {
				eventId = new EventId(Integer.parseInt(formatter
						.formatCellValue(col.get(i))));
				em.persist(eventId);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createEventCause() {
		ArrayList<Cell> col;
		ArrayList<Cell> col1;
		ArrayList<Cell> col2;
		EventIdDAO eventId = new EventIdDAOImpl();
		try {
			col = selectColumnValue(1, 0);
			col1 = selectColumnValue(1, 2);
			col2 = selectColumnValue(1, 1);

			for (int i = 0; i < col.size(); i++) {
				eventCause = new EventCause(Integer.parseInt(formatter
						.formatCellValue(col.get(i))),
						formatter.formatCellValue(col1.get(i)),
						eventId.getByEventId(Integer.parseInt(formatter
								.formatCellValue(col2.get(i)))));
				em.persist(eventCause);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createFailure() {
		ArrayList<Cell> col;
		ArrayList<Cell> col1;
		try {
			col = selectColumnValue(2, 0);
			col1 = selectColumnValue(2, 1);
			for (int i = 0; i < col.size(); i++) {
				failure = new Failure(Integer.parseInt(formatter
						.formatCellValue(col.get(i))),
						formatter.formatCellValue(col1.get(i)));
				em.persist(failure);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createIMSI() throws InvalidFormatException {
		ArrayList<Cell> col;
		try {
			col = selectColumnValue(0, 10);
			// for (int i = 0; i < col.size(); i++) {
			imsi = new IMSI(
					Long.parseLong(formatter.formatCellValue(col.get(1))));
			em.persist(imsi);
			// }
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createInputMode() {
		ArrayList<Cell> col;
		try {
			col = selectColumnValue(3, 8);
			for (int i = 0; i < col.size(); i++) {
				input = new InputMode(formatter.formatCellValue(col.get(i)));
				em.persist(input);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createNEVersion() {
		ArrayList<Cell> col;
		try {
			col = selectColumnValue(0, 9);
			for (int i = 0; i < col.size(); i++) {
				ne = new NEVersion(Integer.parseInt(formatter
						.formatCellValue(col.get(i))));
				em.persist(ne);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createUEType() {
		ArrayList<Cell> col;
		try {
			col = selectColumnValue(3, 6);
			for (int i = 0; i < col.size(); i++) {
				ueType = new UEType(formatter.formatCellValue(col.get(i)));
				em.persist(ueType);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createOSType() {
		ArrayList<Cell> col;
		try {
			col = selectColumnValue(3, 9);
			for (int i = 0; i < col.size(); i++) {
				os = new OSType(formatter.formatCellValue(col.get(i)));
				em.persist(os);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createMCC() {
		ArrayList<Cell> col;
		ArrayList<Cell> col1;
		try {
			col = selectColumnValue(4, 0);
			col1 = selectColumnValue(4, 2);
			for (int i = 0; i < col.size(); i++) {
				mcc = new MCC(Integer.parseInt(formatter.formatCellValue(col
						.get(i))), formatter.formatCellValue(col1.get(i)));
				em.persist(mcc);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createMNC() {
		ArrayList<Cell> col;
		ArrayList<Cell> col1;
		ArrayList<Cell> col2;
		MCCDAO mccM = new MCCDAOImpl();
		try {
			col = selectColumnValue(4, 1);
			col1 = selectColumnValue(4, 3);
			col2 = selectColumnValue(4, 0);
			for (int i = 0; i < col.size(); i++) {
				mnc = new MNC(Integer.parseInt(formatter.formatCellValue(col
						.get(i))), formatter.formatCellValue(col1.get(i)),
						mccM.getByMCC(Integer.parseInt(formatter
								.formatCellValue(col2.get(i)))));
				em.persist(mnc);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createUE() {
		ArrayList<Cell> col;
		ArrayList<Cell> col1;
		ArrayList<Cell> col2;
		ArrayList<Cell> col3;
		ArrayList<Cell> col4;
		ArrayList<Cell> col5;
		ArrayList<Cell> col6;
		ArrayList<Cell> col7;
		ArrayList<Cell> col8;

		/*
		 * tac, marketingName, manufacturer, accessCapability, model,
		 * vendorName, os, inputMode, ueType
		 */

		OSTypeDAO os = new OSTypeDAOImpl();
		InputModeDAO input = new InputModeDAOImpl();
		UETypeDAO ueType = new UETypeDAOImpl();

		try {
			col = selectColumnValue(3, 0);
			col1 = selectColumnValue(3, 1);
			col2 = selectColumnValue(3, 2);
			col3 = selectColumnValue(3, 3);
			col4 = selectColumnValue(3, 4);
			col5 = selectColumnValue(3, 5);
			col6 = selectColumnValue(3, 6);
			col7 = selectColumnValue(3, 7);
			col8 = selectColumnValue(3, 8);

			for (int i = 0; i < col.size(); i++) {
				ue = new UE(Integer.parseInt(formatter.formatCellValue(col
						.get(i))), formatter.formatCellValue(col1.get(i)),
						formatter.formatCellValue(col2.get(i)),
						formatter.formatCellValue(col3.get(i)),
						formatter.formatCellValue(col4.get(i)),
						formatter.formatCellValue(col5.get(i)),
						os.getByOSType(formatter.formatCellValue(col6.get(i))),
						input.getByInputMode(formatter.formatCellValue(col7
								.get(i))), ueType.getByUEType(formatter
								.formatCellValue(col8.get(i))));

				em.persist(ue);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createFault() {
		ArrayList<Cell> col;
		ArrayList<Cell> col1;
		ArrayList<Cell> col2;
		ArrayList<Cell> col3;
		ArrayList<Cell> col4;
		ArrayList<Cell> col5;
		ArrayList<Cell> col6;
		ArrayList<Cell> col7;
		ArrayList<Cell> col8;
		ArrayList<Cell> col9;

		FailureDAO failF = new FailureDAOImpl();
		EventIdDAO eventIdF = new EventIdDAOImpl();
		UEDAO ueF = new UEDAOImpl();
		MCCDAO mccF = new MCCDAOImpl();
		MNCDAO mncF = new MNCDAOImpl();
		CellDAO cellF = new CellDAOImpl();
		DurationDAO durationF = new DurationDAOImpl();
		EventCauseDAO eventCauseF = new EventCauseDAOImpl();
		NEVersionDAO neF = new NEVersionDAOImpl();
		try {
			col = selectColumnValue(0, 0);
			col1 = selectColumnValue(0, 1);
			col2 = selectColumnValue(0, 2);
			col3 = selectColumnValue(0, 3);
			col4 = selectColumnValue(0, 4);
			col5 = selectColumnValue(0, 5);
			col6 = selectColumnValue(0, 6);
			col7 = selectColumnValue(0, 7);
			col8 = selectColumnValue(0, 8);
			col9 = selectColumnValue(0, 9);

			/*
			 * date, eventId, failure, tac, mcc, mnc, cellId, duration,
			 * eventCause
			 */
			for (int i = 0; i < col.size(); i++) {
				fault = new Fault(formatter.formatCellValue(col.get(i)),
						eventIdF.getByEventId(Integer.parseInt(formatter
								.formatCellValue(col1.get(i)))),
						failF.getByFailure(Integer.parseInt(formatter
								.formatCellValue(col2.get(i)))),
						ueF.getByTac(Integer.parseInt(formatter
								.formatCellValue(col3.get(i)))),
						mccF.getByMCC(Integer.parseInt(formatter
								.formatCellValue(col4.get(i)))),
						mncF.getByMNC(Integer.parseInt(formatter
								.formatCellValue(col5.get(i)))),
						cellF.getByCellId(Integer.parseInt(formatter
								.formatCellValue(col6.get(i)))),
						durationF.getByDuration(Integer.parseInt(formatter
								.formatCellValue(col7.get(i)))),
						eventCauseF.getByEventCause(Integer.parseInt(formatter
								.formatCellValue(col8.get(i)))),
						neF.getByNE(Integer.parseInt(formatter
								.formatCellValue(col9.get(i)))));
				em.persist(fault);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public ArrayList<Cell> selectColumnValue(int sheetNumber, int cellNumber)
			throws InvalidFormatException {

		ArrayList<Cell> list = new ArrayList<Cell>();

		File file;
		FileInputStream inputStream;

		try {
			file = new File(getClass().getClassLoader().getResource("test.xls")
					.getFile());
			inputStream = new FileInputStream(file);
			HSSFWorkbook wb = new HSSFWorkbook(inputStream);
			Sheet sheet = wb.getSheetAt(sheetNumber);

			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(cellNumber);
				list.add(cell);
			}
			wb.close();

		} catch (FileNotFoundException fi) {
			System.out.println(fi.getMessage());
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
		return list;

	}
}
