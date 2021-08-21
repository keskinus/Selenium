package wat2021;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1Simplifed {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		AmazonHomePage home = new AmazonHomePage(driver);
		AmazonSearchBar searchBar = home.getSearchBar();
		AmazonResultPage result = searchBar.search("Selenium WebDriver book");
		result.printTitles();
		
		driver.quit();
	}

}
