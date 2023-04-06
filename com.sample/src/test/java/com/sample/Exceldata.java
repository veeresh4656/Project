package com.sample;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;

import com.GenericUtilities.ExcelUtilities;

public class Exceldata {

	public static void main(String[] args) throws Throwable {
		ExcelUtilities eu=new ExcelUtilities();
		String sheet="demo";
		HashMap<String, String> map = eu.readMultipleData(sheet);
		for(java.util.Map.Entry<String, String> set:map.entrySet())
		 {
			System.out.println(set.getKey()+"  "+set.getValue());
		 }
		
	}

}
