package com.sample;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsRankings {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Scanner sc=new Scanner(System.in);
		String team=sc.nextLine();
List<WebElement> colNames = driver.findElements(By.xpath("//th"));
 List<WebElement> values = driver.findElements(By.xpath("//span[.='"+team+"']/../following-sibling::td"));
	for(int i=0,j=2;i<values.size();i++,j++) {
		System.out.println(colNames.get(j).getText()+" "+values.get(i).getText());
	}
	
	}

}
