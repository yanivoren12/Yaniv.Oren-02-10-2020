package selenium;

import org.openqa.selenium.By;

public class WebElementDetails {

	public final By locator;
	public final String description;
	
	public WebElementDetails (By locator, String description) {
		this.locator = locator;
		this.description = description;
	}
	
}
