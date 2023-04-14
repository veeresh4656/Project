package com.sample;


import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T20RankingsTeams {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	driver.findElement(By.xpath("(//a[.='Team Rankings'])[1]")).click();
 List<WebElement> teamNames = driver.findElements(By.xpath("//tbody/descendant::span[@class='u-hide-phablet']"));
 Scanner sc=new Scanner(System.in);
 System.out.println("enter team Name");
 String expTeam=sc.nextLine();
 boolean flag=false;
for(WebElement tn:teamNames) {
	String team = tn.getText();
//	 String matches = driver.findElement(By.xpath("//tbody/descendant::span[@class='u-hide-phablet']/ancestor::tr[@class='rankings-block__banner']/descendant::td[@class='rankings-block__banner--matches']")).getText();
// String points = driver.findElement(By.xpath("//tbody/descendant::span[@class='u-hide-phablet']/ancestor::tr[@class='rankings-block__banner']/descendant::td[@class='rankings-block__banner--points']")).getText();
// String rating = driver.findElement(By.xpath("//tbody/descendant::span[@class='u-hide-phablet']/ancestor::tr[@class='rankings-block__banner']/descendant::td[@class='rankings-block__banner--rating u-text-right']")).getText();
//if(expTeam.contains(team)) {
//System.out.println(team+"--> matchesPlayed is "+matches+" ---> points is "+points+" ---> ratings is "+rating );
//break;
//}
//else {
//	System.out.println("Not present in the team");
//	break;
//}
//}
if(expTeam.equalsIgnoreCase(team)) {
	flag=true;
	}

}
if(flag) {
	System.out.println(expTeam+" is present in the table");
}
else
	System.out.println(expTeam +"is not present in the table");
	
}
}
	


