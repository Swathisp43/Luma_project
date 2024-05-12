package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends Baseclass{
	
	@Test(groups = {"regression"} , dataProvider = "LoginData", dataProviderClass = DataProviders.class  )
	public void verify_LoginDDT(String email, String password, String exp) {
		logger.info("*** Started TC_003_LoginDDT ***");  //log4j2
		try {
		Homepage hp = new Homepage(driver);
		hp.ClickSignin(); 
		
		Loginpage lp = new Loginpage(driver);
		lp.UserEmail(email);
		lp.Userpswd(password);
		lp.ClickSignin();
		
		MyAccountpage myacc = new MyAccountpage(driver);
		Boolean targetpage = myacc.Ismyaccountpageexists();
		
		if(exp.equals("valid")) {
			
			if(targetpage ==true) {
				myacc.btnSignout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equals("invalid")) {
			
			if(targetpage == true) {
				myacc.btnSignout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
		Assert.fail();	
		}
		
		logger.info("*** Finished TC_003_LoginDDT ***");  //log4j2
	}
}
	


