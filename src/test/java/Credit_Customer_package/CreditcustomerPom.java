package Credit_Customer_package;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.WebdriverUtilities;
import com.ObjectRepo_package.CreditDetailPage;
import com.ObjectRepo_package.HomePage;
import com.ObjectRepo_package.StaffActivityPage;
import com.ObjectRepo_package.StaffLoginPage;
@Listeners(com.GenericUtilities.ListenerImplementation.class)

public class CreditcustomerPom extends BaseClass{
	@Test(priority =1, groups="system",retryAnalyzer = com.GenericUtilities.RetryImplementation.class)
	public  void creditCustomer() throws Throwable {
		
		WebdriverUtilities wlib=new WebdriverUtilities();
		
		HomePage hp=new HomePage(driver);
		hp.getStaffloginbtn().click();
		StaffLoginPage sl=new StaffLoginPage(driver);
		sl.setSidLogin();
		StaffActivityPage sap=new StaffActivityPage(driver);
		sap.getCreditcustbtn().click();
		CreditDetailPage cd=new CreditDetailPage(driver);
		cd.setFundTransfer();
		String text=wlib.getTextFromAlertPopup(driver);
		wlib.alertPopupAccept(driver);
		System.out.println(text);
		
		
	}

}
