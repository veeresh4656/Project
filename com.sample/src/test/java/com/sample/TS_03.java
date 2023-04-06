package com.sample;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_03 extends BaseClass{

	@Test(retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public void testCase5() {
		Reporter.log("---TestCase Five Executed",true);
		Assert.fail();
	}
	
	@Test(groups= {"smoke","regression"})
	public void testCase6() {
		Reporter.log("---TestCase Six Executed",true);
	}
	
	
}
