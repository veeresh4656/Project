package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
//execution starts from here
		String MethodName=result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"--->TestScript execution started");
	}

	public void onTestSuccess(ITestResult result) {
	String MethodName=result.getMethod().getMethodName();
	test.log(Status.PASS, MethodName+"----->Passed");
	Reporter.log(MethodName+"---->TestScript execution successfull");
	}

	public void onTestFailure(ITestResult result) {
EventFiringWebDriver edriver =new EventFiringWebDriver(BaseClass.Sdriver);
File src = edriver.getScreenshotAs(OutputType.FILE);
File dest = new File("./Screenshot/FailedScript.png");
try {
	FileUtils.copyFile(src, dest);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	
	}

	public void onTestSkipped(ITestResult result) {
	String MethodName=result.getMethod().getMethodName();
	test.log(Status.SKIP, MethodName+"--->Skipped");
	test.log(Status.SKIP, result.getThrowable());
	Reporter.log("Restscript execution Skipped");
	}

	public void onStart(ITestContext context) {
	//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Salaar Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("OnlineBankingSystem");
		
	report = new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("BaseBrowser", "chrome");
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("Base_URL", "https://localhost:8888");
	report.setSystemInfo("Reporter Name", "Veeresh");
	}

	public void onFinish(ITestContext context) {
	report.flush();
	}

}
