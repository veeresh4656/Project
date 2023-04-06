package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgTestingServer {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver:8084/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.linkText("Projects")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	Random ran=new Random();
	int res = ran.nextInt(1000);
	String exProj="MissonImpossible"+res;
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(exProj);
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("TomCruise");
	WebElement dd = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
	Select s=new Select(dd);
	s.selectByVisibleText("On Gogin");
	driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	
	Driver driver1=new Driver();
	DriverManager.registerDriver(driver1);
	con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	Statement state = con.createStatement();
	String query = "select * from project;";
	 ResultSet result = state.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String actProj = result.getString(4);
	
	System.out.println(actProj);
	if(actProj.contains(exProj)) {
		flag=true;
		break;
	}
	}
	if(flag) {
		System.out.println("Project is Created");
	}
	else {
		System.out.println("Project is not updated");
	}
	driver.close();
	}
		catch(Exception e) {
			
		}
		finally {
			con.close();
		}
	
	}
	
}
