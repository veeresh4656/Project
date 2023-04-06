package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class ExcelUtilities {
/**
 * This method is used to read data from ExcelFile
 * @param SheetName
 * @param RowNo
 * @param ColumNo
 * @return
 * @throws Throwable
 * @author USER
 */
public String readdataFromExcel(String SheetName,int RowNo,int ColumNo) throws Throwable {
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(SheetName);
String value=sh.getRow(RowNo).getCell(ColumNo).getStringCellValue();
	return value;
}

/**
 * @param SheetName
 * @return
 * @throws Throwable
 */
public int getLastRowNo(String SheetName) throws Throwable {
FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet(SheetName);
int count=sh.getLastRowNum();
return count;
}

public void writeDataIntoExcel(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable {
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(SheetName);
	sh.getRow(RowNo).createCell(ColumnNo).setCellValue(data);
	FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
	wb.write(fos);
}
/**
 * This method is used to readMultipleData from Excel
 * @param sheetName
 * @return
 * @throws Throwable
 * @author USER
 */
public HashMap<String,String> readMultipleData(String sheetName) throws Throwable{
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int count=sh.getLastRowNum();
//	HashMap<String,String> map=new HashMap<String,String>();
/*	for(int i=0;i<=count;i++)
	{
		String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key,value);
	}
	return map;*/
	 HashMap<String,String> hs=new HashMap<String, String>();
	 for(int i=0;i<sh.getLastRowNum();i++)
	 {
		 String key=sh.getRow(i).getCell(0).getStringCellValue();
		 String value=sh.getRow(i).getCell(1).getStringCellValue();
		 hs.put(key, value);
		 
	 }
	 return hs;
//	for(java.util.Map.Entry<String, String> set:hs.entrySet())
//	 {
//		 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//	 }

}
@DataProvider
public Object[][] readMultipleDataFromExcel(String sheetName) throws Throwable {
	FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int lastRow = sh.getLastRowNum()+1;
	short lastCell = sh.getRow(0).getLastCellNum();
	Object[][] obj = new Object[lastRow][lastCell];
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}

}
