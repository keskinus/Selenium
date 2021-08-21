package wat2021;

import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
	private static final String URL = "https://www.amazon.com/";
	private WebDriver driver;
	 
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		this.driver.get(URL);
	}
	
	public AmazonSearchBar getSearchBar() {
		return new AmazonSearchBar(driver);
	}
}
