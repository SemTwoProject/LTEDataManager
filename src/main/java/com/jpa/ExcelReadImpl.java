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
import com.entity.MccMnc;
import com.entity.UE;

@Stateful
@Local
public class ExcelReadImpl implements ExcelDAO {

	@PersistenceContext
	private EntityManager em;
	
	@PersistenceContext
	private EntityManager emOther;

	private Map<CellHier, Integer> cells;
	private Map<EventCause, Integer> eventIds;
	private Map<EventCause, Integer> eventCauses;
	private Map<Failure, Integer> fails;
	private Map<MccMnc, Integer> mccMccs;
	private Map<MccMnc, Integer> mccMncs;
	private Map<UE, Integer> ues;
	private CopyOnWriteArrayList<Fault> faults;

	public void createCell(HSSFWorkbook wb) {
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		Double cell;
		Double cell1;
		Double cell2;
		Double cell3;
		CellHier cellHier;
		cells = new HashMap<CellHier, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(6).getNumericCellValue();
			cell1 = row.getCell(11).getNumericCellValue();
			cell2 = row.getCell(12).getNumericCellValue();
			cell3 = row.getCell(13).getNumericCellValue();
			cellHier = new CellHier(cell.intValue(), cell1.longValue(),
					cell2.longValue(), cell3.longValue());
			cells.put(cellHier, cell.intValue());

		}
		if (cells.size() > 1) {
			for (CellHier cellHierList : cells.keySet()) {
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
		eventIds = new HashMap<EventCause, Integer>();
		eventCauses = new HashMap<EventCause, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getNumericCellValue();
			cell2 = row.getCell(2).getStringCellValue();
			eventCause = new EventCause(cell.intValue(), cell1.intValue(),
					cell2);
			eventIds.put(eventCause, cell1.intValue());
			eventCauses.put(eventCause, cell.intValue());
		}
		if (eventIds.size() > 1) {
			for (EventCause eventCauseList : eventIds.keySet()) {
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
		fails = new HashMap<Failure, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getStringCellValue();
			fail = new Failure(cell.intValue(), cell1);
			fails.put(fail, cell.intValue());
		}
		if (fails.size() > 1) {
			for (Failure failsList : fails.keySet()) {
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
		mccMccs = new HashMap<MccMnc, Integer>();
		mccMncs = new HashMap<MccMnc, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(2).getStringCellValue();
			cell2 = row.getCell(1).getNumericCellValue();
			cell3 = row.getCell(3).getStringCellValue();
			mcc = new MccMnc(cell.intValue(), cell1, cell2.intValue(), cell3);
			mccMccs.put(mcc, cell.intValue());
			mccMncs.put(mcc, cell2.intValue());
		}
		if (mccMccs.size() > 1) {
			for (MccMnc mccMncsList : mccMccs.keySet()) {
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
		ues = new HashMap<UE, Integer>();
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
			ues.put(ue,cell.intValue());
		}
		if (ues.size() > 1) {
			for (UE ueList : ues.keySet()) {
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
		for (int i = 1; i < sheet.getLastRowNum() +1; i++) {
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
			} else {
				String temp = row.getCell(2).getStringCellValue();
				if (temp.equals("(null)")) {
					temp = "88888.88";
					cell2 = Double.parseDouble(temp);
				} else {
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
				if (temp.equals("(null)")) {
					temp = "88888.88";
					cell8 = Double.parseDouble(temp);
				} else {
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
		for (Fault faultList : faults) {
				if (eventIds.containsValue(faultList.getEventCause().getEventId())
						&& eventCauses.containsValue(faultList.getEventCause().getCauseCode())
						&& fails.containsValue(faultList.getFailure().getfailure())
						&& mccMccs.containsValue(faultList.getMccid().getMccId())
						&& mccMncs.containsValue(faultList.getMccid().getMncId())
						&& ues.containsValue(faultList.getTac().getTac())
						&& cells.containsValue(faultList.getCell().getCellId())) {
					 emOther.persist(faultList);
				} else {
					invalidFaults.add(faultList);
					faults.remove(faultList);
				}
			}
	}
}