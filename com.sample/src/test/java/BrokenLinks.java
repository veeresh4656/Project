

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
@Test
public void test() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://phptravels.com/");
 List<WebElement> listOfAllLinks = driver.findElements(By.xpath("//a"));
	List<String> listOfLinks=new ArrayList<String>();
	List<String> brokenLinks=new ArrayList<String>();	
	for(  WebElement webElement:listOfAllLinks) {
		String link=webElement.getAttribute("href");
		if(link!=null) {
			if(link.contains("http")) {
				listOfLinks.add(link);
			}
			else {
				brokenLinks.add(link+"--> Not having HTTP protocol");
			}
		}
		else {
			brokenLinks.add(link+"--> Null");
		}
		}
	for(String link:listOfLinks) {
		try {
			URL url = new URL(link);
			URLConnection urlCOn = url.openConnection();
			HttpURLConnection httpUrlCOn = (HttpURLConnection)urlCOn;
			int statusCode = httpUrlCOn.getResponseCode();
			String responceMsg = httpUrlCOn.getResponseMessage();
			if(statusCode>=400) {
				brokenLinks.add(link+"status code is"+statusCode +" responce message is"+responceMsg);
			}
		}
		catch(Exception e) {
			brokenLinks.add(link+"Not connected to server");
		}
	}
}
}
