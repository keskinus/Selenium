import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxisDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/workspace/xpath.html");
		
		WebElement bye = driver.findElement(By.xpath("//p[@id='bye']"));
		System.out.println(bye.getText());
		
		WebElement parent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[1]"));
		System.out.println(parent.getAttribute("id"));

		WebElement grandParent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[2]"));
		System.out.println(grandParent.getAttribute("id"));

		WebElement grandGrandParent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[3]"));
		System.out.println(grandGrandParent.getAttribute("id"));
		
		WebElement parent2 = driver.findElement(By.xpath("//p[@id='bye']/.."));
		System.out.println(parent2.getAttribute("id"));
		
		WebElement parent3 = driver.findElement(By.xpath("//p[@id='bye']/parent::*"));
		System.out.println(parent3.getAttribute("id"));
		
		driver.quit();
	}
}
