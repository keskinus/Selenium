package wat2021;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2Pom {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		ExpediaHomePage home = new ExpediaHomePage(driver);
		home.get();
		ExpediaFlightsTab flightsTab = home.switchToFlightsTab();
		ExpediaFlightsResult result = flightsTab.searchFlight("sfo", "nyc");
		result.get();
		result.report();
	}

}

//span[@class="location accessible-contrast-color-location"]