package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;

public class AddCustomersPage extends BaseClass {

	//public WebDriver myDriver;

	public AddCustomersPage(WebDriver remoteDriver) {

		myDriver = remoteDriver;

		PageFactory.initElements(remoteDriver, this);
	}

	By linkCustomersMenu = By.xpath("(//a[@class='nav-link'])[21]");

	By linkCustomersMenuItem = By.xpath("//a[@href='/Admin/Customer/List']");

	By btnAddNew = By.xpath("//a[normalize-space()='Add new']");

	By txtemail = By.xpath("//input[@id='Email']");

	By txtpassword = By.xpath("//input[@id='Password']");

	By txtfirstName = By.xpath("//input[@id='FirstName']");

	By txtlastName = By.xpath("//input[@id='LastName']");

	By maleGender = By.id("Gender_Male");

	By femaleGender = By.id("Gender_Female");

	By doBirth = By.xpath("//input[@id='DateOfBirth']");

	By companyName = By.xpath("//input[@id='Company']");

	By taxExempt = By.xpath("//input[@id='IsTaxExempt']");

	By newsletter = By.xpath("//div[@class='input-group-append']//div[@role='listbox']");

	By value_newsletter = By.xpath("//li[normalize-space()='Test store 2']");

	By customerRole = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");

	By delete_default_CustomerRole = By.xpath("(//span[@title='delete'])[2]");

	By listItemAdminitrators = By.xpath("//li[contains(text(),'Administrators')]"); // item Administrators

	By forumModeratos = By.xpath("//li[contains(text(),'Forum Moderators')]"); // item Forum Moderators

	By guests = By.xpath("//li[contains(text(),'Guests')]"); // item Guests

	By registered = By.xpath("//li[contains(text(),'Registered')]"); // item Registered

	By vendors = By.xpath("//li[contains(text(),'Vendors')]"); // item Vendors

	By managerOfvendor = By.xpath("//select[@id='VendorId']");

	By radioActive = By.xpath("//input[@id='Active']");

	By adminContent = By.xpath("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//button[@name='save']");

	/*********************************************************************************************************************/

	// Actions methods

	public String GetTitle() {

		return myDriver.getTitle();
	}

	public void click_on_customers_menu() {

		myDriver.findElement(linkCustomersMenu).click();
	}

	public void click_on_customers_menu_item() {

		myDriver.findElement(linkCustomersMenuItem).click();
	}

	public void click_on_add_new_button() {

		myDriver.findElement(btnAddNew).click();
	}

	public void setEmail(String email) {

		myDriver.findElement(txtemail).sendKeys(email);
	}

	public void setPassword(String password) {

		myDriver.findElement(txtpassword).sendKeys(password);
	}

	public void setFirstName(String firstname) {

		myDriver.findElement(txtfirstName).sendKeys(firstname);
	}

	public void setLastName(String lastname) {

		myDriver.findElement(txtlastName).sendKeys(lastname);
	}

	public void setGender(String gender) {

		if (gender.equals("male")) {

			myDriver.findElement(maleGender).click();

		} else if (gender.equals("female")) {

			myDriver.findElement(femaleGender).click();
		}
	}

	public void setDateOfBirth(String dob) {

		myDriver.findElement(doBirth).sendKeys(dob);
	}

	public void setCompanyName(String cname) {

		myDriver.findElement(companyName).sendKeys(cname);
	}

	public void checkboxExemptTax() {

		WebElement tax = myDriver.findElement(taxExempt);

		tax.click();

		// Check whether the Check box is toggled on
		if (tax.isSelected()) {

			System.out.println("Checkbox is Toggled On");

		} else {

			System.out.println("Checkbox is Toggled Off");
		}

	}

	public void setNewsletter() {

		myDriver.findElement(newsletter).click();

		WebDriverWait wait = new WebDriverWait(myDriver, 10);

		WebElement divElement = wait.until(ExpectedConditions.elementToBeClickable(value_newsletter));
		divElement.click();

	}

	/*
	 * public void setCustomerRole(String role) throws InterruptedException {
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) AddCustomersPageDriver;
	 * 
	 * WebElement CustRole;
	 * 
	 * AddCustomersPageDriver.findElement(delete_default_CustomerRole).click();
	 * CustRole = AddCustomersPageDriver.findElement(customerRole);
	 * //CustRole.clear();
	 * 
	 * Thread.sleep(1000);
	 * 
	 * //CustRole.click(); js.executeScript("arguments[0].click() ; ", CustRole);
	 * 
	 * WebElement listItem =
	 * AddCustomersPageDriver.findElement(listItemAdminitrators);
	 * 
	 * if (role.equals("Administrators")) {
	 * 
	 * listItem = AddCustomersPageDriver.findElement(listItemAdminitrators);
	 * 
	 * } else if (role.equals("Forum Moderators")) {
	 * 
	 * listItem = AddCustomersPageDriver.findElement(forumModeratos); }
	 * 
	 * else if (role.equals("Guests")) {
	 * 
	 * ((WebElement) AddCustomersPageDriver).findElement(registered).clear();
	 * 
	 * listItem = AddCustomersPageDriver.findElement(guests);
	 * 
	 * 
	 * }
	 * 
	 * else if (role.equals("Registered")) {
	 * 
	 * listItem = AddCustomersPageDriver.findElement(registered); }
	 * 
	 * else if (role.equals("Vendors")) {
	 * 
	 * listItem = AddCustomersPageDriver.findElement(vendors); }
	 * 
	 * 
	 * 
	 * js.executeScript("arguments[0].click() ; ", listItem);
	 * 
	 * }
	 */
	public void setManagerOfVendor(String value) {

		Select Manager = new Select(myDriver.findElement(managerOfvendor));

		Manager.selectByVisibleText(value);
	}

	public void setadminComment(String Comment) throws InterruptedException {

		myDriver.findElement(adminContent).sendKeys(Comment);
		Thread.sleep(2000);
	}

	public void click_on_save_button() {

		myDriver.findElement(btnSave).click();
	}

}
