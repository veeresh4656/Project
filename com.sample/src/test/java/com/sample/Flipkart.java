package com.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().create();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disabled-notifications");
		WebDriver driver =new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 14 pro");
		driver.findElement(By.xpath("//div[text()='in Mobiles']/preceding-sibling::span[text()='iphone 14 pro']")).click();
		String text = driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 Pro Max (Gold, 128 GB)']/../following-sibling::div/descendant::div[@class='_30jeq3 _1_WHN1']")).getText();
		System.out.println(text);

	}

}
