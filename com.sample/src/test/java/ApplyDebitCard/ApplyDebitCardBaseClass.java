package ApplyDebitCard;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepository.DebitCardFormPage;
import com.ObjectRepository.HomePage;

public class ApplyDebitCardBaseClass extends BaseClass {

	@Test(priority = 1)
	public void applyDebitCard() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.applyDebitCard();
		DebitCardFormPage dcf=new  DebitCardFormPage(driver);
		dcf.setClickSubmit(driver);
		driver.switchTo().alert().getText();
		String text = wu.alertPopupText(driver);
		System.out.println(text);
		String popupNumber="";
		for(int i=0;i<text.length();i++) {
			if(Character.isDigit(text.charAt(i)))
				popupNumber=popupNumber+text.charAt(i);
		}
	String debitno="",pin="";
		for(int i=0;i<popupNumber.length();i++)
		{
			if(i<12) {
				debitno=debitno+popupNumber.charAt(i);
			}
			else {
				pin=pin+popupNumber.charAt(i);
			}
			}
		System.out.println("DebitCardNumber "+debitno);
	    System.out.println("PinNumber is "+pin);
		
		
	}
	
}
