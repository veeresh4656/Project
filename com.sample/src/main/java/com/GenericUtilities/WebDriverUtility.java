package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
/**
 * 
 * @param driver
 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void elementToVisible(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void select(WebElement element,String value) {
	Select sel=new Select(element);
	sel.selectByValue(value);
	
}
public void  select(String visibleText,WebElement element) {
	Select sel=new Select(element);
	sel.selectByVisibleText(visibleText);
}
public void mousehover(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
public void dragAnddrop(WebDriver driver,WebElement src,WebElement dst) {
	Actions act=new Actions(driver);
	act.dragAndDrop(src, dst);
}
public void doubleClickAction(WebDriver driver) {
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
public void rightClick(WebDriver driver) {
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
public void entryKeyPress(WebDriver driver) {
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}
public void entryKey(WebDriver driver) throws Throwable {
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
}
public String alertPopupText(WebDriver driver)
{
Alert alert = driver.switchTo().alert();
String text = alert.getText();
alert.accept();
return text;
	}
}
