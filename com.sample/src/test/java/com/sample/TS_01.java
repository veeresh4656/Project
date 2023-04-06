package com.sample;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_01 extends BaseClass {

	@Test(groups="smoke")
	public void testCase1() {
		int a=10;
		Reporter.log("---TestCase One Executed",true);
		assertEquals("chrome", "chrome");
		Reporter.log("---TestCase ZeroOne Executed",true);
		Reporter.log("---TestCase ZeroTwo Executed",true);
		assertNotNull(a);
		Reporter.log("---TestCase ZeroThree Executed",true);
	}
	
	@Test(groups= {"smoke","regression"})
	public void testCase() {
		Reporter.log("---TestCase Two Executed",true);
		Assert.fail();
	}
	

}
