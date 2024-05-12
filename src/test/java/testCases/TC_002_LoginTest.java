package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountpage;
import testBase.Baseclass;

public class TC_002_LoginTest extends Baseclass{
	
	@Test(groups = {"sanity", "master"})
	public void Verify_Login() {
		logger.info("*** Started TC_002_LoginTest ***");  //log4j2
		try{
		Homepage hp = new Homepage(driver);
		hp.ClickSignin();
		logger.info("Clicked on signin link"); 
		Loginpage lp = new Loginpage(driver);
		lp.UserEmail(p.getProperty("Email"));
		lp.Userpswd(p.getProperty("password"));
		lp.ClickSignin();
		logger.info("Clicked on signin button"); 
	/*	MyAccountpage mp = new MyAccountpage(driver);
		boolean targetpage = mp.msgheading();
		if(targetpage==true) {
			logger.info("Login test passed"); 
			Assert.assertTrue(true);
		}
		else{
			logger.error("Login test failed"); 
			Assert.fail();	
		}*/
		if(driver.getTitle().equals("Home Page")) {
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Test failed");
			Assert.fail();
		}
		}
		catch(Exception e) {
			Assert.fail();
			System.out.println(e.getMessage());
		}
		logger.info("*** Finished  TC_002_LoginTest ***");	
	}

}
