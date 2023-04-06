package internetBanking;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBanking {

	public static void main(String[] args) throws AWTException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disabled-notification");
	WebDriverManager.chromedriver().create();
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	JavascriptExecutor js=(JavascriptExecutor) driver;
	WebElement ib = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
	int y = ib.getLocation().getY();
	js.executeScript("window.scrollTo(0,"+y+")");
	
Actions a=new Actions(driver);
a.moveToElement(ib).perform();
 driver.findElement(By.xpath("//li[text()='Register']")).click();
 driver.findElement(By.xpath("//input[@name='holder_name']")).sendKeys("Veeresh1465");
 driver.findElement(By.xpath("//input[@name='accnum']")).sendKeys("1011691011817");
 driver.findElement(By.xpath("//input[@name='dbtcard']")).sendKeys("421331731552");
 driver.findElement(By.xpath("//input[@name='dbtpin']")).sendKeys("3389");
 driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("8886387788");
 driver.findElement(By.xpath("//input[@name='pan_no']")).sendKeys("PAN345");
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
 driver.findElement(By.xpath("//input[@name='last_trans']")).sendKeys("0");
 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Veeresh1@");
 driver.findElement(By.xpath("//input[@name='cnfrm_password']")).sendKeys("Veeresh1@");
 driver.findElement(By.xpath("//input[@name='submit']")).click();
 String text2 = driver.switchTo().alert().getText();
 String customerId="";
 for(int i=0;i<text2.length();i++) {
	 if(Character.isDigit(text2.charAt(i)));
	 customerId=customerId+text2.charAt(i);
 }
 driver.switchTo().alert().dismiss();
 System.out.println("customerId is 1011817");
 driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys("1011817");
 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Veeresh1@");
 driver.findElement(By.xpath("//input[@name='login-btn']")).click();
 driver.findElement(By.xpath("//li[text()='Change Password']")).click();
 driver.findElement(By.xpath("//input[@name='oldpass']")).sendKeys("Veeresh1@");
 driver.findElement(By.xpath("//input[@name='cnfrm']")).sendKeys("Veeresh1@");
 driver.findElement(By.xpath("//input[@name='newpass']")).sendKeys("Veeresh1@");
 driver.findElement(By.xpath("//input[@name='change_pass']")).click();
 String text3 = driver.switchTo().alert().getText();
 System.out.println(text3);
 driver.switchTo().alert().accept();
	}

}
