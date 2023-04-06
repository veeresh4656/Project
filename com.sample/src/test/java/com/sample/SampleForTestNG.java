package com.sample;

import org.apache.hc.core5.reactor.Command.Priority;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtilities;

public class SampleForTestNG {
//@Test(priority = 1,invocationCount = 0)
//public void createSample() {
//	Reporter.log("Creating an Account",true);	
//}
//
//@Test(priority = -3,dependsOnMethods ="createSample",invocationCount = 0 )
//public void editSample() {
//	
//	Reporter.log("editing an Account",true);	
//}
//
//@Test(priority = 8,invocationCount = 0)
//public void deleteSample() {
//	Reporter.log("deleting an account",true);
//}
//@Test(dataProviderClass=DataProviderUsingExcel.class, dataProvider ="data" )
//public void testData(String src,String dest) {
//	System.out.println(src+"---->"+dest);
//}

//@DataProvider
//public Object[][] data() {
//	Object[][] obj = new Object[2][2];
//	obj[0][0]="Qspiders";
//	obj[0][1]="jspiders";
//	
//	obj[1][0]="Pyspiders";
//	obj[1][1]="Tyss";
//	return obj;
//}
	@Test(dataProvider="readSetofData")
	public void getData(String src,String dest) {
		System.out.println(src +"---->"+dest);
	}
	
	
	
	@DataProvider
	public Object[][] readSetofData() throws Throwable{
		ExcelUtilities eu=new ExcelUtilities();
		Object[][] value = eu.readMultipleDataFromExcel("Sheet3");
		return value;
	}
	
	
	
}
