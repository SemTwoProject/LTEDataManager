package com.jpa;

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
import com.entity.InvalidData;
import com.entity.MccMnc;
import com.entity.UE;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class ExcelReadImpl implements ExcelDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("rawtypes")
	private ArrayList list;

	public void createInvalid(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(0);
		/**
		 * Date date, Integer eventId, Integer failure, Integer ueType, Integer
		 * market, Integer operator, Integer cell, Integer duration, Integer
		 * causeCode, String neVersion, Long imsi, Long hier3Id, Long hier32Id,
		 * Long hier321Id
		 **/

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			HSSFRow row = sheet.getRow(i);

			Double cell = row.getCell(0).getNumericCellValue();
			Double cell1 = row.getCell(1).getNumericCellValue();
			Double cell2 = row.getCell(2).getNumericCellValue();
			Double cell3 = row.getCell(3).getNumericCellValue();
			Double cell4 = row.getCell(4).getNumericCellValue();
			Double cell5 = row.getCell(5).getNumericCellValue();
			Double cell6 = row.getCell(6).getNumericCellValue();
			Double cell7 = row.getCell(7).getNumericCellValue();
			Double cell8 = row.getCell(8).getNumericCellValue();
			String cell9 = row.getCell(9).getStringCellValue();
			Double cell10 = row.getCell(10).getNumericCellValue();
			Double cell11 = row.getCell(11).getNumericCellValue();
			Double cell12 = row.getCell(12).getNumericCellValue();
			Double cell13 = row.getCell(13).getNumericCellValue();
			InvalidData invalid = new InvalidData(
					HSSFDateUtil.getJavaDate(cell), cell1.intValue(),
					cell2.intValue(), cell3.intValue(), cell4.intValue(),
					cell5.intValue(), cell6.intValue(), cell7.intValue(),
					cell8.intValue(), cell9, cell10.longValue(),
					cell11.longValue(), cell12.longValue(), cell13.longValue());
			em.persist(invalid);
		}
	}

	public void createCell(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		Double cell;
		Double cell1;
		Double cell2;
		Double cell3;
		CellHier cellHier;
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(6).getNumericCellValue();
			cell1 = row.getCell(11).getNumericCellValue();
			cell2 = row.getCell(12).getNumericCellValue();
			cell3 = row.getCell(13).getNumericCellValue();
			cellHier = new CellHier(cell.intValue(), cell1.longValue(),
					cell2.longValue(), cell3.longValue());
			em.merge(cellHier);
		}
	}

	public void createEventCause(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(1);
		HSSFRow row;
		Double cell;
		Double cell1;
		String cell2;
		EventCause eventCause;
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getNumericCellValue();
			cell2 = row.getCell(2).getStringCellValue();
			eventCause = new EventCause(cell.intValue(), cell1.intValue(),
					cell2);
			em.merge(eventCause);
		}
	}

	public void createFailure(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(2);
		HSSFRow row;
		Double cell;
		String cell1;
		Failure fail;
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getStringCellValue();
			fail = new Failure(cell.intValue(), cell1);
			em.merge(fail);
		}
	}

	public void createMccMnc(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(4);
		HSSFRow row;
		Double cell;
		String cell1;
		Double cell2;
		String cell3;
		MccMnc mcc;
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(2).getStringCellValue();
			cell2 = row.getCell(1).getNumericCellValue();
			cell3 = row.getCell(3).getStringCellValue();
			mcc = new MccMnc(cell.intValue(), cell1, cell2.intValue(), cell3);
			em.merge(mcc);
		}
	}

	public void createUE(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(3);
		HSSFRow row;
		UE ue;
		Double cell;
		String cell1;
		String cell2;
		String cell3;
		String cell4;
		String cell5;
		String cell6;
		String cell7;
		String cell8;
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getStringCellValue();
			cell2 = row.getCell(2).getStringCellValue();
			cell3 = row.getCell(3).getStringCellValue();
			cell4 = row.getCell(4).getStringCellValue();
			cell5 = row.getCell(5).getStringCellValue();
			cell6 = row.getCell(6).getStringCellValue();
			cell7 = row.getCell(7).getStringCellValue();
			cell8 = row.getCell(8).getStringCellValue();
			ue = new UE(cell.intValue(), cell1, cell2, cell3, cell4, cell5,
					cell6, cell7, cell8);
			em.persist(ue);
		}
	}

	public void createFault(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		Fault fault;
		Double cell;
		Double cell1;
		Double cell2;
		Double cell3;
		Double cell4;
		Double cell5;
		Double cell6;
		Double cell7;
		Double cell8;
		String cell9;
		Double cell10;
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getNumericCellValue();
			cell2 = row.getCell(2).getNumericCellValue();
			cell3 = row.getCell(3).getNumericCellValue();
			cell4 = row.getCell(4).getNumericCellValue();
			cell5 = row.getCell(5).getNumericCellValue();
			cell6 = row.getCell(6).getNumericCellValue();
			cell7 = row.getCell(7).getNumericCellValue();
			cell8 = row.getCell(8).getNumericCellValue();
			cell9 = row.getCell(9).getStringCellValue();
			cell10 = row.getCell(10).getNumericCellValue();
			fault = new Fault(HSSFDateUtil.getJavaDate(cell), cell1.intValue(),
					cell2.intValue(), cell3.intValue(), cell4.intValue(),
					cell5.intValue(), cell6.intValue(), cell7.intValue(),
					cell8.intValue(), cell9, cell10.longValue());
			em.persist(fault);
		}
	}
}