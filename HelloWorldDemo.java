import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/helloworld.html");

	}

}