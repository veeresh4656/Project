package createAccount;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.ObjectRepository.ApprovePendingReqPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OnlineOpeningFormPage;
import com.ObjectRepository.OpeningFormConfirmationPage;
import com.ObjectRepository.StaffIdPage;
import com.ObjectRepository.StaffProfilePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAccountPom {
public static void main(String []args) throws Throwable {
	//ChromeBrowseer open
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	//maximize window
	WebDriverUtility wu=new WebDriverUtility();
	wu.maximizeWindow(driver);
	//implicit wait
	wu.waitForPageLoad(driver);
	//fetch data from property file
	FileUtility fu=new FileUtility();
	String url = fu.readDataFromProperyFile("url");
	//login to app
	driver.get(url);
	//openAccount page
	HomePage hp=new HomePage(driver);
	hp.openAccount();
	//OpeningAccountFormPage  
	OnlineOpeningFormPage opf=new OnlineOpeningFormPage(driver);
	opf.clickSubmit(driver);
	OpeningFormConfirmationPage ofc=new OpeningFormConfirmationPage(driver);
	String applicationNo = ofc.confirmpage(driver);
	hp.staffLogin();
	String staffId = fu.readDataFromProperyFile("staffId");
	String password=fu.readDataFromProperyFile("password");
	StaffIdPage si=new StaffIdPage(driver);
	si.login(staffId, password);
	StaffProfilePage spp=new StaffProfilePage(driver);
	spp.approvePendingAc();
	ApprovePendingReqPage apr=new ApprovePendingReqPage(driver);
	String AccountNO=apr.approveAct(applicationNo,driver);
	driver.close();
	


}
}
