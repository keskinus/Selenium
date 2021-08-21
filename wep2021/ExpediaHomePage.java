package wat2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ExpediaHomePage extends LoadableComponent<ExpediaHomePage> {
	private static final String URL = "https://www.expedia.com/";
	private WebDriver driver;
	
	@FindBy(css = "a[href='?pwaLob=wizard-flight-pwa']")
	private WebElement flightsTab;
	
	protected void load() {
		driver.get(URL);
	}
	
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		if (!url.contains("expedia")) {
			throw new Error("Invalid page");
		}
	}
	
	public ExpediaHomePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public ExpediaFlightsTab switchToFlightsTab() {
		flightsTab.click();
		
		return new ExpediaFlightsTab(driver);
	}
}
