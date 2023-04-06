package com.sample;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
//@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class TS_02 extends BaseClass {

	
	@Test(groups="smoke")
	public void testCase3() {
		Reporter.log("---TestCase Three Executed",true);
	}
	
	@Test(groups= {"smoke","regression"})
	public void testCase4() {
		Assert.fail();
		Reporter.log("---TestCase Four Executed",true);
	}
}
