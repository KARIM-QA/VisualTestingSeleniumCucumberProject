package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;

public class steps_origin extends BaseClass {

	@Given("Open Browser")
	public void open_browser() {
		setBatch();
		WebDriverManager.chromedriver().setup();
		
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		loginPage = new LoginPage(myDriver);
		eyes.open(myDriver, "Validation Customer infos", "Customer infos Test");
	}

	/***************** Login Feature **********************************/

	@When("User open URL {string}")
	public void user_open_url(String url) {

		myDriver.get(url);
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		eyes.checkWindow("Admin Area");
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {

		loginPage.setUsername(email);
		loginPage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {

		loginPage.clickLogin();
	}
	
	/***************** Customer Feature **********************************/

	// add Customers feature methods to step definitions

	@Then("User can view Dashbord")
	public void user_can_view_dashbord() {

		addCustomersPage = new AddCustomersPage(myDriver);

		Assert.assertEquals("Dashboard / nopCommerce administration", addCustomersPage.GetTitle()); // verification du
																									// titre de la page
		//eyes.checkWindow("HomePage Area");
	}

	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {

		Thread.sleep(2000);
		addCustomersPage.click_on_customers_menu();

	}

	@When("Click on Customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {

		Thread.sleep(2000);

		addCustomersPage.click_on_customers_menu_item();

	}

	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {

		addCustomersPage.click_on_add_new_button();
		Thread.sleep(2000);
	}

	@Then("User can view add new Customer Page")
	public void user_can_view_add_new_customer_page() {

		Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomersPage.GetTitle());
	}

	@When("User enter Customer info")
	public void user_enter_customer_info() throws InterruptedException {

		String email = RandomString() + "@gmail.com"; // RandomString() est crée dans BaseClass.java

		addCustomersPage.setEmail(email);
		addCustomersPage.setPassword("QA_AUTOMATION");
		addCustomersPage.setFirstName("KARIM");
		addCustomersPage.setLastName("LARIBI");
		addCustomersPage.setGender("male");
		addCustomersPage.setDateOfBirth("5/22/2005");
		addCustomersPage.setCompanyName("QualityBoost");
		addCustomersPage.checkboxExemptTax();
		addCustomersPage.setNewsletter();
		// addCustomersPage.setCustomerRole("Guests");
		addCustomersPage.setManagerOfVendor("Vendor 1");
		addCustomersPage.setadminComment("Hello Testers :) ");

		// Visual info customer interface
		// eyes.open(myDriver, "Validation add Customer info", "Add Customer info
		// Test");
		eyes.checkWindow("Customer Info Interface");

		eyes.close();

	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		addCustomersPage.click_on_save_button();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) throws Exception {

		Assert.assertTrue(myDriver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissable\"]"))
				.getText().contains("The new customer has been added successfully."));

	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {

		loginPage.clickLogout();
		Thread.sleep(3000);

	}

	@Then("Close  browser")
	public void close_browser() throws Exception {

		myDriver.quit();
		eyes.abortIfNotClosed();

	}

}
