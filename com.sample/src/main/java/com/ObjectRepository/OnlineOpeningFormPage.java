package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class OnlineOpeningFormPage {
@FindBy(name="name")
private WebElement nameTxt;

@FindBy(name="gender")
private WebElement genderDD;

@FindBy(name="mobile")
private WebElement mobTxt;

@FindBy(name="email")
private WebElement emailTxt;

@FindBy(name="landline")
private WebElement landlineTxt;

@FindBy(name="dob")
private WebElement dobTxt;

@FindBy(name="pan_no")
private WebElement panTxt;

@FindBy(name="citizenship")
private WebElement citizenTxt;

@FindBy(name="homeaddrs")
private WebElement homeAddTxt;

@FindBy(name="officeaddrs")
private WebElement offAddTxt;

@FindBy(name="state")
private WebElement stateDD;

@FindBy(name="city")
private WebElement cityDD;

@FindBy(name="pin")
private WebElement pinTxt;

@FindBy(name="arealoc")
private WebElement areaTxt;

@FindBy(name="nominee_name")
private WebElement nomineenameTxt;

@FindBy(name="nominee_ac_no")
private WebElement nomineeAcnoTxt;

@FindBy(name="acctype")
private WebElement accTypeDD;
@FindBy(name="submit")
private WebElement submitBtn;

public OnlineOpeningFormPage(WebDriver driver) {
PageFactory.initElements(driver, this);	
}


public void clickSubmit(WebDriver driver) throws Throwable {
	ExcelUtilities eu=new ExcelUtilities();
	JavaUtility ju=new JavaUtility();
	WebDriverUtility wu=new WebDriverUtility();
	
	HashMap<String, String> map = eu.readMultipleData("demo");
	for( Entry<String, String> hm:map.entrySet())
	{
		if(hm.getKey().equalsIgnoreCase("name")) {
			
		driver.findElement(By.name(hm.getKey())).sendKeys(hm.getValue()+ju.random());
		}
		else
		{
			driver.findElement(By.name(hm.getKey())).sendKeys(hm.getValue());

		}
		
	}
	
	 WebElement ge = genderDD;
	wu.select("Male", ge);
	WebElement date = dobTxt;
	date.click();
	date.sendKeys("10-06-2023");
	WebElement state = stateDD;
	wu.select("Texas", state);
	WebElement cd = cityDD;
	wu.select("Fresno", cd);
	WebElement ad = accTypeDD;
	wu.select("Saving", ad);
	submitBtn.click();
	
	
}
	
	
	
	
	
	
}
