package wat2021;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpediaFlightsResult extends LoadableComponent<ExpediaFlightsResult>{
	private WebDriver driver;

	@FindBy(css = ".uitk-loading-bar")
	private WebElement loadingBar;
	@FindBy(xpath = "//button[text()='Show More']")
	private WebElement showMore;

	@FindAll({
		@FindBy(css = "li[data-test-id='offer-listing'] > [data-test-id='intersection-observer']")
	})
	private List<WebElement> flights;
	private LocatorMap flightsMap;
	
	
	protected void load() {}
	protected void isLoaded() throws Error {
		if (!isResultSearchable()) {
			throw new Error("Failed to search");
		}
	}
	
	private boolean isResultSearchable() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
//			wait.until(ExpectedConditions.invisibilityOf(loadingBar));
//			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(showMore));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public ExpediaFlightsResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		flightsMap = new LocatorMap("properties/expedia.property");
	}
	
	public void report() {
		for (WebElement flight : flights) {
			WebElement timeline = flight.findElement(flightsMap.getLocator("timeline"));			
			WebElement price = flight.findElement(flightsMap.getLocator("price"));
			System.out.println(timeline.getText());
			System.out.println(price.getText());
		}

	}
}
