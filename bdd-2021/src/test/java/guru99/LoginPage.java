package guru99;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private static final String URL = "http://demo.guru99.com/v4/";
	private WebDriver driver;
	
	@FindBy(name = "uid")
	private WebElement userIdField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(name = "btnLogin")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(URL);
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String userId) {
		userIdField.clear();
		userIdField.sendKeys(userId);
	}
	
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	// pre-condition: userId and password are correct
	public HomePage submit() {
		loginBtn.click();
		return new HomePage(driver);
	}
	
	// pre-condition: userId and password are invalid
	public Alert submitWithWrongCredential() {
		loginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		return driver.switchTo().alert();
	}
}
