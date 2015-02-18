package com.jpa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.dao.*;

@Stateless
@Local
public class ExcelReadImpl implements ExcelDAO {

	private DataFormatter formatter = new HSSFDataFormatter();
	private InputStream file = getClass().getClassLoader().getResourceAsStream("test.xls");

	public void createCell() throws InvalidFormatException,
			FileNotFoundException, IOException {

		CellDAO cellDAO = new CellDAOImpl();
		ArrayList<Cell> col = selectColumnValue(1, 0);
		ArrayList<Cell> col1 = selectColumnValue(0, 11);
		ArrayList<Cell> col2 = selectColumnValue(0, 12);
		ArrayList<Cell> col3 = selectColumnValue(0, 13);

		for (int i = 1; i < col.size(); i++) {

			cellDAO.createCellHier(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					Long.parseLong(formatter.formatCellValue(col1.get(i))),
					Long.parseLong(formatter.formatCellValue(col2.get(i))),
					Long.parseLong(formatter.formatCellValue(col3.get(i))));
		}
	}

	public void createDuration() throws InvalidFormatException,
			FileNotFoundException, IOException {

		DurationDAO durationDAO = new DurationDAOImpl();
		ArrayList<Cell> col = selectColumnValue(0, 7);
		for (int i = 1; i < col.size(); i++) {

			durationDAO.createDuration(Integer.parseInt(formatter
					.formatCellValue(col.get(i))));
		}
	}

	public void createEventId() throws InvalidFormatException,
			FileNotFoundException, IOException {

		EventIdDAO eventId = new EventIdDAOImpl();
		ArrayList<Cell> col = selectColumnValue(1, 1);
		for (int i = 1; i < col.size(); i++) {

			eventId.createEventId(Integer.parseInt(formatter
					.formatCellValue(col.get(i))));
		}
	}

	public void createIMSI() throws InvalidFormatException,
			FileNotFoundException, IOException {

		IMSIDAO imsi = new IMSIDAOImpl();
		ArrayList<Cell> col = selectColumnValue(0, 10);
		for (int i = 1; i < col.size(); i++) {
			imsi.createIMSI(Long.parseLong(formatter.formatCellValue(col.get(i))));
		}
	}

	public void createInputMode() throws InvalidFormatException,
			FileNotFoundException, IOException {

		InputModeDAO input = new InputModeDAOImpl();
		ArrayList<Cell> col = selectColumnValue(3, 8);
		for (int i = 1; i < col.size(); i++) {
			input.createInputMode(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createOSType() throws InvalidFormatException,
			FileNotFoundException, IOException {

		OSTypeDAO os = new OSTypeDAOImpl();
		ArrayList<Cell> col = selectColumnValue(3, 9);
		for (int i = 1; i < col.size(); i++) {
			os.createOSType(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createUEType() throws InvalidFormatException,
			FileNotFoundException, IOException {

		UETypeDAO ue = new UETypeDAOImpl();
		ArrayList<Cell> col = selectColumnValue(3, 6);
		for (int i = 1; i < col.size(); i++) {
			ue.createUEType(formatter.formatCellValue(col.get(i)));
		}
	}

	public void createNEVersion() throws InvalidFormatException,
			FileNotFoundException, IOException {

		NEVersionDAO ne = new NEVersionDAOImpl();
		ArrayList<Cell> col = selectColumnValue(0, 9);
		for (int i = 1; i < col.size(); i++) {
			ne.createNEVersion(Integer.parseInt(formatter.formatCellValue(col
					.get(i))));
		}
	}

	public void createMCC() throws InvalidFormatException,
			FileNotFoundException, IOException {

		MCCDAO mcc = new MCCDAOImpl();
		ArrayList<Cell> col = selectColumnValue(4, 0);
		ArrayList<Cell> col1 = selectColumnValue(4, 2);
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
		ArrayList<Cell> col = selectColumnValue(4, 1);
		ArrayList<Cell> col1 = selectColumnValue(4, 3);
		ArrayList<Cell> col2 = selectColumnValue(4, 0);
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

		FailureDAO failureDAO = new FailureDAOImpl();
		ArrayList<Cell> col = selectColumnValue(2, 0);
		ArrayList<Cell> col1 = selectColumnValue(2, 1);
		for (int i = 1; i < col.size(); i++) {

			failureDAO.createFailure(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col1.get(i)));
		}
	}

	public void createEventCause() throws InvalidFormatException,
			FileNotFoundException, IOException {

		ArrayList<Cell> col = selectColumnValue(1, 0);
		ArrayList<Cell> col1 = selectColumnValue(1, 2);
		ArrayList<Cell> col2 = selectColumnValue(1, 1);
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

		ArrayList<Cell> col = selectColumnValue(3, 0);
		ArrayList<Cell> col1 = selectColumnValue(3, 1);
		ArrayList<Cell> col2 = selectColumnValue(3, 2);
		ArrayList<Cell> col3 = selectColumnValue(3, 3);
		ArrayList<Cell> col4 = selectColumnValue(3, 4);
		ArrayList<Cell> col5 = selectColumnValue(3, 5);
		ArrayList<Cell> col6 = selectColumnValue(3, 6);
		ArrayList<Cell> col7 = selectColumnValue(3, 7);
		ArrayList<Cell> col8 = selectColumnValue(3, 8);

		/*
		 * tac, marketingName, manufacturer, accessCapability, model,
		 * vendorName, os, inputMode, ueType
		 */

		UEDAO ue = new UEDAOImpl();

		OSTypeDAO os = new OSTypeDAOImpl();
		InputModeDAO input = new InputModeDAOImpl();
		UETypeDAO ueType = new UETypeDAOImpl();
		for (int i = 1; i < col.size(); i++) {

			ue.createUE(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
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

	public void createFault() throws InvalidFormatException,
			FileNotFoundException, IOException {

		ArrayList<Cell> col = selectColumnValue(0, 0);
		ArrayList<Cell> col1 = selectColumnValue(0, 1);
		ArrayList<Cell> col2 = selectColumnValue(0, 2);
		ArrayList<Cell> col3 = selectColumnValue(0, 3);
		ArrayList<Cell> col4 = selectColumnValue(0, 4);
		ArrayList<Cell> col5 = selectColumnValue(0, 5);
		ArrayList<Cell> col6 = selectColumnValue(0, 6);
		ArrayList<Cell> col7 = selectColumnValue(0, 7);
		ArrayList<Cell> col8 = selectColumnValue(0, 8);
		ArrayList<Cell> col9 = selectColumnValue(0, 9);

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
							.get(i)))), duration.getByDuration(Integer
					.parseInt(formatter.formatCellValue(col7.get(i)))),
					eventCause.getByEventCause(Integer.parseInt(formatter
							.formatCellValue(col8.get(i)))), ne.getByNE(Integer
							.parseInt(formatter.formatCellValue(col9.get(i)))));
		}
	}

	private ArrayList<Cell> selectColumnValue(int sheetNumber, int cellNumber)
			throws InvalidFormatException {

		ArrayList<Cell> list = new ArrayList<Cell>();
		try {
			HSSFWorkbook wb = new HSSFWorkbook(file);
			Sheet sheet = wb.getSheetAt(sheetNumber);

			for (int i = 1; i < sheet.getLastRowNum(); i++) {
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
		System.out.println(list.size());
		return list;

	}
}