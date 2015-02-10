package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class JPADriver {

	private ApachePOIReader reader;
	private ApachePOIReader reader2;
	DataFormatter formatter = new DataFormatter();

	public JPADriver() throws IOException, InvalidFormatException {
		// TODO Auto-generated constructor stub
		createFailureClass();

	}

	public void createFailureClass() throws InvalidFormatException,
			FileNotFoundException, IOException {
		reader = new ApachePOIReader(2, 0, new File("test.xls"));
		ArrayList<Cell> col = reader.selectColumnValue();

		reader2 = new ApachePOIReader(2, 1, new File("test.xls"));
		ArrayList<Cell> col2 = reader2.selectColumnValue();
		FailureDAO fail = new FailureDAO();

		for (int i = 0; i < col.size(); i++) {
			fail.createFailure(
					Integer.parseInt(formatter.formatCellValue(col.get(i))),
					formatter.formatCellValue(col2.get(i)));
		}
	}

	public static void main(String[] args) throws IOException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		new JPADriver();

	}

}
