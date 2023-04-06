package ApplyDebitCard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyDebit {

	public static void main(String[] args) throws Throwable {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disabled-notification");
	WebDriverManager.chromedriver().create();
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[text()='Open Account']")).click();
	 WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
	 Random ran = new Random();
	int rn = ran.nextInt(1000);
	String nme="Veeresh1"+rn;
	 name.sendKeys(nme);
	 System.out.println(nme);
	 WebElement genderdd = driver.findElement(By.xpath("//select[@name='gender']"));
	 Select s=new Select(genderdd);
	 s.selectByVisibleText("Male");
	 WebElement mobNum = driver.findElement(By.xpath("//input[@name='mobile']"));
	 mobNum.sendKeys("8886387788");
	WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
	email.sendKeys("veeresh123@gmail.com");
	WebElement landline = driver.findElement(By.xpath("//input[@name='landline']"));
	landline.sendKeys("8121448856");
	WebElement dob = driver.findElement(By.xpath("//input[@name='dob']"));
	dob.click();
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_1);
	r.keyPress(KeyEvent.VK_0);
	r.keyPress(KeyEvent.VK_0);
	r.keyPress(KeyEvent.VK_6);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_0);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_3);
	WebElement panNo = driver.findElement(By.xpath("//input[@name='pan_no']"));
	panNo.sendKeys("PAN345");
	WebElement citizenship = driver.findElement(By.xpath("//input[@name='citizenship']"));
	citizenship.sendKeys("CTZN123");
	WebElement homeAdd = driver.findElement(By.xpath("//input[@name='homeaddrs']"));
	homeAdd.sendKeys("Hno:1/23,Gudikal,Yemmiganur,kurnool,Ap");
	WebElement offAdd = driver.findElement(By.xpath("//input[@name='officeaddrs']"));
	offAdd.sendKeys("Hno:1/23,Gudikal,Yemmiganur,kurnool,Ap");
	WebElement statedd = driver.findElement(By.xpath("//select[@name='state']"));
	Select s1=new Select(statedd);
	s1.selectByVisibleText("California");
	WebElement citydd = driver.findElement(By.xpath("//select[@name='city']"));
	Select s2=new Select(citydd);
	s2.selectByVisibleText("Los Angeles");
	WebElement pin = driver.findElement(By.xpath("//input[@name='pin']"));
	pin.sendKeys("518360");
	WebElement area = driver.findElement(By.xpath("//input[@name='arealoc']"));
	area.sendKeys("Texas");
	WebElement nomineeName = driver.findElement(By.xpath("//input[@name='nominee_name']"));
	nomineeName.sendKeys("Linga");
	WebElement nomineeAcno = driver.findElement(By.xpath("//input[@name='nominee_ac_no']"));
	nomineeAcno.sendKeys("9876543210");
	WebElement acTypedd = driver.findElement(By.xpath("//select[@name='acctype']"));
	Select s3=new Select(acTypedd);
	s3.selectByVisibleText("Saving");
	WebElement submitbtn = driver.findElement(By.xpath("//input[@name='submit']"));
	submitbtn.click();
	WebElement confirmbtn = driver.findElement(By.xpath("//input[@name='cnfrm-submit']"));
	confirmbtn.click();
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
		WebElement staffLogin = driver.findElement(By.linkText("Staff Login"));
		staffLogin.click();
		WebElement staffId = driver.findElement(By.xpath("//input[@name='staff_id']"));
		staffId.sendKeys("210001");
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("password");
		WebElement submit = driver.findElement(By.xpath("//input[@name='staff_login-btn']"));
		submit.click();
		WebElement pendingApprove = driver.findElement(By.xpath("//input[@name='apprvac']"));
		pendingApprove.click();
		WebElement Application = driver.findElement(By.xpath("//input[@name='application_no']"));
		Application.sendKeys(AccountNumber);
		WebElement search = driver.findElement(By.xpath("//input[@name='search_application']"));
		search.click();
		WebElement approve = driver.findElement(By.xpath("//input[@name='approve_cust']"));
		approve.click();
		String AccountDetails = driver.switchTo().alert().getText();
		System.out.println(AccountDetails);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Home")).click();
	driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
	driver.findElement(By.xpath("//input[@name='holder_name']")).sendKeys(nme);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='dob']")).click();
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_1);
	rb.keyPress(KeyEvent.VK_0);
	rb.keyPress(KeyEvent.VK_0);
	rb.keyPress(KeyEvent.VK_6);
	rb.keyPress(KeyEvent.VK_2);
	rb.keyPress(KeyEvent.VK_0);
	rb.keyPress(KeyEvent.VK_2);
	rb.keyPress(KeyEvent.VK_3);
	driver.findElement(By.xpath("//input[@name='pan']")).sendKeys("PAN345");
	driver.findElement(By.xpath("//input[@name='mob']")).sendKeys("8886387788");
	driver.findElement(By.xpath("//input[@name='acc_no']")).sendKeys("1011481011680");
	driver.findElement(By.xpath("//input[@name='dbt_crd_submit']")).click();
	String Text = driver.switchTo().alert().getText();
	System.out.println(Text);
	String debitNo="",Pin="";
	for(int i=0;i<Text.length();i++) {
		double x=0;
		if(Character.isDigit(Text.charAt(i))) {
			x++;
			if(x<16) {
				debitNo=debitNo+Text.charAt(i);
			}
			else
			Pin=Pin+Text.charAt(i);
			
		}
			
	System.out.println(debitNo);
	System.out.println(Pin);
//	driver.switchTo().alert().dismiss();
	
//driver.quit();
	}

	}
}

