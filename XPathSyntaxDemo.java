import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathSyntaxDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/divs.html");
		
//		WebElement p = driver.findElement(By.xpath("//p"));

		WebElement id1 = driver.findElement(By.id("id1"));
//		WebElement p = id1.findElement(By.xpath("/p")); // NoSuchElementException
//		WebElement p = id1.findElement(By.xpath("//p")); // Hello
//		WebElement p = id1.findElement(By.xpath("./p")); // World
		WebElement p = id1.findElement(By.xpath(".//p")); // World
		System.out.println(p.getText());
		driver.quit();
	}
	
}
