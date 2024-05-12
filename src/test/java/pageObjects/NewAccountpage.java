package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountpage extends Basepage{
	
	WebDriver driver;
	public NewAccountpage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id= "firstname") 	WebElement txt_frstname;
	@FindBy(id = "lastname")	WebElement txt_lastname;
	@FindBy(id = "email_address")	WebElement txt_email;
	@FindBy(id = "password")	WebElement txt_pswd;
	@FindBy(id = "password-confirmation")	WebElement txt_cnfmpswd;
	@FindBy(xpath  = "(//span[contains(text(),'Create an Account')])[1]")	WebElement btn_newacc;
	@FindBy(xpath = "//div[contains(text(), \"Thank you for registering with Main Website Store.\")]")  WebElement cnfmsg;
	
	public void SetFrstName(String fname) {
		txt_frstname.sendKeys(fname);     
	}
	public void SetLastName(String lname) {
		txt_lastname.sendKeys(lname);      
	}
	public void SetEmail(String Email) {
		txt_email.sendKeys(Email);
	}
	public void SetPswd(String pwd) {
		txt_pswd.sendKeys(pwd);
	}
	public void CnfmPswd(String cnfpwd) {
		txt_cnfmpswd.sendKeys(cnfpwd);
	}
	public void btnNewAcc() {
		btn_newacc.click();
	}
	public String cnfmsg() {
		try {
		return cnfmsg.getText();
		}
		catch(Exception e) {
		return(e.getMessage());
		}
	}
}
