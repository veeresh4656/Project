package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffProfilePage {
@FindBy(name="viewdet")
private WebElement viewActiveCustomer;
@FindBy(name="view_cust_by_ac")
private WebElement viewCustomerByAcNo;
@FindBy(name="apprvac")
private WebElement approvePendingAc;
@FindBy(name="del_cust")
private WebElement deleteCustomerByAc;
@FindBy(name="credit_cust_ac")
private WebElement creditCustoemer;

public StaffProfilePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getViewActiveCustomer() {
	return viewActiveCustomer;
}

public WebElement getViewCustomerByAcNo() {
	return viewCustomerByAcNo;
}

public WebElement getApprovePendingAc() {
	return approvePendingAc;
}

public WebElement getDeleteCustomerByAc() {
	return deleteCustomerByAc;
}

public WebElement getCreditCustoemer() {
	return creditCustoemer;
}

public void approvePendingAc() {
	approvePendingAc.click();
	
}

}
