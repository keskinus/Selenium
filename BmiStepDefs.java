package bmi;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BmiStepDefs {
	private WebDriver driver;
	private BmiPage page;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("^the user is on the BMI Calculate page$")
	public void theUserOnBmiPage() {
		page = new BmiPage(driver);
	}
	
	@When("^he enters \"([^\"]*)\" as height$")
	public void theUserEntersHeight(String height) {
		page.setHeight(height);
	}
	
	@And("^he enters \"([^\"]*)\" as weight$")
	public void theUserEntersWeight(String weight) {
		page.setWeight(weight);
	}
	
	@And("^he clicks the Calculate button$")
	public void theUserClicksCalculateBtn() {
		page.calculate();
	}
	
	@Then("^ensure the bmi category is \"([^\"]*)\"$")
	public void ensureBmiCategory(String category) {
		assertEquals(category, page.getBmiCategory());
	}
}
