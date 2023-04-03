package view_Active_customer_package;


import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo_package.ActiveCustomerPage;
import com.ObjectRepo_package.HomePage;
import com.ObjectRepo_package.StaffActivityPage;
import com.ObjectRepo_package.StaffLoginPage;


public class ViewActiveCustomerPom extends BaseClass{
	@Test(priority = 5)
	public void ViewCustActive() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.getStaffloginbtn().click();
		StaffLoginPage sl=new StaffLoginPage(driver);
		sl.setSidLogin();
		StaffActivityPage saf=new StaffActivityPage(driver);
		saf.getViewactcustbtn().click();
		ActiveCustomerPage ac=new ActiveCustomerPage(driver);
		String all = ac.getActivetable().getText();
		//System.out.println(all);
	
	}
}
				
		
		
	


