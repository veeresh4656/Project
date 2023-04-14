package com.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disselected {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/USER/Desktop/Menu.html");
	WebElement cp = driver.findElement(By.id("cp"));
	Select s=new Select(cp);
	List<WebElement> options = s.getOptions();
for(WebElement wb:options) {
	if(wb.isSelected()==false) {
		System.out.println(wb.getText());
	}
}
	}

}
