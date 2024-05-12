package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.NewAccountpage;
import testBase.Baseclass;

public class TC_001_NewAccountTest extends Baseclass{
	
	@Test(groups = {"regression", "master"})
	public void Verify_NewAccount() {
		logger.info(" ****** Starting TC_001_NewAccountTest ****** ");
		logger.debug("***Started debugging***");
		try {
		Homepage hp = new Homepage(driver);
		hp.ClickNewAcc();
		logger.info(" ****** Creating New Account ****** ");
		NewAccountpage NewAcc =new NewAccountpage(driver);
		
		logger.info(" ****** Providing user details ****** ");
		NewAcc.SetFrstName(randomstring().toUpperCase());
		NewAcc.SetLastName(randomstring());
		NewAcc.SetEmail(randomstring()+ "@yopmail.com");
		String password = "Test123456";
		NewAcc.SetPswd(password);
		NewAcc.CnfmPswd(password);
		NewAcc.btnNewAcc();
		logger.info(" ****** Validating confirmation message ****** ");
		
		if(NewAcc.cnfmsg().equals("Thank you for registering with Main Website Store.")) {
			logger.info("Test passsed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			Assert.fail();			
		}
	//	Assert.assertEquals(NewAcc.cnfmsg(), "Thank you for registering with Main Website Store.");
		}
		catch(Exception e) {
			logger.error("Test failes");
			Assert.fail();
		}
		logger.info(" ****** Finished TC_001_NewAccountTest ****** ");
	
		
	}
	

}
