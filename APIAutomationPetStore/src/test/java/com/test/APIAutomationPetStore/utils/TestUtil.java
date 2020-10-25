package com.test.APIAutomationPetStore.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public final static int RESPONSE_CODE_200 = 200;
	public final static int RESPONSE_CODE_201 = 201;
	public final static int RESPONSE_CODE_400 = 400;
	public final static int RESPONSE_CODE_401 = 401;
	

	
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "./Testdata/TestData.xlsx";
	
//get data from excel:
	public static Object[][] getDataFromSheet(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()-1][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--------" );
		// sheet.getRow(0).getLastCellNum());
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {
				data[i-1][k] = sheet.getRow(i).getCell(k).toString();
				System.out.println(data[i-1][k]);
			}
		}
		return data;
	}
	
}
