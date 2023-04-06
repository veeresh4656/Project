package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class OpeningFormConfirmationPage {
@FindBy(name="cnfrm-submit")
private WebElement cnfmBtn;
@FindBy(xpath="//input[@value='Go back']")
private WebElement goBackBtn;

public OpeningFormConfirmationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public String confirmpage(WebDriver driver) {
	cnfmBtn.click();
	WebDriverUtility wu=new WebDriverUtility();
	String text = wu.alertPopupText(driver);
	System.out.println(text);
	String AccountNumber="";
	for(int i=0;i<text.length();i++) {
		if(Character.isDigit(text.charAt(i)))
			AccountNumber=AccountNumber+text.charAt(i);
			}
	System.out.println("Application Number is "+AccountNumber);
	return AccountNumber;
	
}

}
