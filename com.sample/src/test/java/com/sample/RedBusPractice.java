package com.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusPractice {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.redbus.in/");
	driver.findElement(By.xpath("//input[@id='src']")).sendKeys("bangalore");
	driver.findElement(By.xpath("//li[.='Majestic, Bangalore']")).click();
	driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("mumbai");
	driver.findElement(By.xpath("//li[.='Thane West, Mumbai']")).click();
	driver.findElement(By.xpath("//label[.='Date']")).click();
	}

}
