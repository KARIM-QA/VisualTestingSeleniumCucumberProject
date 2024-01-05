package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class LoginPage extends BaseClass {

	//public WebDriver myDriver;

	public LoginPage(WebDriver remoteDriver) {

		myDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	@CacheLookup
	WebElement buttonLogin;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement linkLogout;

	public void setUsername(String username) {

		txtEmail.clear();
		txtEmail.sendKeys(username);
	}

	public void setPassword(String password) {

		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {

		buttonLogin.click();

	}

	public void clickLogout() {

		linkLogout.click();

	}

}
