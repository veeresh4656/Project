package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class HomePage {
//declaration
	@FindBy(xpath="//li[text()='Open Account']")
	private WebElement openActBtn;
	@FindBy(xpath="//li[text()='Apply Debit Card']")
	private WebElement applyDbtCardBtn;
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement fundTransferBtn;
	@FindBy(xpath="//a[contains(text(),'Internet Banking')]")
	private WebElement internerBankingBtn;
	@FindBy(xpath="//li[.='Login '] ")
	private WebElement ibLoginBtn;
	@FindBy(xpath="//li[.='Register'] ")
	private WebElement ibRegisterBtn;
	
    @FindBy(linkText="Staff Login")
	private WebElement staffLginBtn;


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpenActBtn() {
		return openActBtn;
	}

	public WebElement getApplyDbtCardBtn() {
		return applyDbtCardBtn;
	}

	public WebElement getFundTransferBtn() {
		return fundTransferBtn;
	}

	public WebElement getInternerBankingBtn() {
		return internerBankingBtn;
	}
	public WebElement getIbLoginBtn() {
		return ibLoginBtn;
	}

	public WebElement getIbRegisterBtn() {
		return ibRegisterBtn;
	}

	public WebElement getStaffLginBtn() {
		return staffLginBtn;
	}
	public void openAccount() {
		openActBtn.click();
	}
	public void applyDebitCard() {
		applyDbtCardBtn.click();
	}
	public void staffLogin() {
		staffLginBtn.click();
	}
	public void internetBanking(WebDriver driver,WebElement internerBankingBtn ) {
		WebDriverUtility wu=new WebDriverUtility();
		wu.mousehover(driver , internerBankingBtn);
	}
	public void ibRegister() {
		ibRegisterBtn.click();
	}
	

}
