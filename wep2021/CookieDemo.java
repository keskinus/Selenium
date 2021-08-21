package wat2021;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		// You have to land on the server first with the domain name ready.
		driver.get("http://localhost:8080/workspace/helloworld.html");
		
		// Your cookie does not need a domain name.
		Cookie userCookie = new Cookie(
			"user", "Jack Jones", "/", null
		);
		
		driver.manage().addCookie(userCookie);
		driver.get("http://localhost:8080/workspace/cookie.php");
		
//		Thread.sleep(3000);
//		
//		driver.get("http://localhost:8080/workspace/cookie.php");
	}

}
