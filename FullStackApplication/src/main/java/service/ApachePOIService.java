package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ApachePOIService {

	private int cellNumber, sheetNumber;
	private File file;

	public ApachePOIService(int sheetNumber, int cellNumber, File file)
			throws InvalidFormatException, FileNotFoundException, IOException {
		this.sheetNumber = sheetNumber;
		this.cellNumber = cellNumber;
		this.file = file;
	}

	public ArrayList<Cell> selectColumnValue() throws InvalidFormatException,
			IOException, FileNotFoundException {

		ArrayList<Cell> list = new ArrayList<Cell>();
		// get everything in a specified column from a work sheet
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		Sheet sheet = wb.getSheetAt(sheetNumber);

		for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
			Row row = sheet.getRow(j);
			Cell cell = row.getCell(cellNumber);
			list.add(cell);
		}

		return list;

	}

}