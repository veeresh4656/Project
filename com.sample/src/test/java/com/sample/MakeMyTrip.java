package com.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[text()='Round Trip']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("jaipur");
		driver.findElement(By.xpath("//p[text()='Jaipur, India']")).click();
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("chennai");
	    driver.findElement(By.xpath("//span[text()='Departure']")).click();
	    driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	    driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Day' and @aria-label='Tue May 02 2023']")).click();
	    driver.findElement(By.xpath("//div[@aria-label='Tue Jun 13 2023']")).click();
	    driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
	    driver.findElement(By.xpath("//p[@data-cy='adultRange']/following-sibling::ul/li[@data-cy='adults-2']")).click();
	driver.findElement(By.xpath("//button[.='APPLY']")).click();
	driver.findElement(By.xpath("//a[.='Search']")).click();
	}

}
