package FundTransfer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FundTransfer {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disabled-notification");
	WebDriverManager.chromedriver().create();
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
	 driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys("1011817");
	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Veeresh1@");
	 driver.findElement(By.xpath("//input[@name='login-btn']")).click();
	 driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
	 driver.findElement(By.xpath("//input[@name='add_beneficiary']")).click();
	 driver.findElement(By.xpath("//input[@name='beneficiary_name']")).sendKeys("Rajhans");
	 driver.findElement(By.xpath("//input[@name='beneficiary_acno']")).sendKeys("1011161011862");
	 driver.findElement(By.xpath("//input[@name='Ifsc_code']")).sendKeys("1011");
	WebElement dd = driver.findElement(By.xpath("//select[@name='beneficiary_acc_type']"));
	 Select s=new Select(dd);
	 s.selectByVisibleText("Saving");
	 driver.findElement(By.xpath("//input[@name='add_beneficiary_btn']")).click();
	 
	}

}
