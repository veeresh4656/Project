package com.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel {

	public static void main(String[] args) throws Throwable {
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Sheet1");
for(int i=1;i<=sh.getLastRowNum();i++) {
	
String branch = sh.getRow(i).getCell(0).getStringCellValue();
String lang = sh.getRow(i).getCell(1).getStringCellValue();
String mon = sh.getRow(i).getCell(2).getStringCellValue();
System.out.println(branch+"  "+lang+"  "+mon+"");

	}

}
}
