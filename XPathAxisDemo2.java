import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxisDemo2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/xpath.html");
		
		// outmost
		WebElement mystery = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*"));
		System.out.println(mystery.getTagName());
		// parent
		WebElement parent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[1]"));
		System.out.println(parent.getAttribute("id"));
		
		System.out.println("========");
		
		List<WebElement> ancestors = driver.findElements(By.xpath("//p[@id='bye']/ancestor::*"));
		for (WebElement ancestor: ancestors) {
			System.out.println(ancestor.getTagName() + ": " + ancestor.getAttribute("id"));
		}
		
		
		driver.quit();
	}
}
