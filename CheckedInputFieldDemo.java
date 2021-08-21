
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class CheckedInputFieldDemo {

		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8080/workspace/checkbox.html");		

			List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
			for (WebElement checkbox: checkboxes) {
				System.out.println(checkbox.getAttribute("checked"));
			}
		}

	}



