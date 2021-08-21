package guru99;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepDefs {
	private WebDriver driver;
	private HomePage home;
	private EditCustomerPage edit;
	private CustomerResultPage result;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("^a user has logged in with user id %([^%]*)% and password %([^%]*)%$")
	public void userHasLoggedIn(String userId, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUserId(userId);
		login.enterPassword(password);
		home = login.submit();
	}
	
	@And("he is on the Edit Customer page")
	public void userOnEditCustomerPage() {
		NavBar1 navBar = home.getNavBar();
		edit = navBar.gotoEditCustomerPage();
	}
	
	@When("^he submits %([^%]*)% as the customer id$")
	public void userSubmitsCustomerId(String customerId) {
		result = edit.queryCustomer(customerId);
	}
	
	@Then("^ensure the customer name is %([^%]*)%$")
	public void ensureName(String name) {
		assertEquals(name, result.getName());
	}

	@And("^ensure the customer gender is %([^%]*)%$")
	public void ensureGender(String gender) {
		assertEquals(gender, result.getGender());
	}
	
	@And("^ensure the customer dob is %([^%]*)%$")
	public void ensureDob(String dob) {
		assertEquals(dob, result.getDob());
	}

}
