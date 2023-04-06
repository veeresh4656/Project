package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffIdPage {
@FindBy(name="staff_id")
private WebElement staffIdTxt;
@FindBy(name="password")
private WebElement passwordTxt;
@FindBy(name="staff_login-btn")
private WebElement loginBtn;

public StaffIdPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}

public WebElement getStaffIdTxt() {
	return staffIdTxt;
}

public WebElement getPasswordTxt() {
	return passwordTxt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}
public void login(String un,String pw) {
	staffIdTxt.sendKeys(un);
	passwordTxt.sendKeys(pw);
	loginBtn.click();
	
}
}
