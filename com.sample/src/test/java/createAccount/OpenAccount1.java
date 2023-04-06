package createAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAccount1 {

	public static void main(String[] args) throws Throwable {
	DatabaseUtilities dbu = new DatabaseUtilities();
	ExcelUtilities exu = new ExcelUtilities();
	FileUtility fu = new FileUtility();
	JavaUtility ju = new JavaUtility();
	WebDriverUtility wu = new WebDriverUtility();
	
	String url = fu.readDataFromProperyFile("url");
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	wu.maximizeWindow(driver);
    driver.get(url);
	
	
	
	

	}

}
