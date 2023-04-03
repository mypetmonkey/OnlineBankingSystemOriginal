 package Open_Account_Packages;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;
import com.ObjectRepo_package.Account_Opening_Form_page;
import com.ObjectRepo_package.Approve_AC_page;
import com.ObjectRepo_package.HomePage;
import com.ObjectRepo_package.StaffActivityPage;
import com.ObjectRepo_package.StaffLoginPage;


public class AccountOpeningPom extends BaseClass{
	
	WebdriverUtilities wlib=new WebdriverUtilities();
	JavaUtilities jlib=new JavaUtilities();
	
	@Test( groups = "system")
	public void AccountOpen () throws Throwable {
		
		
		HomePage hp=new HomePage(driver);
		hp.getOpenacbtn().click();
		
		Account_Opening_Form_page ao=new Account_Opening_Form_page(driver);
		ao.setCustomerDetais(driver);
		String text = wlib.getTextFromAlertPopup(driver);
	 String apno = jlib.getPopupDigits(text);
		wlib.alertPopupAccept(driver);
		hp.getStaffloginbtn().click();
		
		StaffLoginPage sl=new StaffLoginPage(driver);
		sl.setSidLogin();
		
		StaffActivityPage sap=new StaffActivityPage(driver);
		sap.getApprovebtn().click();
		
		Approve_AC_page ap=new Approve_AC_page(driver);
		ap.setApproveAccount(driver, apno);
		System.out.println("welcome to my bank");
		System.out.println("now you are elligible for apply debit card");
		
	}

}
