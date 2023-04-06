package com.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeamRankings {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
 List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
 List<WebElement> rankings = driver.findElements(By.xpath("//tbody/tr/td[3]"));
	for(int i=0;i<teams.size();i++)
	{
	String team=teams.get(i).getText();
	String ranking=rankings.get(i).getText();
	System.out.println(team+" "+ranking);
		}
	}

}
