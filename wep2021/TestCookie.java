package wat2021;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import java.util.Set;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.Cookie;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class TestCookie {
	private WebDriver driver;
		
		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			driver = new ChromeDriver();		
		}
		
		@After
		public void tearDown() {
			driver.quit();
		}
		
		@Test
		public void testCookie() {
			driver.get("http://localhost:8080/workspace/cookie.php");	
			
			Set<Cookie> cookies = driver.manage().getCookies();
			assertEquals(2, cookies.size());
			
			assertEquals("JohnDoe", driver.manage().getCookieNamed("user").getValue());
			assertEquals("secret", driver.manage().getCookieNamed("password").getValue());
			
			for (Cookie c : cookies) {
				System.out.println(c.getName());
				System.out.println(c.getValue());
				System.out.println(c.getDomain());
				System.out.println(c.getPath());
				System.out.println(c.getExpiry());
			}
		}
	}


