package odev3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import wat2021.ExpediaFlightsResult;
import wat2021.ExpediaFlightsTab;
import wat2021.ExpediaHomePage;

public class Asignment3Pom {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		IndeedHomePage home = new IndeedHomePage(driver);
		home.get();
		IndeedResultPage result = home.("QA", "San Jose, CA");
		result.get();
		result.report();
	}

}


