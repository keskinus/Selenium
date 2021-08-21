package guru99;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private Alert alert;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("a user is on the login page")
	public void userOnLoginPage() {
		login = new LoginPage(driver);
	}

	@When("^he enters %([^%]*)% as user id$")
	public void heEntersUserId(String userId) {
		login.enterUserId(userId);
	}
	
	@And("^he enters %([^%]*)% as password$") 
	public void heEntersPassword(String password) {
		login.enterPassword(password);
	}
	
	@And("he submits the correct credential")
	public void heSubmits() {
		home = login.submit();
	}
	
	@And("he submits the wrong credential")
	public void heSubmitsWrongCredential() {
		alert = login.submitWithWrongCredential();
	}
	
	@Then("^ensure the Manger Id is %([^%]*)%$")
	public void ensureMangerId(String mangerId) {
		assertTrue(home.getMangerId().endsWith(mangerId));
	}
	
	@Then("^ensure the alert message of %([^%]*)%$")
	public void ensureAlert(String message) {		
		assertEquals(message, alert.getText());
	}
}
