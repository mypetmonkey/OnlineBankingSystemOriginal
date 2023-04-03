package Fund_Transfer_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;
import com.ObjectRepo_package.AddBeneficiaryPage;
import com.ObjectRepo_package.FeaturesForCustomerPage;
import com.ObjectRepo_package.FundTransferPage;
import com.ObjectRepo_package.HomePage;
import com.ObjectRepo_package.IBLoginPage;
import com.ObjectRepo_package.InternetBankingRegistrationPage;
import com.ObjectRepo_package.OtpVerifyPage;


public class FundTransferPom extends BaseClass{
	@Test(priority = 3, groups = "system")
	public void fundTransfer() throws Throwable {
		
		JavaUtilities jlib=new JavaUtilities();
		WebdriverUtilities wlib=new WebdriverUtilities();
		
		HomePage hp=new HomePage(driver);
		WebElement ele = hp.getIbbtn();
		wlib.mouseHover(driver, ele);
		hp.getIbregopt().click();
		InternetBankingRegistrationPage ibr=new InternetBankingRegistrationPage(driver);
		ibr.setibRegistration();
		String text = wlib.getTextFromAlertPopup(driver);
		System.out.println(text);
		wlib.alertPopupAccept(driver);
		
		IBLoginPage ibl=new IBLoginPage(driver);
		ibl.setIBLogin();
		FeaturesForCustomerPage fc=new FeaturesForCustomerPage(driver);
		fc.getFtlink().click();
		FundTransferPage ftp= new FundTransferPage(driver);
		ftp.getAddbenflink().click();
		AddBeneficiaryPage ab=new AddBeneficiaryPage(driver);
		ab.setaddBeneficiary();
		fc.getFtlink().click();
		ftp.setBeneficiaryToSend();
		String ele3 = driver.findElement(By.xpath("//label[@class='OTP_msg']")).getText();
		String data = jlib.getPopupDigits(ele3);
		System.out.println(data);
		String otp = jlib.getOtp(ele3);
		System.out.println("your otp is : "+otp);
		OtpVerifyPage ov=new  OtpVerifyPage(driver);
	    ov.setverifyotp(otp);
	   String al=wlib.getTextFromAlertPopup(driver);
	   System.out.println(al);
	   wlib.alertPopupAccept(driver);
		
	}

}
