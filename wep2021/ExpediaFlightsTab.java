package wat2021;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpediaFlightsTab {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//div[@title='Leaving from']//span[text()='Leaving from']/preceding-sibling::button[1]")
	private WebElement fromButton;
	@FindBy(css = "div[title='Leaving from'] input[placeholder='Where are you leaving from?']")
	private WebElement fromInput;
	@FindBy(css = "div[title='Leaving from'] [data-stid='location-field-leg1-origin-results'] button")
	private WebElement fromSuggestion;
	
	@FindBy(xpath = "//div[@title='Going to']//span[text()='Going to']/preceding-sibling::button[1]")
	private WebElement toButton;
	@FindBy(css = "div[title='Going to'] input[placeholder='Where are you going to?']")
	private WebElement toInput;
	@FindBy(css = "div[title='Going to'] [data-stid='location-field-leg1-destination-results'] button")
	private WebElement toSuggestion;

	@FindBy(xpath = ".//button[text()='Search']")
	private WebElement searchBtn;
	
	public ExpediaFlightsTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ExpediaFlightsResult searchFlight(String departure, String destination) {
		enterFrom(departure);
		enterTo(destination);
		search();
		
		return new ExpediaFlightsResult(driver);
	}
	
	private void enterFrom(String departure) {
		fromButton.click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(fromInput));
		fromInput.click();
		fromInput.clear();
		fromInput.sendKeys(departure);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(fromSuggestion));
		fromSuggestion.click();
	}

	private void enterTo(String destination) {
		toButton.click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(toInput));
		toInput.click();
		toInput.clear();
		toInput.sendKeys(destination);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(toSuggestion));
		toSuggestion.click();
	}
	
	private void search() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchBtn.click();
	}
}
