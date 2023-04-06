package com.ObjectRepository;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;

public class ApplyDebitCardPage {
@FindBy(name="holder_name")
private WebElement holdrNameTxt;
@FindBy(name="dob")
private WebElement dobTxt;
@FindBy(name="pan")
private WebElement panTxt;
@FindBy(name="mob")
private WebElement mobTxt;
@FindBy(name="acc_no")
private WebElement accNoTxt;
@FindBy(name="dbt_crd_submit")
private WebElement submitBtn;
public ApplyDebitCardPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getHoldrNameTxt() {
	return holdrNameTxt;
}
public WebElement getDobTxt() {
	return dobTxt;
}
public WebElement getPanTxt() {
	return panTxt;
}
public WebElement getMobTxt() {
	return mobTxt;
}
public WebElement getAccNoTxt() {
	return accNoTxt;
}
public WebElement getSubmitBtn() {
	return submitBtn;
}
public void clickSubmit(WebDriver driver) throws Throwable {
	ExcelUtilities eu=new ExcelUtilities();
	HashMap<String, String> map = eu.readMultipleData("Sheet2");
for(Entry<String, String> hm:map.entrySet()) {
	driver.findElement(By.name(hm.getKey())).sendKeys(hm.getValue());
}
	
}

}
