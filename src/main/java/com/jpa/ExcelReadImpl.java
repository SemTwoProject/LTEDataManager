package com.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.dao.ExcelDAO;
import com.entity.CellHier;
import com.entity.EventCause;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.InvalidData;
import com.entity.MccMnc;
import com.entity.UE;

@Stateful
@Local
public class ExcelReadImpl implements ExcelDAO {

	@PersistenceContext
	private EntityManager em;

	Map<Integer, CellHier> cells;
	Map<Integer, EventCause> eventCauses;
	Map<Integer, Failure> fails;
	Map<Integer, MccMnc> mccMncs;
	Map<Integer, UE> ues;
	CopyOnWriteArrayList<Fault> faults;

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
		cells = new HashMap<Integer, CellHier>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(6).getNumericCellValue();
			cell1 = row.getCell(11).getNumericCellValue();
			cell2 = row.getCell(12).getNumericCellValue();
			cell3 = row.getCell(13).getNumericCellValue();
			cellHier = new CellHier(cell.intValue(), cell1.longValue(),
					cell2.longValue(), cell3.longValue());
			cells.put(i, cellHier);

		}
		if (cells.size() > 1) {
			for (CellHier cellHierList : cells.values()) {
				em.merge(cellHierList);
			}
		}
	}

	public void createEventCause(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(1);
		HSSFRow row;
		Double cell;
		Double cell1;
		String cell2;
		EventCause eventCause;
		eventCauses = new HashMap<Integer, EventCause>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getNumericCellValue();
			cell2 = row.getCell(2).getStringCellValue();
			eventCause = new EventCause(cell.intValue(), cell1.intValue(),
					cell2);
			eventCauses.put(i, eventCause);
		}
		if (eventCauses.size() > 1) {
			for (EventCause eventCauseList : eventCauses.values()) {
				em.merge(eventCauseList);
			}
		}
	}

	public void createFailure(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(2);
		HSSFRow row;
		Double cell;
		String cell1;
		Failure fail;
		fails = new HashMap<Integer, Failure>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getStringCellValue();
			fail = new Failure(cell.intValue(), cell1);
			fails.put(i, fail);
		}
		if (fails.size() > 1) {
			for (Failure failsList : fails.values()) {
				em.merge(failsList);
			}
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
		mccMncs = new HashMap<Integer, MccMnc>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(2).getStringCellValue();
			cell2 = row.getCell(1).getNumericCellValue();
			cell3 = row.getCell(3).getStringCellValue();
			mcc = new MccMnc(cell.intValue(), cell1, cell2.intValue(), cell3);
			mccMncs.put(i, mcc);
		}
		if (mccMncs.size() > 1) {
			for (MccMnc mccMncsList : mccMncs.values()) {
				em.merge(mccMncsList);
			}
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
		ues = new HashMap<Integer, UE>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
				cell1 = row.getCell(1).getStringCellValue();
			} else {
				Double temp = row.getCell(1).getNumericCellValue();
				cell1 = temp.toString();
			}
			cell2 = row.getCell(2).getStringCellValue();
			cell3 = row.getCell(3).getStringCellValue();
			if (row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
				cell4 = row.getCell(4).getStringCellValue();
			} else {
				Double temp = row.getCell(4).getNumericCellValue();
				cell4 = temp.toString();
			}
			if (row.getCell(5).getCellType() == Cell.CELL_TYPE_STRING) {
				cell5 = row.getCell(5).getStringCellValue();
			} else {
				Double temp = row.getCell(5).getNumericCellValue();
				cell5 = temp.toString();
			}
			cell6 = "" + row.getCell(6).getStringCellValue();
			cell7 = "" + row.getCell(7).getStringCellValue();
			cell8 = "" + row.getCell(8).getStringCellValue();
			ue = new UE(cell.intValue(), cell1, cell2, cell3, cell4, cell5,
					cell6, cell7, cell8);
			ues.put(i, ue);
		}
		if (ues.size() > 1) {
			for (UE ueList : ues.values()) {
				em.merge(ueList);
			}
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
		faults = new CopyOnWriteArrayList<Fault>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell = row.getCell(0).getNumericCellValue();
			} else {
				String temp = row.getCell(0).getStringCellValue();
				cell = Double.parseDouble(temp);
			}
			if (row.getCell(1).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell1 = row.getCell(1).getNumericCellValue();
			} else {
				String temp = row.getCell(1).getStringCellValue();
				cell1 = Double.parseDouble(temp);
			}
			if (row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell2 = row.getCell(2).getNumericCellValue();
			}
			else {
				String temp = row.getCell(2).getStringCellValue();
				if(temp.equals("(null)")){
					temp = "88888.88";
					cell2 = Double.parseDouble(temp);
				}else{
				cell2 = Double.parseDouble(temp);
				}
			}
			if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell3 = row.getCell(3).getNumericCellValue();
			} else {
				String temp = row.getCell(3).getStringCellValue();
				cell3 = Double.parseDouble(temp);
			}
			if (row.getCell(4).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell4 = row.getCell(4).getNumericCellValue();
			} else {
				String temp = row.getCell(4).getStringCellValue();
				cell4 = Double.parseDouble(temp);
			}
			if (row.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell5 = row.getCell(5).getNumericCellValue();
			} else {
				String temp = row.getCell(5).getStringCellValue();
				cell5 = Double.parseDouble(temp);
			}
			if (row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell6 = row.getCell(6).getNumericCellValue();
			} else {
				String temp = row.getCell(6).getStringCellValue();
				cell6 = Double.parseDouble(temp);
			}
			if (row.getCell(7).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell7 = row.getCell(7).getNumericCellValue();
			} else {
				String temp = row.getCell(7).getStringCellValue();
				cell7 = Double.parseDouble(temp);
			}
			if (row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell8 = row.getCell(8).getNumericCellValue();
			} else {
				String temp = row.getCell(8).getStringCellValue();
				if(temp.equals("(null)")){
					temp = "88888.88";
					cell8 = Double.parseDouble(temp);
				}else{
				cell8 = Double.parseDouble(temp);
				}
			}
			if (row.getCell(9).getCellType() == Cell.CELL_TYPE_STRING) {
				cell9 = row.getCell(9).getStringCellValue();
			} else {
				Double temp = row.getCell(9).getNumericCellValue();
				cell9 = temp.toString();
			}
			if (row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cell10 = row.getCell(10).getNumericCellValue();
			} else {
				String temp = row.getCell(10).getStringCellValue();
				cell10 = Double.parseDouble(temp);
			}
			fault = new Fault(HSSFDateUtil.getJavaDate(cell), cell1.intValue(),
					cell2.intValue(), cell3.intValue(), cell4.intValue(),
					cell5.intValue(), cell6.intValue(), cell7.intValue(),
					cell8.intValue(), cell9, cell10.longValue());
			faults.add(fault);
		}

		ArrayList<Fault> invalidFaults = new ArrayList<Fault>();
		System.out.println(eventCauses.size());
		System.out.println(fails.size());
		System.out.println(mccMncs.size());
		System.out.println(eventCauses.size());
		for (Fault faultList : faults) {
			if (!eventCauses.containsValue(faultList.getEventCause().getEventId())) {
				invalidFaults.add(faultList);
				faults.remove(faultList);
			} else if (!fails
					.containsValue(faultList.getFailure().getfailure())) {
				invalidFaults.add(faultList);
				faults.remove(faultList);
			} else if (!mccMncs.containsValue(faultList.getMccid().getMccId())) {
				invalidFaults.add(faultList);
				faults.remove(faultList);
			} else if (!eventCauses.containsValue(faultList.getEventCause()
					.getCauseCode())) {
				invalidFaults.add(faultList);
				faults.remove(faultList);
			} else if (!ues.containsValue(faultList.getTac().getTac())) {
				invalidFaults.add(faultList);
				faults.remove(faultList);
			} else if (!cells.containsValue(faultList.getCell().getCellId())) {
				invalidFaults.add(faultList);
				faults.remove(faultList);
			}
			System.out.println(faults.size());
			em.persist(faultList);
		}
//		for(Fault faultList: faults){
//			em.persist(faultList);
//		}
	}
}