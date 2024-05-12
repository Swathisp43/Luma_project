package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends Basepage{

	public MyAccountpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="(//strong[contains(text(),'My Account')])[2]") WebElement msgheading;
	@FindBy(xpath ="//div[@class='panel header']//button[@type='button']")  WebElement DrpdownAccount;
	@FindBy(xpath ="//div[@class ='customer-menu']//li[3]")  WebElement btnSignout;
	
	
	public Boolean msgheading() {  
		try {
		return msgheading.isDisplayed();
		}
		catch(Exception e) {
			return(false);
		}
	}
	public void DrpdownAccount() {
		DrpdownAccount.click();
	}
	public Boolean Ismyaccountpageexists() {
	Boolean	myaccountpage=	driver.getTitle().equals("My Account");	
	return myaccountpage;
	
	}
	public void btnSignout() {
		btnSignout.click();
	}
	

}
