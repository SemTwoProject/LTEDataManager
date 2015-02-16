package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface ExcelDAO {

	// are not dependent on the creation of parent entity
	public void createCell(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createDuration(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createIMSI(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createInputMode(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createOSType(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createNEVersion(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createUEType(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createMCC(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createFailure(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createEventId(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	// are child dependents
	public void createMNC(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createEventCause(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createUE(File file) throws InvalidFormatException, FileNotFoundException, IOException;
	public void createFault(File file)throws InvalidFormatException, FileNotFoundException, IOException;

}
