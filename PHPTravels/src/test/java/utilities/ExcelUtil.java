package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil {

	XSSFWorkbook workbook;

	XSSFSheet sheet;

	public ExcelUtil(String path) {

		try {

			FileInputStream fis = new FileInputStream(path);

			workbook = new XSSFWorkbook(fis);

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public int getRowCount(String sheetName) {

		sheet = workbook.getSheet(sheetName);

		return sheet.getLastRowNum();
	}

	public String getCellData(

			String sheetName, int row, int cell) {

		sheet = workbook.getSheet(sheetName);

		return sheet.getRow(row).getCell(cell).toString();
	}
}