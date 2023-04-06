package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class ApprovePendingReqPage {
@FindBy(name="application_no")
private WebElement appNoTxt;
	
@FindBy(name="search_application")
private WebElement searchBtn;
@FindBy(name="approve_cust")
private WebElement approveCustBtn;

public ApprovePendingReqPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getAppNoTxt() {
	return appNoTxt;
}
public WebElement getSearchBtn() {
	return searchBtn;
}
public void appNoTxt() {
	appNoTxt.sendKeys(null);
}
public WebElement getApproveCustBtn() {
	return approveCustBtn;
}
public String approveAct(String applicationNO,WebDriver driver) {
	appNoTxt.click();
	appNoTxt.sendKeys(applicationNO);
	searchBtn.click();
	approveCustBtn.click();
	WebDriverUtility wu=new WebDriverUtility();
	String text = wu.alertPopupText(driver);
	String AccountNumber="";
	for(int i=0;i<text.length();i++) {
		if(Character.isDigit(text.charAt(i)))
			AccountNumber=AccountNumber+text.charAt(i);
			}
	System.out.println("AccountNumber "+AccountNumber);
	return AccountNumber;
	
}
	
}
