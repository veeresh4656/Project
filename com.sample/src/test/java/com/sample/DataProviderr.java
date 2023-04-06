package com.sample;

import org.testng.annotations.DataProvider;

public class DataProviderr {

	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[2][2];
		obj[0][0]="Qspiders";
		obj[0][1]="jspiders";
		
		obj[1][0]="Pyspiders";
		obj[1][1]="Tyss";
		return obj;
	}
	

	
	
	
	
	
}
