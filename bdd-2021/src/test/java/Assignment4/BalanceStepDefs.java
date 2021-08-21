package Assignment4;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BalanceStepDefs {
	private WebDriver driver;
	private HomePage home;
	private BalanceEnquiryPage enquiry;
	private BalanceResultPage result;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^a user has logged in with user id %([^%]*)% and password %([^%]*)%")
	public void userserOnLoggedIn(String userId, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUserId(userId);
		login.enterPassword(password);
		home = login.submit();
	}
	@And("he is on the Balance Enquiry page")
	public void userOnBalanceEnquiryPage() {
		NavBar navBar = home.getNavBar();
		enquiry= navBar.gotoBalanceEnquiryPage();
	}

	@When("^he submits %([^%]*)% as the account no$")
	public void userSubmitsAccountNo(String accountNo) {
		result = enquiry.queryBalance(accountNo);
}
	
	@Then("^ensure the account no is %([^%]*)%$")
	public void ensureAccount(String account) {
	assertEquals(account, result.getAccount());
}

	@And("^ensure the account type is %([^%]*)%$")
	public void ensureAccountType(String type) {
	assertEquals(type, result.getType());
}

	@And("^ensure the account balance is %([^%]*)%$")
	public void ensureAccountBalance(String balance) {
	assertEquals(balance, result.getBalance());
}

}



