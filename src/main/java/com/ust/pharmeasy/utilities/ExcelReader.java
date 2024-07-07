package com.ust.pharmeasy.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	static XSSFRow row;
	public static String[][] getData(String path, String sheetname){
		
		try {
			FileInputStream fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int colcount = row.getPhysicalNumberOfCells();
		String[][] data = new String[rowcount][colcount];
		DataFormatter df = new DataFormatter();
//		int colcount = sheet.getRow(0)
		for(int i=0; i<rowcount; i++) {
			for(int j=0; j<colcount; j++) {
				data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return data;
	}
	

}
