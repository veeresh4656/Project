package com.sample;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_04 extends BaseClass {

	@Test(groups="smoke")
	public void testCase7() {
		Reporter.log("---TestCase Seven Executed",true);
	}
	
	@Test(groups= {"smoke","regression"})
	public void testCase8() {
		Reporter.log("---TestCase Eight Executed",true);
	}
	
	
}
