import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxisDemo3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/xpath.html");

		WebElement ancestor = driver.findElement(By.xpath(
//			"//p[@id='bye']/ancestor::*[@class='a-row']" // won't work
			"//p[@id='bye']/ancestor::*[contains(@class, 'a-row')][1]"
		));
		System.out.println(ancestor.getAttribute("id"));
		driver.quit();
	}
}
