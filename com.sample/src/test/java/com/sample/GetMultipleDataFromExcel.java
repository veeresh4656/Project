package com.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet2");
	int count=sh.getLastRowNum();
	HashMap<String,String> hm=new HashMap<String,String>();
	for(int i=0;i<count;i++) {
		String key = sh.getRow(i).getCell(0).getStringCellValue();
		String value = sh.getRow(i).getCell(1).getStringCellValue();
		hm.put(key, value);
	}
	for(Entry<String, String> h:hm.entrySet())
	{
		System.out.println(h.getKey()+" "+h.getValue());
	}

	}

}
