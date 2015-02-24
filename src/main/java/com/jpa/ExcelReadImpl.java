package com.jpa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.fileupload.FileUpload;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.dao.EventCauseDAO;
import com.dao.ExcelDAO;
import com.dao.FaultDAO;
import com.dao.MNCDAO;
import com.dao.UEDAO;
import com.entity.CellHier;
import com.entity.Duration;
import com.entity.EventCause;
import com.entity.EventId;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.IMSI;
import com.entity.InputMode;
import com.entity.MCC;
import com.entity.MNC;
import com.entity.NEVersion;
import com.entity.OSType;
import com.entity.UE;
import com.entity.UEType;

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
	private POIFSFileSystem fs;
	private Sheet sheet;
	private HSSFWorkbook wb;
	private InputStream inputStream;

	public void createCell(FileUpload form) throws InvalidFormatException,
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
		EventCauseDAO dao = new EventCauseDAOImpl();
		try {
			col = selectColumnValue(1, 0);
			col1 = selectColumnValue(1, 2);
			col2 = selectColumnValue(1, 1);

			for (int i = 0; i < col.size(); i++) {
				eventCause = new EventCause(Integer.parseInt(formatter
						.formatCellValue(col.get(i))),
						formatter.formatCellValue(col1.get(i)),
						dao.getByEventId(Integer.parseInt(formatter
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
			for (int i = 0; i < col.size(); i++) {
				imsi = new IMSI(Long.parseLong(formatter.formatCellValue(col
						.get(i))));
				em.persist(imsi);
			}
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
				ne = new NEVersion(formatter.formatCellValue(col.get(i)));
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
		MNCDAO dao = new MNCDAOImpl();
		try {
			col = selectColumnValue(4, 1);
			col1 = selectColumnValue(4, 3);
			col2 = selectColumnValue(4, 0);
			for (int i = 0; i < col.size(); i++) {
				mnc = new MNC(Integer.parseInt(formatter.formatCellValue(col
						.get(i))), formatter.formatCellValue(col1.get(i)),
						dao.getByMCC(Integer.parseInt(formatter
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

		UEDAO dao = new UEDAOImpl();

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
				ue = new UE(
						Integer.parseInt(formatter.formatCellValue(col.get(i))),
						formatter.formatCellValue(col1.get(i)),
						formatter.formatCellValue(col2.get(i)),
						formatter.formatCellValue(col3.get(i)),
						formatter.formatCellValue(col4.get(i)),
						formatter.formatCellValue(col5.get(i)),
						dao.getByOSType(formatter.formatCellValue(col6.get(i))),
						dao.getByInputMode(formatter.formatCellValue(col7
								.get(i))), dao.getByUEType(formatter
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
		ArrayList<Cell> col10;

		FaultDAO dao = new FaultDAOImpl();
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
			col10 = selectColumnValue(0, 10);

			/*
			 * date, eventId, failure, tac, mcc, mnc, cellId, duration,
			 * eventCause, imsi
			 */
			for (int i = 0; i < col.size(); i++) {
				fault = new Fault(col.get(i).getDateCellValue(),
						dao.getByEventId(Integer.parseInt(formatter
								.formatCellValue(col1.get(i)))),
						dao.getByFailure(Integer.parseInt(formatter
								.formatCellValue(col2.get(i)))),
						dao.getByTac(Integer.parseInt(formatter
								.formatCellValue(col3.get(i)))),
						dao.getByMCC(Integer.parseInt(formatter
								.formatCellValue(col4.get(i)))),
						dao.getByMNC(Integer.parseInt(formatter
								.formatCellValue(col5.get(i)))),
						dao.getByCellId(Integer.parseInt(formatter
								.formatCellValue(col6.get(i)))),
						dao.getByDuration(Integer.parseInt(formatter
								.formatCellValue(col7.get(i)))),
						dao.getByEventCause(Integer.parseInt(formatter
								.formatCellValue(col8.get(i)))),
						dao.getByNE(formatter.formatCellValue(col9.get(i))),
						dao.getByIMSI(Long.parseLong(formatter
								.formatCellValue(col10.get(i)))));
				em.persist(fault);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public ArrayList<Cell> selectColumnValue(int sheetNumber, int cellNumber)
			throws InvalidFormatException {

		ArrayList<Cell> list = new ArrayList<Cell>();

		try {
			File f = new File("/test.xls");
			inputStream = new FileInputStream(f);

			fs = new POIFSFileSystem(inputStream);
			inputStream.close();
			wb = new HSSFWorkbook(fs);

			sheet = wb.getSheetAt(sheetNumber);
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
