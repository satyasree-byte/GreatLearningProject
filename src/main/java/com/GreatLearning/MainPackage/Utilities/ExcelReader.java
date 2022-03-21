package com.GreatLearning.MainPackage.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	// public static Workbook w;
	public static XSSFWorkbook workbook;
//	static PropertyFileReader prop = new PropertyFileReader();
	
	public interface RowHandler {
		@SuppressWarnings("rawtypes")
		boolean handleRow(Map row);
	}

	public static void read(String fileName, String sheetName, RowHandler rowHandler) throws Exception {
		File getfile;
		/*final String strRelPath = ExcelReader.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.split("bin")[0].replace("%20", " ");*/
		final String strRelPath = "./";
		try {
			
				getfile = new File("C:\\Users\\satyasree\\Downloads\\MiCredit_Automation\\src\\test\\resources\\DataEngineNew.xlsx");

			final FileInputStream file = new FileInputStream(getfile);

			read(file, sheetName, rowHandler);
		} finally {
			// file.close(); // Closing file is not available in File.class
		}
	}

	@SuppressWarnings("unused")
	private static void read(FileInputStream file, String sheetName, RowHandler rowHandler) throws Exception {

		XSSFSheet sheet = null;
		try {
			// w = Workbook.getWorkbook(file);
			workbook = new XSSFWorkbook(file);

			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				// sheetNames.add(workbook.getSheetName(i));
				if (workbook.getSheetName(i).contains(sheetName)) {
					sheet = workbook.getSheetAt(i);
					break;
				}
			}
			read(sheet, rowHandler);
		} finally {
			workbook.close();
		}
	}

	@SuppressWarnings("unused")
	private static void read(Sheet sheet, RowHandler rowHandler) throws IOException {

		final List columnHeader = new ArrayList();
		// Get row Count
		int getRowCount = 0;
		for (Row row : sheet) {
			getRowCount = getRowCount + 1;
		}

		// Get ColumnHeader
		for (Row row : sheet) {
			for (Cell cell : row) {
				columnHeader.add(cell);
			}
			break;
		}

		for (int rowNum = 1; rowNum < getRowCount; rowNum++) {
			final Row r = sheet.getRow(rowNum);

			int count = 0;
			final Map<String, String> rowMap = new HashMap<String, String>();
			for (int cn = 0; cn < columnHeader.size(); cn++) {

				final Cell cell = r.getCell(cn);

				if (cell == null) {
					rowMap.put(columnHeader.get(count).toString(), null);
					count++;
				} else {
					cell.setCellType(CellType.STRING);
					rowMap.put(columnHeader.get(count).toString(), cell.toString());
					count++;
				}
			}
			rowHandler.handleRow(rowMap);
		}
		workbook.close();

	}

	public static class RowArrayBuilder implements RowHandler {
		private List<Map> rows;

		public RowArrayBuilder(List<Map> rows) {
			this.rows = rows;
		}

		public boolean handleRow(Map row) {
			rows.add(row);
			return false;
		}
	}

	public static List<Map> read(String fileName, String sheetName) throws Exception {
		final List rows = new ArrayList<Map>();
		// String sheetName = "McDonalds";
		read(fileName, sheetName, new RowArrayBuilder(rows));
		return rows;
		
	}

}
