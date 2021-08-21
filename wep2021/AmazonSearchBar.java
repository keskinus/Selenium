package wat2021;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchBar {
	private WebDriver driver;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchInput;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement searchIcon;
	
	public AmazonSearchBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AmazonResultPage search(String keyword) {
		searchInput.clear();
		searchInput.sendKeys(keyword);
		searchIcon.click();
		
		return new AmazonResultPage(driver);
	}
}

