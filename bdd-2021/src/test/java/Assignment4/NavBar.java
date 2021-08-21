package Assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {
	private WebDriver driver;
	
	@FindBy(css = "ul.menusubnav a[href='BalEnqInput.php']")
	private WebElement balanceEnquiryEntry;
	
	public NavBar(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public BalanceEnquiryPage gotoBalanceEnquiryPage() {
		balanceEnquiryEntry.click();	
		return new BalanceEnquiryPage(driver);
	}
}


