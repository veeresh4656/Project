package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.WebDriverUtility;

public class InternetBankingRegistrationForm {
@FindBy(name="holder_name")
private WebElement holderNameTxt;

@FindBy(name="accnum")
private WebElement accNumTxt;

@FindBy(name="dbtcard")
private WebElement dbtcardTxt;

@FindBy(name="dbtpin")
private WebElement dbtpinTxt;

@FindBy(name="mobile")
private WebElement mobileTxt;

@FindBy(name="pan_no")
private WebElement pan_noTxt;

@FindBy(name="dob")
private WebElement dobTxt;


@FindBy(name="last_trans")
private WebElement last_transTxt;

@FindBy(name="password")
private WebElement passwordTxt;

@FindBy(name="cnfrm_password")
private WebElement cnfrm_passwordTxt;

@FindBy(name="Register")
private WebElement RegisterBtn;

@FindBy(name="change_pass")
private WebElement change_passBtn;

@FindBy(name="submit")
private WebElement submitBtn;

public InternetBankingRegistrationForm(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getSubmitBtn() {
	return submitBtn;
}


public WebElement getHolderNameTxt() {
	return holderNameTxt;
}

public WebElement getDobTxt() {
	return dobTxt;
}

public WebElement getAccNumTxt() {
	return accNumTxt;
}


public WebElement getDbtcardTxt() {
	return dbtcardTxt;
}


public WebElement getDbtpinTxt() {
	return dbtpinTxt;
}


public WebElement getMobileTxt() {
	return mobileTxt;
}


public WebElement getPan_noTxt() {
	return pan_noTxt;
}


public WebElement getLast_transTxt() {
	return last_transTxt;
}


public WebElement getPasswordTxt() {
	return passwordTxt;
}


public WebElement getCnfrm_passwordTxt() {
	return cnfrm_passwordTxt;
}


public WebElement getRegisterBtn() {
	return RegisterBtn;
}


public WebElement getChange_passBtn() {
	return change_passBtn;
}

public void clickSubmit(WebDriver driver) throws Throwable {
	ExcelUtilities eu=new ExcelUtilities();
	HashMap<String, String> map = eu.readMultipleData("Sheet1");
	for(Entry<String, String> hm:map.entrySet()) {
		driver.findElement(By.name(hm.getKey())).sendKeys(hm.getValue());
	}

	dobTxt.click();
	dobTxt.sendKeys("10-06-2023");
	submitBtn.click();
	
	WebDriverUtility wu=new WebDriverUtility();
	String text = wu.alertPopupText(driver);
	System.out.println(text);
	String customerId="";
	for(int i=0;i<text.length();i++) {
		if(Character.isDigit(text.charAt(i)))
			customerId=customerId+text.charAt(i);
			}
	System.out.println("customerId is "+customerId);
}
}
