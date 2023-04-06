package ApplyDebitCard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.ObjectRepository.ApplyDebitCardPage;
import com.ObjectRepository.DebitCardFormPage;
import com.ObjectRepository.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyDebitCardPom {

	public static void main(String[] args) throws Throwable {
		//Opening browser
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	//object creation
	DatabaseUtilities dbu = new DatabaseUtilities();
	ExcelUtilities exu = new ExcelUtilities();
	FileUtility fu = new FileUtility();
	JavaUtility ju = new JavaUtility();
	WebDriverUtility wu = new WebDriverUtility();
	//maximize window
wu.maximizeWindow(driver);	
wu.waitForPageLoad(driver);
	//login to app
	String url = fu.readDataFromProperyFile("url");
	driver.get(url);
	HomePage hp=new HomePage(driver);
	hp.applyDebitCard();
	DebitCardFormPage dcf=new  DebitCardFormPage(driver);
	dcf.setClickSubmit(driver);
	driver.switchTo().alert().getText();
	String text = wu.alertPopupText(driver);
	System.out.println(text);
	String popupNumber="";
	for(int i=0;i<text.length();i++) {
		if(Character.isDigit(text.charAt(i)))
			popupNumber=popupNumber+text.charAt(i);
	}
String debitno="",pin="";
	for(int i=0;i<popupNumber.length();i++)
	{
		if(i<12) {
			debitno=debitno+popupNumber.charAt(i);
		}
		else {
			pin=pin+popupNumber.charAt(i);
		}
		}
	System.out.println("DebitCardNumber "+debitno);
    System.out.println("PinNumber is "+pin);
    driver.close();
	}
	}


