package com.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetExcelData {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
wb.getSheet("Sheet1").getRow(2).getCell(2).setCellValue("january");
FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
wb.write(fos);
wb.close();
	}

}
