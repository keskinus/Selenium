import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDemo {

	public static void main(String[] args) {
		System.setProperty(
			"webdriver.chrome.driver",
			"./drivers/chromedriver"
		);
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");
		
		// I am in the amazon home page
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys("Harry Potter");
		
		WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
		searchIcon.click();
	}

}
