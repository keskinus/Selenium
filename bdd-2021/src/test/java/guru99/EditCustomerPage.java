package guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	private WebDriver driver;
	
	@FindBy(name = "cusid")
	private WebElement customerIdField;
	
	@FindBy(css = "input[type='submit'][value='Submit']")
	private WebElement submitBtn;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);		
	}
	
	public CustomerResultPage queryCustomer(String customerId) {
		customerIdField.clear();
		customerIdField.sendKeys(customerId);
		submitBtn.click();
		
		return new CustomerResultPage(driver);
	}
}
