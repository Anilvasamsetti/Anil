package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="mat-input-1")
	WebElement mail;
	@FindBy(xpath="//span[normalize-space()='Login with password']")
	WebElement passbutton;
	@FindBy(xpath="/html/body/app-root/main/mat-sidenav-container/mat-sidenav-content/section/core-auth/div/app-sign-in-wrapper/section/mat-card/div/div/div[1]/core-sign-in/form/mat-form-field/div/div[1]/div[4]/input")
	WebElement textpass;
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginbutton;
	@FindBy(xpath="//span[@class='selected-option ng-tns-c358-2']")
	WebElement categoriesbtn;
	@FindBy(xpath = "//span[@class='ng-tns-c358-2'][normalize-space()='Logout']")
	WebElement Logout;

	public void setmail(String email)
	{

		mail.sendKeys(email);
	}
	public void setpassbutton()
	{

		passbutton.click();
	}
	public void setpassword(String pass)

	{

		textpass.sendKeys(pass);
	}
	public void setlogin()

	{
		loginbutton.click();
	}
	public void setcategories()

	{
		categoriesbtn.click();
	}
	public void SetLogout()

	{
		Logout.click();
	}
}
