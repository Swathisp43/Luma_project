package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{
	
	WebDriver driver;
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "(//a[contains(text(),'Sign In')])[1]")  WebElement link_Signin;
	@FindBy(xpath = "(//a[contains(text(), 'Create an Account')])[1]") WebElement link_NewAcc;
	
	public void ClickSignin() {
		link_Signin.click();
	}
	
	public void ClickNewAcc() {
		link_NewAcc.click();
	}

}
