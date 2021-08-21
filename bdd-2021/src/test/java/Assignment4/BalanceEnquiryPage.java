package Assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiryPage {
	private WebDriver driver;
	
	@FindBy(name = "accountno")
	private WebElement accountNoField;
	
	@FindBy(name = "AccSubmit")
	private WebElement submitBtn;
	
	public BalanceEnquiryPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);		
	}
	
	public BalanceResultPage queryBalance(String accountNo) {
		accountNoField.clear();
		accountNoField.sendKeys(accountNo);
		submitBtn.click();
		
		return new BalanceResultPage(driver);
	}
}
