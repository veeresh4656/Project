package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;

public class DebitCardFormPage {
@FindBy(name="holder_name")
private WebElement holderNameTxt;

@FindBy(name="dob")
private WebElement dateTxt;
@FindBy(name="pan")
private WebElement panTxt;
@FindBy(name="mob")
private WebElement mobileNoTxt;
@FindBy(name="acc_no")
private WebElement accountNoTxt;
@FindBy(name="dbt_crd_submit")
private WebElement submitBtn;

public DebitCardFormPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getHolderNameTxt() {
	return holderNameTxt;
}

public WebElement getDateTxt() {
	return dateTxt;
}

public WebElement getPanTxt() {
	return panTxt;
}

public WebElement getMobileNoTxt() {
	return mobileNoTxt;
}

public WebElement getAccountNoTxt() {
	return accountNoTxt;
}

public WebElement getSubmitBtn() {
	return submitBtn;
}

public void setClickSubmit(WebDriver driver) throws Throwable {
	ExcelUtilities eu=new ExcelUtilities();
HashMap<String, String> map = eu.readMultipleData("Sheet2");
for(Entry<String, String> hm:map.entrySet()) {
driver.findElement(By.name(hm.getKey())).sendKeys(hm.getValue());

}
dateTxt.click();
dateTxt.sendKeys("10-06-2023");
submitBtn.click();
//=driver.switchTo().alert().getText();

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
