package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public DatabaseUtilities dbu=new DatabaseUtilities();
public ExcelUtilities eu=new ExcelUtilities();
public FileUtility fu=new FileUtility();
public WebDriverUtility wu=new WebDriverUtility();
public WebDriver driver;
public static WebDriver Sdriver;

@BeforeSuite(alwaysRun=true)
public void connectToDB() throws Throwable {
	dbu.connectToDb();
	Reporter.log("DataBase is connected",true);
}
//@Parameters("BROWSER")
@BeforeClass(alwaysRun=true)
public void configBC() throws Throwable {
	String BROWSER = fu.readDataFromProperyFile("browser");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Reporter.log("Chrome Browser launched successfully",true);
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		Reporter.log("Firefox Browser launched successfully",true);
	}
	else {
		Reporter.log("Invalid BROWSER name",true);
	}
	Sdriver=driver;
	String url = fu.readDataFromProperyFile("url");
	wu.maximizeWindow(driver);
	driver.get(url);
	wu.waitForPageLoad(driver);
	Reporter.log("Login to the application",true);
		
}
@BeforeMethod(alwaysRun=true)
public void configBM() {
Reporter.log("Login successful",true);
}

@AfterMethod(alwaysRun=true)
public void configAM() {

	Reporter.log("Logout successful",true);
}
@AfterClass(alwaysRun=true)
public void configAC() {
	driver.quit();
	Reporter.log("Browser closed ",true);
}
@AfterSuite(alwaysRun=true)
public void configAS() throws Throwable {
	dbu.closeDB();
	Reporter.log("DataBase connection is closed ",true);
}
}
