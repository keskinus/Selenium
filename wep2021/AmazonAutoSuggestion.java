package wat2021;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAutoSuggestion {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.clear();
		input.sendKeys("selenium");
		
		// wait until the auto-suggestion box is visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-flyout-searchAjax")));
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ENTER);
	}

	
}
