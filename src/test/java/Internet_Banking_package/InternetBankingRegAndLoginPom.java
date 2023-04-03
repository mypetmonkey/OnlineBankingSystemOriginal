package Internet_Banking_package;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.WebdriverUtilities;
import com.ObjectRepo_package.HomePage;
import com.ObjectRepo_package.IBLoginPage;
import com.ObjectRepo_package.InternetBankingRegistrationPage;


public class InternetBankingRegAndLoginPom  extends BaseClass{
	@Test(priority = 3)
	public void ibRegLog() throws Throwable {
		
		WebdriverUtilities wlib=new WebdriverUtilities();
		
		HomePage hp=new HomePage(driver);
		WebElement ele = hp.getIbbtn();
		wlib.mouseHover(driver, ele);
		hp.getIbregopt().click();
		InternetBankingRegistrationPage ibr=new InternetBankingRegistrationPage(driver);
		ibr.setibRegistration();
		String text = wlib.getTextFromAlertPopup(driver);
		System.out.println(text);
		System.out.println("your customer ID is :1011440 and password is Rajhans" );
		wlib.alertPopupDismiss(driver);
		//IBLoginPage ibl=new IBLoginPage(driver);
		//ibl.setIBLogin();
		
	}

}
