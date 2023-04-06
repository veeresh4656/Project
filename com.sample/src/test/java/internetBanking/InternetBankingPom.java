package internetBanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.InternetBankingRegistrationForm;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingPom {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wu = new WebDriverUtility();
		FileUtility fu=new FileUtility();
			
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wu.maximizeWindow(driver);
		String url = fu.readDataFromProperyFile("url");
		driver.get(url);
		HomePage hm=new HomePage(driver);
		WebElement internetBankingBtn = hm.getInternerBankingBtn();
 hm.internetBanking(driver, internetBankingBtn);
 hm.ibRegister();
 InternetBankingRegistrationForm ibr=new InternetBankingRegistrationForm(driver);
 ibr.clickSubmit(driver);


	}


	}


