package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepository.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public WebDriver driver;
	DatabaseUtilities du=new DatabaseUtilities();
	FileUtility fu=new FileUtility();
	WebDriverUtility wu=new WebDriverUtility();
@BeforeSuite
public void configBS() throws Throwable {
	du.connectToDb();
}

@BeforeClass
public void configBC() throws Throwable {
	String BROWSER = fu.readDataFromProperyFile("browser");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("Invalid Browser");
	}
	wu.maximizeWindow(driver);
	String URL = fu.readDataFromProperyFile("url");
	driver.get(URL);
	wu.waitForPageLoad(driver);
	
	
}

@BeforeMethod
public void configBM() {
	HomePage hm=new HomePage(driver);
	hm.getStaffLginBtn();
}
}
