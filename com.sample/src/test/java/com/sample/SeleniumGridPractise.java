package com.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGridPractise {
@Test
public void test() throws MalformedURLException, InterruptedException {
	String executeMode="remote";
	WebDriver driver=null;
	if(executeMode.equals("remote")) {
		URL url=new URL("http://192.168.144.1:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		driver=new RemoteWebDriver(url,cap);
		}
	else if(executeMode.equals("local")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.get("https://google.com");
	Thread.sleep(5000);
	driver.quit();
	
}
}
