package guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar1 {
	private WebDriver driver;
	
	@FindBy(css = "ul.menusubnav a[href='EditCustomer.php']")
	private WebElement editCustomerEntry;
	
	public NavBar1(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public EditCustomerPage gotoEditCustomerPage() {
		editCustomerEntry.click();
		
		return new EditCustomerPage(driver);
	}
}
