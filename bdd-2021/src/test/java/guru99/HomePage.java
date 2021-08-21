package guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(css = "body > table > tbody > tr > td > table > tbody > tr.heading3 > td")
	private WebElement mangerId;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getMangerId() {
		return mangerId.getText();
	}
	
	public NavBar1 getNavBar() {
		return new NavBar1(driver);
	}
}
