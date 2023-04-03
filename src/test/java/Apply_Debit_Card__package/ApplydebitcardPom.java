package Apply_Debit_Card__package;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;
import com.ObjectRepo_package.DebitCardFormPage;
import com.ObjectRepo_package.HomePage;


@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class ApplydebitcardPom extends BaseClass {
	@Test(priority = 2)
	public void applyDebit() throws Throwable {
		
		WebdriverUtilities wlib=new WebdriverUtilities();
		JavaUtilities jlib=new JavaUtilities();
		
		HomePage hp=new HomePage(driver);
		hp.getApplydebitbtn().click();
		//Assert.fail(); 
		DebitCardFormPage df=new DebitCardFormPage(driver);
		df.debitCardForm();
		String text=wlib.getTextFromAlertPopup(driver);
		String cardno = jlib.getPopupDigits(text);
		System.out.println("your debit card no is :"+cardno+"  and pin is :"+8281);
		wlib.alertPopupAccept(driver);
		
		
	}

}
