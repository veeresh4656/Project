package com.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class GetProperyFile {

	public static void main(String[] args) throws Throwable   {
		
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\login.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
	   String password=p.getProperty("password");
	   System.out.println(browser);
	System.out.println(url);
	System.out.println(password);
 WebDriverManager.chromedriver().setup();
 
	
	}

}
