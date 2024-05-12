package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {

	public Loginpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name="login[username]")  WebElement txt_email;
	@FindBy(name = "login[password]") WebElement txt_pswd;
	@FindBy(xpath ="(//span[contains(text(),'Sign In')])[1]") WebElement btn_signin;
	
	public void UserEmail(String Email) {
		txt_email.sendKeys(Email);
	}
	public void Userpswd(String pswd) {
		txt_pswd.sendKeys(pswd);
	}
	public void ClickSignin() {
		btn_signin.click();
	}
	
}
