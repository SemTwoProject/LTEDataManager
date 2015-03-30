package com.jpa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

@Local
@Stateful
public class ExcelReadImpl implements ExcelDAO {

	@PersistenceContext
	private EntityManager em;

	private ArrayList<Fault> invalidFaults;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private FileInputStream in;
	private Map<CellHier, Integer> cellsList;
	private Map<EventCause, Integer> eventIdsList;
	private Map<EventCause, Integer> eventCausesList;
	private Map<Failure, Integer> failsList;
	private Map<MccMnc, Integer> mccMccsList;
	private Map<MccMnc, Integer> mccMncsList;
	private Map<UE, Integer> uesList;
	private CopyOnWriteArrayList<Fault> faults;
	CellHier cellHier;

	public void callAll() {
		try {
			String file = "upload.xls";
			String path = "c:\\excel\\" + file;
			in = new FileInputStream(new File(path));
			wb = new HSSFWorkbook(in);
			createCell();
			createEventCause();
			createFailure();
			createMccMnc();
			createUE();
			createFault();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void createCell() {
		sheet = wb.getSheetAt(0);
		Double cell;
		Double cell1;
		Double cell2;
		Double cell3;
		
		cellsList = new HashMap<CellHier, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(6).getNumericCellValue();
			cell1 = row.getCell(11).getNumericCellValue();
			cell2 = row.getCell(12).getNumericCellValue();
			cell3 = row.getCell(13).getNumericCellValue();
			cellHier = new CellHier(cell.intValue(), cell1.longValue(),
					cell2.longValue(), cell3.longValue());
			cellsList.put(cellHier, cell.intValue());

		}
		if (cellsList.size() > 1) {
			for (CellHier cellHierList : cellsList.keySet()) {
				em.merge(cellHierList);
			}
		}
	}

	public void createEventCause() {
		sheet = wb.getSheetAt(1);
		Double cell;
		Double cell1;
		String cell2;
		EventCause eventCause;
		eventIdsList = new HashMap<EventCause, Integer>();
		eventCausesList = new HashMap<EventCause, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getNumericCellValue();
			cell2 = row.getCell(2).getStringCellValue();
			eventCause = new EventCause(cell.intValue(), cell1.intValue(),
					cell2);
			eventIdsList.put(eventCause, cell1.intValue());
			eventCausesList.put(eventCause, cell.intValue());
		}
		if (eventIdsList.size() > 1) {
			for (EventCause eventCauseList : eventIdsList.keySet()) {
				em.merge(eventCauseList);
			}
		}
	}

	public void createFailure() {
		sheet = wb.getSheetAt(2);
		Double cell;
		String cell1;
		Failure fail;
		failsList = new HashMap<Failure, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(1).getStringCellValue();
			fail = new Failure(cell.intValue(), cell1);
			failsList.put(fail, cell.intValue());
		}
		if (failsList.size() > 1) {
			for (Failure failsList : failsList.keySet()) {
				em.merge(failsList);
			}
		}
	}

	public void createMccMnc() {
		sheet = wb.getSheetAt(4);
		Double cell;
		String cell1;
		Double cell2;
		String cell3;
		MccMnc mcc;
		mccMccsList = new HashMap<MccMnc, Integer>();
		mccMncsList = new HashMap<MccMnc, Integer>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0).getNumericCellValue();
			cell1 = row.getCell(2).getStringCellValue();
			cell2 = row.getCell(1).getNumericCellValue();
			cell3 = row.getCell(3).getStringCellValue();
			mcc = new MccMnc(cell.intValue(), cell1, cell2.intValue(), cell3);
			mccMccsList.put(mcc, cell.intValue());
			mccMncsList.put(mcc, cell2.intValue());
		}
		if (mccMccsList.size() > 1) {
			for (MccMnc mccMncsList : mccMccsList.keySet()) {
				em.merge(mccMncsList);
			}
		}
	}

	public void createUE() {
		sheet = wb.getSheetAt(3);
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
		uesList = new HashMap<UE, Integer>();
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
			uesList.put(ue, cell.intValue());
		}
		if (uesList.size() > 1) {
			for (UE ueList : uesList.keySet()) {
				em.merge(ueList);
			}
		}
	}

	public void createFault() {

		sheet = wb.getSheetAt(0);
		Fault fault;
		Double date;
		Double eventId;
		Double failure;
		Double tac;
		Double mcc;
		Double mnc;
		Double cell;
		Double duration;
		Double causeid;
		String ne;
		Double imsi;
		faults = new CopyOnWriteArrayList<Fault>();
		int id = createId();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				date = row.getCell(0).getNumericCellValue();
			} else {
				String temp = row.getCell(0).getStringCellValue();
				date = Double.parseDouble(temp);
			}
			if (row.getCell(1).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				eventId = row.getCell(1).getNumericCellValue();
			} else {
				String temp = row.getCell(1).getStringCellValue();
				eventId = Double.parseDouble(temp);
			}
			if (row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				failure = row.getCell(2).getNumericCellValue();
			} else {
				String temp = row.getCell(2).getStringCellValue();
				if (temp.equals("(null)")) {
					temp = "88888.88";
					failure = Double.parseDouble(temp);
				} else {
					failure = Double.parseDouble(temp);
				}
			}
			if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				tac = row.getCell(3).getNumericCellValue();
			} else {
				String temp = row.getCell(3).getStringCellValue();
				tac = Double.parseDouble(temp);
			}
			if (row.getCell(4).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				mcc = row.getCell(4).getNumericCellValue();
			} else {
				String temp = row.getCell(4).getStringCellValue();
				mcc = Double.parseDouble(temp);
			}
			if (row.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				mnc = row.getCell(5).getNumericCellValue();
			} else {
				String temp = row.getCell(5).getStringCellValue();
				mnc = Double.parseDouble(temp);
			}
			if(row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC){
				for(CellHier cellHiers: cellsList.keySet()){
					cell = row.getCell(6).getNumericCellValue();
					if(cellHiers.getCellId() == cell.intValue()){
						cellHier = cellHiers;
					}
				}
			}
//			if (row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//				cellHier = row.getCell(6).getNumericCellValue();
//			} else {
//				String temp = row.getCell(6).getStringCellValue();
//				cellHier = Double.parseDouble(temp);
//			}
			if (row.getCell(7).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				duration = row.getCell(7).getNumericCellValue();
			} else {
				String temp = row.getCell(7).getStringCellValue();
				duration = Double.parseDouble(temp);
			}
			if (row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				causeid = row.getCell(8).getNumericCellValue();
			} else {
				String temp = row.getCell(8).getStringCellValue();
				if (temp.equals("(null)")) {
					temp = "88888.88";
					causeid = Double.parseDouble(temp);
				} else {
					causeid = Double.parseDouble(temp);
				}
			}
			if (row.getCell(9).getCellType() == Cell.CELL_TYPE_STRING) {
				ne = row.getCell(9).getStringCellValue();
			} else {
				Double temp = row.getCell(9).getNumericCellValue();
				ne = temp.toString();
			}
			if (row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				imsi = row.getCell(10).getNumericCellValue();
			} else {
				String temp = row.getCell(10).getStringCellValue();
				imsi = Double.parseDouble(temp);
			}
			fault = new Fault(id+i, HSSFDateUtil.getJavaDate(date),
					eventId.intValue(), failure.intValue(), tac.intValue(),
					mcc.intValue(), mnc.intValue(), cellHier,
					duration.intValue(), causeid.intValue(), ne,
					imsi.longValue());
			faults.add(fault);
		}
		ArrayList<Fault> invalidFaults = new ArrayList<Fault>();
		for (Fault faultList : faults) {
			if (eventIdsList.containsValue(faultList.getEventCause().getEventId())
					&& eventCausesList.containsValue(faultList.getEventCause()
							.getCauseCode())
					&& failsList.containsValue(faultList.getFailure().getfailure())
					&& mccMccsList.containsValue(faultList.getMccid().getMccId())
					&& mccMncsList.containsValue(faultList.getMccid().getMncId())
					&& uesList.containsValue(faultList.getTac().getTac())
					&& cellsList.containsValue(faultList.getCell().getCellId())) {
				em.merge(faultList);
			} else {
				invalidFaults.add(faultList);
				faults.remove(faultList);
			}
		}
	}

	public void writeErrorToLog() {
		// save the array list objects to file
		String fileName = "c:\\excel\\invalid.txt";
		try {
			ObjectOutputStream fileOut = new ObjectOutputStream(
					new FileOutputStream(fileName));
			for (Fault invalid : invalidFaults) {
				fileOut.writeObject(invalid);
			}
			fileOut.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public int createId(){
		Query q = em.createQuery("select f.id from Fault f order by f.id desc");
		return q.getFirstResult();
	}
}
