package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {

	@FindBy(name="customer_id")
	private WebElement customerIDTxt;
	
	@FindBy(name="password")
	private WebElement passwordTxt;
	
	@FindBy(name="login-btn")
	private WebElement loginBtn;
	
	public CustomerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerIDTxt() {
		return customerIDTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void clickSubmit() {
		
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

