package com.jpa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import com.dao.ExcelDAO;
import com.entity.CellHier;
import com.entity.EventCause;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.MccMnc;
import com.entity.UE;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class ExcelReadImpl implements ExcelDAO {

	@PersistenceContext
	private EntityManager em;

	private CellHier cellHier;
	private EventCause eventCause;
	private Failure failure;
	private Fault fault;
	private MccMnc mcc;
	private UE ue;
	@SuppressWarnings("rawtypes")
	private ArrayList list;

	public void createCell(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		ArrayList<Double> col;
		ArrayList<Double> col1;
		ArrayList<Double> col2;
		ArrayList<Double> col3;

		try {
			col = selectColumnValue(0, 6, wb);
			col1 = selectColumnValue(0, 11, wb);
			col2 = selectColumnValue(0, 12, wb);
			col3 = selectColumnValue(0, 13, wb);

			for (int i = 0; i < col.size(); i++) {
				cellHier = new CellHier(col.get(i).intValue(), col1.get(i)
						.longValue(), col2.get(i).longValue(), col3.get(i)
						.longValue());
				em.merge(cellHier);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}

	}

	public void createEventCause(HSSFWorkbook wb) {
		ArrayList<Double> col;
		ArrayList<Double> col2;
		ArrayList<String> col1;
		try {
			col = selectColumnValue(1, 0, wb);
			col2 = selectColumnValue(1, 1, wb);
			col1 = selectColumnValue(1, 2, wb);

			for (int i = 0; i < col.size(); i++) {
				eventCause = new EventCause(col.get(i).intValue(),col2.get(i).intValue(),col1.get(i));
				em.merge(eventCause);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createFailure(HSSFWorkbook wb) {
		ArrayList<Double> col;
		ArrayList<String> col1;
		try {
			col = selectColumnValue(2, 0, wb);
			col1 = selectColumnValue(2, 1, wb);
			for (int i = 0; i < col.size(); i++) {
				failure = new Failure(col.get(i).intValue(), col1.get(i));
				em.merge(failure);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createMccMnc(HSSFWorkbook wb) {
		ArrayList<Double> col;
		ArrayList<String> col1;
		ArrayList<Double> col2;
		ArrayList<String> col3;
		try {
			col = selectColumnValue(4, 0, wb);
			col1 = selectColumnValue(4, 2, wb);
			col2 = selectColumnValue(4, 1, wb);
			col3 = selectColumnValue(4, 3, wb);
			for (int i = 0; i < col.size(); i++) {
				mcc = new MccMnc(col.get(i).intValue(), col1.get(i), col2.get(i).intValue(), col3.get(i));
				em.merge(mcc);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createUE(HSSFWorkbook wb) {
		ArrayList<Double> col;
		ArrayList<String> col1;
		ArrayList<String> col2;
		ArrayList<String> col3;
		ArrayList<String> col4;
		ArrayList<String> col5;
		ArrayList<String> col6;
		ArrayList<String> col7;
		ArrayList<String> col8;
		/*
		 * tac, marketingName, manufacturer, accessCapability, model,
		 * vendorName, os, inputMode, ueType
		 */
		try {
			col = selectColumnValue(3, 0, wb);
			col1 = selectColumnValue(3, 1, wb);
			col2 = selectColumnValue(3, 2, wb);
			col3 = selectColumnValue(3, 3, wb);
			col4 = selectColumnValue(3, 4, wb);
			col5 = selectColumnValue(3, 5, wb);
			col6 = selectColumnValue(3, 6, wb);
			col7 = selectColumnValue(3, 7, wb);
			col8 = selectColumnValue(3, 8, wb);

			for (int i = 1; i < col.size(); i++) {

				ue = new UE(col.get(i).intValue(), col1.get(i), col2.get(i),
						col3.get(i), col4.get(i), col5.get(i), col6.get(i),
						col7.get(i), col8.get(i));
				em.merge(ue);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	public void createFault(HSSFWorkbook wb) {
		ArrayList<Double> col;
		ArrayList<Double> col1;
		ArrayList<Double> col2;
		ArrayList<Double> col3;
		ArrayList<Double> col4;
		ArrayList<Double> col5;
		ArrayList<Double> col6;
		ArrayList<Double> col7;
		ArrayList<Double> col8;
		ArrayList<String> col9;
		ArrayList<Double> col10;

		try {
			col = selectColumnValue(0, 0, wb);
			col1 = selectColumnValue(0, 1, wb);
			col2 = selectColumnValue(0, 2, wb);
			col3 = selectColumnValue(0, 3, wb);
			col4 = selectColumnValue(0, 4, wb);
			col5 = selectColumnValue(0, 5, wb);
			col6 = selectColumnValue(0, 6, wb);
			col7 = selectColumnValue(0, 7, wb);
			col8 = selectColumnValue(0, 8, wb);
			col9 = selectColumnValue(0, 9, wb);
			col10 = selectColumnValue(0, 10, wb);
			/*
			 * String date, Integer eventId, Failure failureid, UE tac,
			* Integer mcc, Integer mnc, CellHier cell_id, Integer duration,
			* Integer causeid, String ne, Long imsi
			 */
			for (int i = 0; i < col.size(); i++) {
				fault = new Fault(HSSFDateUtil.getJavaDate(col.get(i).doubleValue()),
						col1.get(i).intValue(),
						col2.get(i).intValue(),
						col3.get(i).intValue(),
						col4.get(i).intValue(),
						col5.get(i).intValue(),
						col6.get(i).intValue(),
						col7.get(i).intValue(),
						col8.get(i).intValue(),
						col9.get(i),
						col10.get(i).longValue()
						);
				em.merge(fault);
			}
		} catch (InvalidFormatException e) {
			e.getMessage();
		}
	}

	@SuppressWarnings("rawtypes")
	public ArrayList selectColumnValue(int sheetNumber, int cellNumber,
			HSSFWorkbook wb) throws InvalidFormatException {
		list = new ArrayList();
		HSSFSheet sheet = wb.getSheetAt(sheetNumber);
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			HSSFRow row = sheet.getRow(i);
			HSSFCell cell = row.getCell(cellNumber);	
			if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				list.add(cell.getNumericCellValue());
			else if(cell.getCellType() == Cell.CELL_TYPE_STRING)
				list.add(cell.getStringCellValue());
		//	else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
			//	cell.setCellValue("null");
				//list.add(cell);
		}
		return list;
	}
}