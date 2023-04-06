
package createAccount;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Multiset.Entry;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAccount {

	public static void main(String[] args) throws Throwable {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disabled-notification");
	WebDriverManager.chromedriver().create();
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	FileInputStream fis=new FileInputStream("./src/test/resources/commondata.property");
	Properties p=new Properties();
	p.load(fis);
	String url=p.getProperty("url");
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[text()='Open Account']")).click();
	FileInputStream fi=new FileInputStream("./src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet("demo");
	 HashMap<String,String> hs=new HashMap<String, String>();
	 for(int i=0;i<sh.getLastRowNum();i++)
	 {
		 String key=sh.getRow(i).getCell(0).getStringCellValue();
		 String value=sh.getRow(i).getCell(1).getStringCellValue();
		 hs.put(key, value);
		 
	 }
	for(java.util.Map.Entry<String, String> set:hs.entrySet())
	 {
		 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	 }
	
//driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Veeresh1");
 WebElement genderdd = driver.findElement(By.xpath("//select[@name='gender']"));
 Select s=new Select(genderdd);
 s.selectByVisibleText("Male");
//driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("8886387788");
//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("veeresh123@gmail.com");
// driver.findElement(By.xpath("//input[@name='landline']")).sendKeys("8121448856");
driver.findElement(By.xpath("//input[@name='dob']")).click();
Robot r=new Robot();
r.keyPress(KeyEvent.VK_1);
r.keyPress(KeyEvent.VK_0);
r.keyPress(KeyEvent.VK_0);
r.keyPress(KeyEvent.VK_6);
r.keyPress(KeyEvent.VK_2);
r.keyPress(KeyEvent.VK_0);
r.keyPress(KeyEvent.VK_2);
r.keyPress(KeyEvent.VK_3);
//driver.findElement(By.xpath("//input[@name='pan_no']")).sendKeys("PAN345");
//driver.findElement(By.xpath("//input[@name='citizenship']")).sendKeys("CTZN123");
//
//driver.findElement(By.xpath("//input[@name='homeaddrs']")).sendKeys("Hno:1/23,Gudikal,Yemmiganur,kurnool,Ap");
//
//driver.findElement(By.xpath("//input[@name='officeaddrs']")).sendKeys("Hno:1/23,Gudikal,Yemmiganur,kurnool,Ap");

WebElement statedd = driver.findElement(By.xpath("//select[@name='state']"));
Select s1=new Select(statedd);
s1.selectByVisibleText("California");
WebElement citydd = driver.findElement(By.xpath("//select[@name='city']"));
Select s2=new Select(citydd);
s2.selectByVisibleText("Los Angeles");
driver.findElement(By.xpath("//input[@name='pin']")).sendKeys("518360");

//driver.findElement(By.xpath("//input[@name='arealoc']")).sendKeys("Texas");
//driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys("Linga");
//driver.findElement(By.xpath("//input[@name='nominee_ac_no']")).sendKeys("9876543210");
WebElement acTypedd = driver.findElement(By.xpath("//select[@name='acctype']"));
Select s3=new Select(acTypedd);
s3.selectByVisibleText("Saving");
driver.findElement(By.xpath("//input[@name='submit']")).click();
 driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();
Alert alertpopup = driver.switchTo().alert();
String text=alertpopup.getText();
System.out.println(text);
	String AccountNumber="";
	for(int i=0;i<text.length();i++) {
		if(Character.isDigit(text.charAt(i)))
			AccountNumber=AccountNumber+text.charAt(i);
			}
	System.out.println(AccountNumber);
	alertpopup.accept();
 driver.findElement(By.linkText("Staff Login")).click();
driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys("210001");
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
 driver.findElement(By.xpath("//input[@name='apprvac']")).click();
 driver.findElement(By.xpath("//input[@name='application_no']")).sendKeys(AccountNumber);
driver.findElement(By.xpath("//input[@name='search_application']")).click();
driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
	String AccountDetails = driver.switchTo().alert().getText();
	System.out.println(AccountDetails);
	driver.switchTo().alert().accept();
driver.quit();
	}
}
