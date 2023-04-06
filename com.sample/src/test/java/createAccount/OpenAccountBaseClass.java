package createAccount;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepository.ApprovePendingReqPage;
import com.ObjectRepository.DebitCardFormPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OnlineOpeningFormPage;
import com.ObjectRepository.OpeningFormConfirmationPage;
import com.ObjectRepository.StaffIdPage;
import com.ObjectRepository.StaffProfilePage;

public class OpenAccountBaseClass extends BaseClass {
@Test
public void createAccount() throws Throwable {
	HomePage hp=new HomePage(driver);
	hp.openAccount();
	OnlineOpeningFormPage opf=new OnlineOpeningFormPage(driver);
	opf.clickSubmit(driver);
	OpeningFormConfirmationPage ofc=new OpeningFormConfirmationPage(driver);
	String applicationNo = ofc.confirmpage(driver);
	hp.staffLogin();
	String staffId = fu.readDataFromProperyFile("staffId");
	String password=fu.readDataFromProperyFile("password");
	StaffIdPage si=new StaffIdPage(driver);
	si.login(staffId, password);
	StaffProfilePage spp=new StaffProfilePage(driver);
	spp.approvePendingAc();
	ApprovePendingReqPage apr=new ApprovePendingReqPage(driver);
	String AccountNO=apr.approveAct(applicationNo,driver);
}

}
