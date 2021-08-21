package wat2021;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class LocatorMap {
	private Properties properties;
	
	public LocatorMap(String mapFile) {
		properties = new Properties();
		
		try {
			FileInputStream in = new FileInputStream(mapFile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public By getLocator(String elementName) {
		String locator = properties.getProperty(elementName);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		
		switch (locatorType.toLowerCase()) {
		case "id":
			return By.id(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "tagname":
			return By.tagName(locatorValue);
		case "css":
			return By.cssSelector(locatorValue);
		case "xpath":
			return By.xpath(locatorValue);
		default:
			return null;
		}
	}

}
