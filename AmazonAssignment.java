package odev;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAssignment {
private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testSearch() {
		WebElement SearchElement = driver.findElement(By.id("twotabsearchtextbox"));
		SearchElement.sendKeys("Selenium Webdriver Book");
		WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
		searchIcon.click();
		List<WebElement> books = driver.findElements(By.xpath("//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16']"));

		if (books.size() > 0) {
	            String title, price;

	            for (int i = 0; i < books.size(); i++) {
	                title = books.get(i).findElement(By.cssSelector("h2")).getText();
	                price = books.get(i).findElement(By.cssSelector("div[class='a-section a-spacing-none a-spacing-top-small']")).getText();
	               
	                boolean found = false;
	                if(price.contains("Paperback")) {
	                	found = true;
	                	String[] price1 = price.split("\n");
	            		System.out.println("Book title is: "+title + "\n"+ "Book Price is:"+  price1[1] +"."+price1[2]);
	            		System.out.println("<======================================>");
	                }

	            if(!found) {
			System.out.println("Book title is: "+title + "\n"+ "Book Price is:"+"No paperback price");
			System.out.println("<======================================>");
		
	}
	            }
		}
	}
}
	
	
	

