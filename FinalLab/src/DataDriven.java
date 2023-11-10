import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

class DataDriven {

	@Test
	void testRead() throws Exception  {
		//Path of the excel file
		FileInputStream fs = new FileInputStream("D:/webdriver/DemoFile.xlsx");
		
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);

		XSSFSheet sheet = workbook.getSheetAt(0);

		System.out.println(sheet.getRow(0).getCell(0));

		System.out.println(sheet.getRow(0).getCell(1));

		System.out.println(sheet.getRow(0).getCell(2));

		System.out.println(sheet.getRow(1).getCell(0));

		System.out.println(sheet.getRow(1).getCell(1));

		System.out.println(sheet.getRow(1).getCell(2));
		
		workbook.close();
	}
	@Test

	void testWriteFile() throws IOException {

		FileInputStream fs = new FileInputStream("D:/webdriver/DemoFile.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int lastRow = sheet1.getLastRowNum();
		for (int i = 0; i <= lastRow; i++) {
			XSSFRow row = sheet1.getRow(i);
			XSSFCell cell = row.createCell(0);

			cell.setCellValue("WriteintoExcel");
		}
		FileOutputStream fos = new FileOutputStream("D:/webdriver/DemoFile.xlsx");
		wb.write(fos);
		fos.close();
	}

}